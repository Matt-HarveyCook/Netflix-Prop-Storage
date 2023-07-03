package netflixpropstorage;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class createAccount extends javax.swing.JFrame {

    public createAccount() {
        getContentPane().setBackground(Color.WHITE);
        initComponents();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        surnameLabel = new javax.swing.JLabel();
        surnameField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        phoneNumberLabel = new javax.swing.JLabel();
        phoneNumberField = new javax.swing.JTextField();
        jobRoleLabel = new javax.swing.JLabel();
        jobRoleCombo = new javax.swing.JComboBox<>();
        phoneNumberLabel1 = new javax.swing.JLabel();
        currentProductionField = new javax.swing.JTextField();
        phoneNumberLabel2 = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        createAccountButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Bebas Neue", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 9, 20));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Account Creation:");

        firstNameLabel.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        firstNameLabel.setForeground(new java.awt.Color(229, 9, 20));
        firstNameLabel.setText("First Name");

        surnameLabel.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        surnameLabel.setForeground(new java.awt.Color(229, 9, 20));
        surnameLabel.setText("Surname");

        emailLabel.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(229, 9, 20));
        emailLabel.setText("Email");

        phoneNumberLabel.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        phoneNumberLabel.setForeground(new java.awt.Color(229, 9, 20));
        phoneNumberLabel.setText("Phone Number");

        jobRoleLabel.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        jobRoleLabel.setForeground(new java.awt.Color(229, 9, 20));
        jobRoleLabel.setText("Job Role Label");

        jobRoleCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SetDec", "PropMan", "Runner", "Apprentice", " " }));

        phoneNumberLabel1.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        phoneNumberLabel1.setForeground(new java.awt.Color(229, 9, 20));
        phoneNumberLabel1.setText("Current Production");

        phoneNumberLabel2.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        phoneNumberLabel2.setForeground(new java.awt.Color(229, 9, 20));
        phoneNumberLabel2.setText("Account Password");

        createAccountButton.setBackground(new java.awt.Color(255, 255, 255));
        createAccountButton.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        createAccountButton.setForeground(new java.awt.Color(229, 9, 20));
        createAccountButton.setText("Create Account");
        createAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(578, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(surnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(65, 65, 65))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jobRoleLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(phoneNumberLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(36, 36, 36)))
                            .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneNumberLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneNumberLabel1))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(currentProductionField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jobRoleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(574, 574, 574))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(createAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(617, 617, 617))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(surnameLabel)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLabel)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phoneNumberLabel)
                    .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jobRoleLabel)
                    .addComponent(jobRoleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(phoneNumberLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneNumberLabel2)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(currentProductionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(createAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //used to determine the presence of a lower case, capital and number
    private static boolean capitalCheck(String password) {
    char ch;    //variable which temporarily stores the current character
    boolean capitalFlag = false;    //flag to check for presence of capital
    boolean lowerCaseFlag = false;  //flag for lower case
    boolean numberFlag = false;     //flag for numbers
    
    //loops based on the length of the password
    for(int i=0;i < password.length();i++) {
        ch = password.charAt(i);    
        if( Character.isDigit(ch)) {    //if the character is a number then set number flag
            numberFlag = true;
        }
        else if (Character.isUpperCase(ch)) {   //if character is a capital then set flag
            capitalFlag = true;
        } else if (Character.isLowerCase(ch)) { //if the character is lower case then set flag
            lowerCaseFlag = true;
        }
        if(numberFlag && capitalFlag && lowerCaseFlag)  //check if all flags are true
            return true;
    }
    return false;
}
    
    private void createAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountButtonActionPerformed
        hashFunction hF = new hashFunction();
       sqlConnection sC = new sqlConnection();
       UImanager UIman = new UImanager();
       
       //regex pattern which checks for the presence of @ in the string
       Pattern pattern = Pattern.compile(".*@.*", Pattern.CASE_INSENSITIVE);
       
       //applies regex library using previous regex and the email field string
       Matcher matcher = pattern.matcher(emailField.getText());
       boolean emailCheck = matcher.find();     //true if @ is found
        
       //hash the password for database storage
       String passwordHashed = hF.hashFunction(passwordField.getText());
       
       //checks all fields contain the correct characteristics and only runs if all are true
       if(emailCheck == true && phoneNumberField.getText().length() == 11 && passwordField.getText().matches(".*\\d.*")==true && capitalCheck(passwordField.getText())){
            //generates a new user profile using the characteristics entered as parameters
            sC.accountCreation(firstNameField.getText(), surnameField.getText(), emailField.getText(), phoneNumberField.getText(), (String)jobRoleCombo.getSelectedItem(), currentProductionField.getText(), passwordHashed);
            JOptionPane.showMessageDialog(null, "Account Created Successfully");    //output to user
            UIman.createAccountToLogin();   //switch window
       }
       
       //excecuted if the previous if check fails
       else{
           JOptionPane.showMessageDialog(null, "1. Email must contain @ \n 2. Phone number of 11 characters \n 3. Number and capital in password");
       }
       
        
        
    }//GEN-LAST:event_createAccountButtonActionPerformed

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
            java.util.logging.Logger.getLogger(createAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createAccountButton;
    private javax.swing.JTextField currentProductionField;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> jobRoleCombo;
    private javax.swing.JLabel jobRoleLabel;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JLabel phoneNumberLabel1;
    private javax.swing.JLabel phoneNumberLabel2;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel surnameLabel;
    // End of variables declaration//GEN-END:variables
}
