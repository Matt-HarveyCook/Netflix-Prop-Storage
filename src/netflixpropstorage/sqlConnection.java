/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflixpropstorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class sqlConnection {
    ResultSet rs;
    ImageIcon icon;
    
       
    
       public ResultSet getRs (){
       return rs;
   }
       
       public ImageIcon getIcon (){
           return icon;
       }

//used to check the validity of login credentials      
public boolean sqlLoginCheck(String email , String password) {
    boolean login = false;
    hashFunction hF = new hashFunction();
    password = hF.hashFunction(password);
            
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/propdb","root","rocket08");
        //Statement statement = connection.createStatement();
        Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String customQuery = "select * from employees where email = '"+email+"'";
        ResultSet resultSet = statement.executeQuery(customQuery);
        
        while(resultSet.next()){
            if(password.equals(resultSet.getString("password"))){
                JOptionPane.showMessageDialog(null, "The login details were correct");
                login = true;
            }
            else{
                JOptionPane.showMessageDialog(null, "The login details were incorrect");
                login = false;
            }
            
        }
    }
    catch (SQLException e)
        {
        System.out.println("SQL Exception: "+ e.toString());
        }
    catch (ClassNotFoundException cE)
        {
            System.out.println("Class Not Found Exception: "+ cE.toString());
           }
    return login;
}

//returns all the characteristics of the selected props based on a characteristic 
public void sqlSearchProp(String prop) {
    
    //checks if multiple words have been entered
    if (prop.contains(" ")) {
        
                String[] words = prop.split(" ");   //creates a list of words from the search values

                try
                {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/propdb","root","rocket08");
                //Statement statement = connection.createStatement();
                Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                String customQuery = "SELECT * FROM props WHERE'"+ words[0]+ "'IN(propID, propType, colour, period, propDate, propDescription)";
                
                //runs a for loop based on the number of words entered which creates a statement with all the terms
                for (int i = 0; i < words.length; i++) {
                        customQuery = customQuery.concat("OR'"+ words[i]+ "'IN(propID, propType, colour, period, propDate, propDescription)");
                    }
                
                //the result set which stores the result from the search
                rs = statement.executeQuery(customQuery);


                }

            catch (SQLException e)
                {
                System.out.println("SQL Exception: "+ e.toString());
                }
            catch (ClassNotFoundException cE)
                {
                    System.out.println("Class Not Found Exception: "+ cE.toString());
                }
    }
    
    //else block runs when there is only one word entered
    else{
    try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/propdb","root","rocket08");
        //Statement statement = connection.createStatement();
        Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String customQuery = "SELECT * FROM props WHERE'"+ prop+ "'IN(propID, propType, colour, period, propDate, propDescription)" ;
        rs = statement.executeQuery(customQuery);
        

        }
        
    catch (SQLException e)
        {
        System.out.println("SQL Exception: "+ e.toString());
        }
    catch (ClassNotFoundException cE)
        {
            System.out.println("Class Not Found Exception: "+ cE.toString());
        }
    }
    
   }
    
//creates a new row in the account table using the characteristics entered as parameters
public static void accountCreation(String firstName , String surname, String email, String phone, String jobRole, String job, String password) {
    
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/propdb","root","rocket08");
        Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String customQuery = "INSERT INTO employees(firstName , surname, email, phone, jobRole, job, password) VALUES('" + firstName+ "' , '"  + surname+"','" + email+"','"+phone+"','"+jobRole+"','"+job+"','"+password+ "');";
        statement.executeUpdate(customQuery);
    }
    catch (SQLException e)
        {
        System.out.println("SQL Exception: "+ e.toString());
        }
    catch (ClassNotFoundException cE)
        {
            System.out.println("Class Not Found Exception: "+ cE.toString());
           }

}

//creates a new row in the prop table using the characteristics entered as parameters
public static void addProp(String propType , String colour, String period, String propDate, String propDescription, String images) {
    
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/propdb","root","rocket08");
        //Statement statement = connection.createStatement();
        Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String customQuery = "INSERT INTO props(propType , colour, period, propDate, propDescription, images) VALUES('" + propType+ "' , '"  + colour+"','" + period+"','"+propDate+"','"+propDescription+"','"+images+ "');";
        System.out.println("this the queuery: "+customQuery);
        statement.executeUpdate(customQuery);
        
    }
    catch (SQLException e)
        {
        System.out.println("SQL Exception: "+ e.toString());
        }
    catch (ClassNotFoundException cE)
        {
            System.out.println("Class Not Found Exception: "+ cE.toString());
           }

}

//returns all the characteristics of the selected props based on an characteristic but returns it as a result set
public ResultSet detailSearch (String prop){
    try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/propdb","root","rocket08");
        //Statement statement = connection.createStatement();
        Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String customQuery = "SELECT * FROM props WHERE'"+ prop+ "'IN(propID, propType, colour, period, propDate, propDescription)" ;
        rs = statement.executeQuery(customQuery);
        

        }
        
    catch (SQLException e)
        {
        System.out.println("SQL Exception: "+ e.toString());
        }
    catch (ClassNotFoundException cE)
        {
            System.out.println("Class Not Found Exception: "+ cE.toString());
        }
    
    return rs;
             
}

//returns the userID based on the email entered
public ResultSet emailToID(String email){
    
    try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/propdb","root","rocket08");
        //Statement statement = connection.createStatement();
        Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String customQuery = "SELECT userID, job FROM propdb.employees where email = '" + email + "'" ;
        rs = statement.executeQuery(customQuery);
        

        }
        
    catch (SQLException e)
        {
        System.out.println("SQL Exception: "+ e.toString());
        }
    catch (ClassNotFoundException cE)
        {
            System.out.println("Class Not Found Exception: "+ cE.toString());
        }
    return rs;
}

//adds a new row to the order table 
public static void addOrder(String propID, String userID, String shootID) throws ParseException {
    
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/propdb","root","rocket08");
        Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        //used to add a new row to the orders table using the appropriate values
        String customQuery = "INSERT INTO orders(propID, userID, shootID) VALUES('" + propID+ "' , '"  + userID+"','" + shootID+ "');";
        statement.executeUpdate(customQuery);
        
        //changes the availability of the prop so that it cannot be hired again until it is returned
        String customQuery2 = "UPDATE props SET availableToHire = FALSE WHERE propID = '"+propID+"';";
        statement.executeUpdate(customQuery2);
        
        //stores the maximum orderID and stores it in an sql variable
        String customQuery3 = "set @orderId =(SELECT orderID FROM propdb.orders WHERE orderID=(SELECT max(orderID) FROM propdb.orders)); ";
        statement.executeUpdate(customQuery3);
        
        //stores the current job of the user hiring the props
        String customQuery5 = "set @job =(SELECT job FROM propdb.employees WHERE employees.userID ='" + userID+"');";
        statement.executeUpdate(customQuery5);
        
        //retrieves and stores the shoot id from the shoot location based on the users current job
        String customQuery6 = "set @shootId =(SELECT shootID FROM propdb.shootlocation WHERE shootlocation.production = @job);";
        statement.executeUpdate(customQuery6);
        
        //gets the number of days based on the shoot id
        String customQuery7 = "select durationDays from shootlocation where shootId = @shootId";
        
        //stores the duration of the shoot for the current user
        ResultSet durationDays;
        durationDays = statement.executeQuery(customQuery7);
        durationDays.first();
                
        //sets the format of the dates and creates a new date object
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        
        //gets the local date
        LocalDateTime now = LocalDateTime.now();  
        
        //stores the current date as a string based on the previously set format
        String hireDate = dtf.format(now);
        
        String returnDate= hireDate;    //stores the date which the prop will be returned on
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(returnDate));   //formats and sets the return date
        
        //adds to the return date based on the duration of days for the shoot
        c.add(Calendar.DATE, Integer.parseInt( durationDays.getString("durationDays"))); 
        returnDate = sdf.format(c.getTime());  // dt is now the new date

        //stores the information about this prop hire in the order detail table
        String customQuery4 =  "INSERT INTO orderDetail(hireDate, returnDate, quantity, orderID, shootID) VALUES('" + hireDate+ "','"+returnDate+ "','1'," + " @orderId , @shootId);";
        statement.executeUpdate(customQuery4);
 
    }
    catch (SQLException e)
        {
        System.out.println("SQL Exception: "+ e.toString());
        }
    catch (ClassNotFoundException cE)
        {
            System.out.println("Class Not Found Exception: "+ cE.toString());
           }

}

//changes the availability of a prop from false to true
public static void returnProp(String propID) {
    
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/propdb","root","rocket08");
        //Statement statement = connection.createStatement();
        Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
        String customQuery2 = "UPDATE props SET availableToHire = TRUE WHERE propID = '"+propID+"';";
        statement.executeUpdate(customQuery2);

      // execute the java preparedstatement
        
        
    }
    catch (SQLException e)
        {
        System.out.println("SQL Exception: "+ e.toString());
        }
    catch (ClassNotFoundException cE)
        {
            System.out.println("Class Not Found Exception: "+ cE.toString());
           }

}

//selects all the orders from a specific user
public ResultSet searchOrders (String userID){
     
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/propdb","root","rocket08");
        //Statement statement = connection.createStatement();
        Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
        String customQuery = "SELECT * FROM orders WHERE userID = '" + userID + "'";
        statement.executeQuery(customQuery);
        rs = statement.executeQuery(customQuery);
        
    }
    catch (SQLException e)
        {
        System.out.println("SQL Exception: "+ e.toString());
        }
    catch (ClassNotFoundException cE)
        {
            System.out.println("Class Not Found Exception: "+ cE.toString());
           }
    return rs;
}   

//determines the number of props currently available in the database
int numberOfResults;
public int numberOfProps (){
     
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/propdb","root","rocket08");
        Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
        //returns the single value of how many props there are currently
        String customQuery = "SELECT COUNT(*) FROM props";
        statement.executeQuery(customQuery);
        rs = statement.executeQuery(customQuery);
        
        rs.first();
        numberOfResults = rs.getInt(1); //sets the number of results to the value calculated
 }
    catch (SQLException e)
        {
        System.out.println("SQL Exception: "+ e.toString());
        }
    catch (ClassNotFoundException cE)
        {
            System.out.println("Class Not Found Exception: "+ cE.toString());
           }
    return numberOfResults;
}   

public ResultSet searchAllProps(){
     
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/propdb","root","rocket08");
        //Statement statement = connection.createStatement();
        Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
        String customQuery = "SELECT propID, propType, colour, period, propDate FROM props;";
        statement.executeQuery(customQuery);
        rs = statement.executeQuery(customQuery);
        
      // execute the java preparedstatement
        
        
    }
    catch (SQLException e)
        {
        System.out.println("SQL Exception: "+ e.toString());
        }
    catch (ClassNotFoundException cE)
        {
            System.out.println("Class Not Found Exception: "+ cE.toString());
           }
    return rs;
}

//takes the user email as a parameter and returns their orders
public ResultSet emailToOrders(String email){
     
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/propdb","root","rocket08");
        Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
        //stores the employee id by converting from the email to the id
        String customUpdate = "set @EmpId = (select userID from propdb.employees where employees.email = '"+email +"' );";
        statement.executeUpdate(customUpdate);

        //selects all the orders based on the previously stored employee id
        String customQuery = "SELECT Orders.*, props.propID, props.propType, props.colour, props.period, props.propDate FROM Orders INNER JOIN props ON orders.propID=props.propID where orders.userID = @EmpID order by orderID DESC;";
        statement.executeQuery(customQuery);
        rs = statement.executeQuery(customQuery);
        
    }
    catch (SQLException e)
        {
        System.out.println("SQL Exception: "+ e.toString());
        }
    catch (ClassNotFoundException cE)
        {
            System.out.println("Class Not Found Exception: "+ cE.toString());
           }
    return rs;
}

public ResultSet getOrderDetails(){
     
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/propdb","root","rocket08");
        //Statement statement = connection.createStatement();
        Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
        String customQuery = "SELECT *\n" +
                                            "FROM orderdetail\n" +
                                            "INNER JOIN shootlocation ON orderdetail.shootID= shootlocation.shootID;";
        statement.executeQuery(customQuery);
        rs = statement.executeQuery(customQuery);
        
      // execute the java preparedstatement
        
        
    }
    catch (SQLException e)
        {
        System.out.println("SQL Exception: "+ e.toString());
        }
    catch (ClassNotFoundException cE)
        {
            System.out.println("Class Not Found Exception: "+ cE.toString());
           }
    return rs;
}

}






    

        