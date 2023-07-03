package netflixpropstorage;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class recommendationSystem extends searchPage{

    LinkedList<String> allPropList = new LinkedList<>();
    LinkedList<String> userOrdersList = new LinkedList<>();
    LinkedList<String> userOrdersList2 = new LinkedList<>();
    LinkedList<String> propDetails1 = new LinkedList<>();
    LinkedList<String> propDetails2 = new LinkedList<>();
    LinkedList<String> propDetails3 = new LinkedList<>();
    LinkedList<String> record = new LinkedList<>(); //the linked list which will store the results from the rs
    LinkedList<String> publicRecommendationList = new LinkedList<>(); //stores the results of the function in a linked list 
    LinkedList<String> finalList = new LinkedList<>();      //stores the final set of values
    ResultSet resSet;
    boolean resultsFound=true;
    int temporary=0;
    
    //used to create a linked list which stores the ID of props which are most similar
    public LinkedList<String> generateRecc( String emailField){
        
        sqlConnection sC = new sqlConnection();
        
        accessProps(emailField);     //calls the access props function using the email found in parameter
        LinkedList<Integer> similarScores = new LinkedList<>();     //stores the similarity score of each prop
        
        for (int i = 0; i < sC.numberOfProps()+1; i++) {        //this creates a linked list with the size equal to the number of total props
            similarScores.add(0);       //fills the list with blank values which can be replaced
        }
        
        compareValues(propDetails1 , similarScores );     //runs the programme for prop1
        compareValues(propDetails2 , similarScores);      //same but for prop 2
        compareValues(propDetails3 , similarScores);      //same but for prop 3
        
        for (int i = 0; i < similarScores.size(); i++) {
                finalList.add(similarScores.get(i).toString());     //adds the values from similar scores to the final list
                String temp = finalList.get(i) + String.format("%03d", i);  //adds the index to the end and uses 3 digits
                finalList.set(i, temp); //sets each index to the value on the previous line which is the similarity + the index
        }
        
        reverseList rL = new reverseList(finalList.size());     //creates an instance of the reverse list class
        rL.mergeSort(finalList, 0,finalList.size() - 1);    //orders the final list using a merge sort based on the similarity values
        rL.reverse( finalList,  finalList.size());      //the previous sort is smallest to largest so this reverses using stack
        
        // finalList.get() means get that value from final list such as 2003
        // substring selects only the last 3 digits
        // replace first removes all leading zeros using regex
        System.out.println("this is the ID of the first most similar prop "+ finalList.get(0).substring(finalList.get(0).length() - 3).replaceFirst("^0+(?!$)", ""));
        publicRecommendationList.add(finalList.get(0).substring(finalList.get(0).length() - 3).replaceFirst("^0+(?!$)", ""));
        
        System.out.println("this is the ID of the second most similar prop "+ finalList.get(1).substring(finalList.get(0).length() - 3).replaceFirst("^0+(?!$)", ""));
        publicRecommendationList.add(finalList.get(1).substring(finalList.get(0).length() - 3).replaceFirst("^0+(?!$)", ""));
        
        System.out.println("this is the ID of the third most similar prop "+ finalList.get(2).substring(finalList.get(0).length() - 3).replaceFirst("^0+(?!$)", ""));
        publicRecommendationList.add(finalList.get(2).substring(finalList.get(0).length() - 3).replaceFirst("^0+(?!$)", ""));
        
        this.setVisible(false);
        return publicRecommendationList;
    }
    
    @Override   //polymorphs the similar function found in searchPage but works for linked lists
    public void resultSetToArray  (ResultSet resSet){
        record.clear(); //empties the linked list
        
        try {

            ResultSetMetaData metaData = (ResultSetMetaData) resSet.getMetaData(); 
            int columns = metaData.getColumnCount(); //get meta data and store the number of columns
            resSet.first();     //moves the result set to the first line
           
            //a loop which runs based on the number of columns to add the results to record
            for (int i = 1; i < columns+1; i++) {   
                        String value = resSet.getString(i);
                        record.add(value);
                }

            while (resSet.next()) { //loops  based on the number of results
                
                for (int i = 1; i < columns+1; i++) {
                        String value = resSet.getString(i);
                        record.add(value);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(searchPage.class.getName()).log(Level.SEVERE, null, ex);
            record.add("null");
            
        }
        
    }
    
    //stores the characteristics of the props which the user most recently hired
    public void accessProps (String email){
    
    try {
            sqlConnection sC = new sqlConnection();
            resSet  = sC.emailToID(email);        //stores the id of the user based on their email
            resSet.first();     //moves the current row of the result set to the first row

            ResultSet orderSet = sC.searchOrders(resSet.getString("userID")); //contains the orders from userid
            orderSet.first();       //moves the current row of the result set to the first row

            ResultSet rs  = sC.searchAllProps();   
            resultSetToArray  (rs); //converts the result set to a linked list using the over ride function
            allPropList.addAll(0, record);      //sets the allPropList to the value of record
            
            resultSetToArray  (sC.emailToOrders(email));    //converts the result set to a linked list using the over ride function
            userOrdersList2.addAll(0, record);     //sets the allPropList to the value of record

            if(userOrdersList2.get(0).equals("null")){
                
                JOptionPane.showMessageDialog(null, "This user does not have any prior hires");
            }
            
            propDetails1.clear();   //creates a list of characteristics by getting the value from the list of props
            propDetails1.add(userOrdersList2.get(4));
            propDetails1.add(userOrdersList2.get(5));
            propDetails1.add(userOrdersList2.get(6));
            propDetails1.add(userOrdersList2.get(7));
            propDetails1.add(userOrdersList2.get(8));
            
            propDetails2.clear();
            propDetails2.add(userOrdersList2.get(13));
            propDetails2.add(userOrdersList2.get(14));
            propDetails2.add(userOrdersList2.get(15));
            propDetails2.add(userOrdersList2.get(16));
            propDetails2.add(userOrdersList2.get(17));
            
            propDetails3.clear();
            propDetails3.add(userOrdersList2.get(22));
            propDetails3.add(userOrdersList2.get(23));
            propDetails3.add(userOrdersList2.get(24));
            propDetails3.add(userOrdersList2.get(25));
            propDetails3.add(userOrdersList2.get(26));
            
            
        } catch (SQLException ex) {
            resultsFound =false;
                    
            Logger.getLogger(recommendationPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    //used to compare the similarities of the users hires compared to other props
    public  LinkedList<Integer> compareValues (LinkedList<String> propDetails , LinkedList<Integer> similarScores) { for (int i = 0; i < propDetails.size(); i++) {
                
                for (int j = 0; j < allPropList.size(); j++) {  //loops based on the number of props in the database
                    
                    if(allPropList.get(j).equals(propDetails.get(0)) ){
                        similarScores.set(Math.floorDiv(j,5)+1 , -100);   //makes similarity negative if comparing the same prop
                    }
                    
                    if(allPropList.get(j).equals(propDetails.get(i)) ){ //if the prop has the same characteristic it gains a point
                        temporary++;
                        similarScores.set(Math.floorDiv(j,5)+1 , similarScores.get(Math.floorDiv(j,5)+1)+1);
                    }
                } 
            }
            
            if(temporary <1){resultsFound = false;}
            return similarScores;
      
    }
    
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
