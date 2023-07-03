
package netflixpropstorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class user {

    public static void loginCheck(String firstName , String password) {
    
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/propdb","root","rocket08");
        Statement statement = connection.createStatement();
        String customQuery = "select * from employees where firstName = '"+firstName+"'";
        ResultSet resultSet = statement.executeQuery(customQuery);
        
        while(resultSet.next()){
            if(password.equals(resultSet.getString("password"))){
                UImanager uiMan = new UImanager();
                JOptionPane.showMessageDialog(null, "The login details were correct");
                uiMan.loginToSearch();
                loginPage lP = new loginPage();
                lP.setVisible(false);
            }
            else{
                
                JOptionPane.showMessageDialog(null, "The login details were incorrect");
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

}

}
    

        