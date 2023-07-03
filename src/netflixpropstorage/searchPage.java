/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflixpropstorage;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.List;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import net.proteanit.sql.DbUtils;


public class searchPage extends javax.swing.JFrame {
    
    int selectedRow; 
    public String searchBoxValue="null";

    //set of public variables which store the characteristics of prop. used for generating the detail page
    String col1,col2,col3,col4,col5,col6,col7,col8;

    
    public searchPage() {
        getContentPane().setBackground(Color.WHITE);
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH); 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        searchBox = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        detailButton = new javax.swing.JButton();
        detailEra2 = new javax.swing.JLabel();
        detailType2 = new javax.swing.JLabel();
        addPropButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultsTable = new javax.swing.JTable();
        hireBasketButton = new javax.swing.JButton();
        recommendationButton = new javax.swing.JButton();
        ordersButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        viewBasketButton = new javax.swing.JButton();
        removeFromBasketButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bebas Neue", 0, 72)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 9, 20));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Netflix");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1542, -1));

        logoutButton.setBackground(new java.awt.Color(255, 255, 255));
        logoutButton.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        logoutButton.setText("Log Out");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 170, 40));

        searchBox.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        searchBox.setForeground(new java.awt.Color(229, 9, 20));
        searchBox.setToolTipText("");
        searchBox.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(searchBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 410, 30));

        searchButton.setBackground(new java.awt.Color(229, 9, 20));
        searchButton.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 390, 170, 30));

        detailButton.setBackground(new java.awt.Color(229, 9, 20));
        detailButton.setFont(new java.awt.Font("Bebas Neue", 0, 22)); // NOI18N
        detailButton.setForeground(new java.awt.Color(255, 255, 255));
        detailButton.setText("Prop Details Page");
        detailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailButtonActionPerformed(evt);
            }
        });
        getContentPane().add(detailButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 390, 170, 30));
        getContentPane().add(detailEra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 619, 67, -1));
        getContentPane().add(detailType2, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 270, 67, -1));

        addPropButton.setBackground(new java.awt.Color(255, 255, 255));
        addPropButton.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        addPropButton.setForeground(new java.awt.Color(229, 9, 20));
        addPropButton.setText("Add Prop Page");
        addPropButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPropButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addPropButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 250, 170, -1));

        resultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(resultsTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, 870, 256));

        hireBasketButton.setBackground(new java.awt.Color(255, 255, 255));
        hireBasketButton.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        hireBasketButton.setForeground(new java.awt.Color(229, 9, 20));
        hireBasketButton.setText("Hire Basket");
        hireBasketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hireBasketButtonActionPerformed(evt);
            }
        });
        getContentPane().add(hireBasketButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 171, -1));

        recommendationButton.setBackground(new java.awt.Color(255, 255, 255));
        recommendationButton.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        recommendationButton.setForeground(new java.awt.Color(229, 9, 20));
        recommendationButton.setText("Recommendations");
        recommendationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recommendationButtonActionPerformed(evt);
            }
        });
        getContentPane().add(recommendationButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, -1, -1));

        ordersButton.setBackground(new java.awt.Color(255, 255, 255));
        ordersButton.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        ordersButton.setForeground(new java.awt.Color(229, 9, 20));
        ordersButton.setText("Orders");
        ordersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ordersButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 250, 171, -1));

        jLabel2.setFont(new java.awt.Font("Bebas Neue", 0, 72)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(229, 9, 20));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Search Page");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1542, -1));

        viewBasketButton.setBackground(new java.awt.Color(255, 255, 255));
        viewBasketButton.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        viewBasketButton.setForeground(new java.awt.Color(229, 9, 20));
        viewBasketButton.setText("View basket");
        viewBasketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBasketButtonActionPerformed(evt);
            }
        });
        getContentPane().add(viewBasketButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 170, 40));

        removeFromBasketButton.setBackground(new java.awt.Color(255, 255, 255));
        removeFromBasketButton.setFont(new java.awt.Font("Bebas Neue", 0, 20)); // NOI18N
        removeFromBasketButton.setForeground(new java.awt.Color(229, 9, 20));
        removeFromBasketButton.setText("Remove from basket");
        removeFromBasketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFromBasketButtonActionPerformed(evt);
            }
        });
        getContentPane().add(removeFromBasketButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, 170, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    ArrayList<String> record = new ArrayList<String>(); //the arraylist which will store the results from the rs
    
    //this func converts a result set into an array and then returns the arraylist
    public void resultSetToArray  (ResultSet resSet){
        record.clear(); //empties the arraylist
        try {
            ResultSetMetaData metaData = (ResultSetMetaData) resSet.getMetaData(); 
            int columns = metaData.getColumnCount(); //get meta data and store the number of columns
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
    
    //used to log the user out by returning to the login page
    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        UImanager uiMan = new UImanager();
        uiMan.searchToLogin();
        this.setVisible(false);
    }//GEN-LAST:event_logoutButtonActionPerformed

    public void searchFunction( String searchText){
         sqlConnection sC = new sqlConnection();
        sC.sqlSearchProp(searchText); //applies prop search when button is pressed using the textbox value
        searchBoxValue= searchText;

        ArrayList<String> result1 = new ArrayList<String>(); //used to store the values from search 
        resultSetToArray(sC.getRs());     //populates result1 with the results
        result1 = record;   //record is an array list which is declared at the start it stores the results
        
        //this block overides the getColumnClass so that the 3rd column is read as an image rather than file path
        DefaultTableModel tM = new DefaultTableModel()
        {
            @Override
            public Class getColumnClass(int column)
            {
                if (column == 3) return ImageIcon.class; 
                else return Object.class;
            }
        };
           
            //generates the columns for the table
            tM.addColumn("Prop ID");
            tM.addColumn("Prop Type");
            tM.addColumn("Prop Colour");
            tM.addColumn("Prop Image");
            
            //checks if there were no results to return error message
            if(result1.isEmpty()){
                JOptionPane.showMessageDialog(null, "this search returned no results");
            }
            
            //block used to generate the table model which fill the results table
            for (int i = 0; i <= result1.size()/8-1; i++) {  //loops based on the number of results
                ImageIcon img = new ImageIcon(result1.get(i*8 +6)); // load the image to a imageIcon
                Image image = img.getImage(); // transform it 
                Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                tM.addRow(new Object[]{result1.get(i*8) , result1.get(i*8 + 1), result1.get(i*8 + 2) , new ImageIcon(newimg) });
                // ^^ creates a new row by drawing values from the result1 array which contains results
        }
            resultsTable.setModel(tM); //set the model to the results table
            
            
            //iterates through the rows and sets the row height so that the images are not cropped when rendered
            for (int row = 0; row < resultsTable.getRowCount(); row++)
            {
                int rowHeight = resultsTable.getRowHeight();

                for (int column = 0; column < resultsTable.getColumnCount(); column++)
                {
                    Component comp = resultsTable.prepareRenderer(resultsTable.getCellRenderer(row, column), row, column);
                    rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
                }
                resultsTable.setRowHeight(row, rowHeight);
            
            }
    }
    
   //used to search for props and create the results table     
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        searchFunction(searchBox.getText());

    }//GEN-LAST:event_searchButtonActionPerformed

    //used to create a page which shows the details of the selected prop
    private void detailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailButtonActionPerformed

        if(resultsTable.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "There is no prop selected");
        }   
        
        else{
        
        sqlConnection sC = new sqlConnection();
        detailManager dM = new  detailManager();

        try {
            
            String search = (String)resultsTable.getValueAt(resultsTable.getSelectedRow(), 0);
            //^^ gets the prop id from the generated table
            
            ResultSet resSet = sC.detailSearch(search); // uses the prop id from above to sql search
            resSet.first(); //moves the result set current row to the first line
            
            //sets the values of each characteristic which can then be passed into the detail page generator
            col1= resSet.getString("propID");
            col2= resSet.getString("propType");
            col3= resSet.getString("colour");
            col4= resSet.getString("period");
            col5= resSet.getString("propDate");
            col6= resSet.getString("propDescription");
            col7= resSet.getString("images");
            col8 = resSet.getString("availableToHire");
                    
            dM.generateDetailPage(col1,col2,col3,col4, col5, col6, col7, col8); //creates new page with details
            
        } catch (SQLException ex) {
            Logger.getLogger(searchPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_detailButtonActionPerformed

    //displays the add prop page when pressed
    private void addPropButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPropButtonActionPerformed
        UImanager UIman = new UImanager();
        UIman.searchToAddProp();
        
    }//GEN-LAST:event_addPropButtonActionPerformed


    //hires the props currently in the users basket
    private void hireBasketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hireBasketButtonActionPerformed
        
        sqlConnection sC = new sqlConnection();
        String currentJob;  //stores the users current production
        loginPage lP = new  loginPage();
        
            //prevents the user  from using the hire function if there are no items in the basket
            if(lP.basketArray.isEmpty()){   
                JOptionPane.showMessageDialog(null, "The basket is empty");
            }
            
            else{
                try {
                    ResultSet resSet = sC.emailToID(loginPage.emailGlobal);     //stores the ID based on user email
                    resSet.first();     //moves the result set to the first row
                    currentJob = resSet.getString("job");       //stores the current production of the user
                    String userID = resSet.getString("userID");     //stores their ID
                    
                    String propID = Integer. toString(lP.basketArray.get(0));  //retrieves the propID and stores as string
                     sC.addOrder(propID, userID, currentJob);   //generates a new order using the information retrieved

                     //if the basket has more than one item in it the generate order process is repeated
                     if(lP.basketArray.size() > 1){ 
                            for (int i = 1; i < lP.basketArray.size(); i++) {
                               propID = Integer. toString(lP.basketArray.get(i));
                               sC.addOrder(propID, userID, currentJob);
                       }
                     }
                    

                } catch (SQLException ex) {
                    Logger.getLogger(basketCheck.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                Logger.getLogger(basketCheck.class.getName()).log(Level.SEVERE, null, ex);
            }
                //informs the user once the hire process is complete
                JOptionPane.showMessageDialog(null, "The props in the basket have been hired");
            }
    }//GEN-LAST:event_hireBasketButtonActionPerformed

    //displays the automatic recommendations to the user
    private void recommendationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recommendationButtonActionPerformed

        recommendationPage rP = new recommendationPage();
        recommendationSystem rS = new recommendationSystem();
        loginPage lP = new loginPage();
        
        //generates a list of recommendations of prop IDs using the users email
        String listString = String.join(" ", rS.generateRecc(lP.emailGlobal));  
        
        searchBox.setText(listString);      //sets the value of the search box to the recommendations IDs
        
        //this checks if there are any recommendations and informs the user
        //if the generated list starts with a null value then no recommendations were found
        if(rS.finalList.get(0).charAt(0) == '0'){   
            searchBox.setText("");
            JOptionPane.showMessageDialog(null, "There were no recommendations found\nCheck your email and orders");
            
        }
        else{
        searchFunction(searchBox.getText());    //displays the recommended props with the search function
        JOptionPane.showMessageDialog(null, "The search results show the recommended items");
        }
        
    }//GEN-LAST:event_recommendationButtonActionPerformed

    //it shows the user all props currently hired and the details of when they will be returned
    private void ordersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersButtonActionPerformed
        sqlConnection sC = new sqlConnection();
        JOptionPane.showMessageDialog(null, "The results table shows your orders");
        sC.getOrderDetails();
        resultsTable.setModel(DbUtils.resultSetToTableModel(sC.rs));    //sets the result table to the orders
    }//GEN-LAST:event_ordersButtonActionPerformed

    private void viewBasketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBasketButtonActionPerformed
        loginPage lP = new loginPage();
        //checks the length of the basket array
        if(lP.basketArray.isEmpty()){JOptionPane.showMessageDialog(null, "There are currently no items in your basket");}
        else{
        //converts from arraylist to string so that the values can be used in the search box
        String listString = lP.basketArray.stream().map(Object::toString).collect(Collectors.joining(", "));
        searchBox.setText(listString);      //sets the value of the search box to the recommendations IDs
         searchFunction(searchBox.getText());    //displays the recommended props with the search function
        JOptionPane.showMessageDialog(null, "The results table shows your current basket");
        }
    }//GEN-LAST:event_viewBasketButtonActionPerformed

    private void removeFromBasketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFromBasketButtonActionPerformed
        loginPage lP = new loginPage();
        //checks if the user has selected a prop to remove from the basket
        if(resultsTable.getSelectionModel().isSelectionEmpty() == true){
            JOptionPane.showMessageDialog(null, "There is no prop selected");
        }   
     
        else{
            //stores the value which the user has selected in the results table
            String selection =(String) resultsTable.getValueAt(resultsTable.getSelectedRow(), 0);
            
            //checks if the item selected is in the basket
            if(lP.basketArray.indexOf(Integer.parseInt(selection)) == -1){
                JOptionPane.showMessageDialog(null, "This item cannot be found in your basket");
            }
            else{
             //if all inputs are correct the item is removed from the basket
             lP.basketArray.remove(lP.basketArray.indexOf(Integer.parseInt(selection)));
            JOptionPane.showMessageDialog(null, "This prop has been removed");
            }
        }
    }//GEN-LAST:event_removeFromBasketButtonActionPerformed

  
public String getSearchBoxValue (){
       return searchBoxValue;
        
    }   

public int getResultsTable(){
    return selectedRow;
}

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(searchPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(searchPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(searchPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(searchPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new searchPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPropButton;
    private javax.swing.JButton detailButton;
    private javax.swing.JLabel detailEra2;
    private javax.swing.JLabel detailType2;
    private javax.swing.JButton hireBasketButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton ordersButton;
    private javax.swing.JButton recommendationButton;
    private javax.swing.JButton removeFromBasketButton;
    private javax.swing.JTable resultsTable;
    public javax.swing.JTextField searchBox;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton viewBasketButton;
    // End of variables declaration//GEN-END:variables
}
