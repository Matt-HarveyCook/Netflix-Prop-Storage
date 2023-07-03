package netflixpropstorage;
import java.awt.Color;
import java.util.ArrayList;

public class loginPage extends javax.swing.JFrame  {
    
    //used to temporarily hold the prop ID when applying the tree sort in basket manager
    public static ArrayList<Integer> tempBasketArray = new ArrayList<Integer>();
    
    //the array which stores the ID of all props added to basket during the login session
    public static ArrayList<Integer> basketArray = new ArrayList<Integer>();
    
    //identifies which user is currently logged in
    public static String emailGlobal;
    
    public loginPage() {
        
        getContentPane().setBackground(Color.WHITE);    //sets the frame background to white
        initComponents();   //adds components
        this.setExtendedState(this.MAXIMIZED_BOTH);     //sets the frame to the size of the window
         
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pageTitle = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        createAccount = new javax.swing.JButton();
        password = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pageTitle.setFont(new java.awt.Font("Bebas Neue", 0, 72)); // NOI18N
        pageTitle.setForeground(new java.awt.Color(229, 9, 20));
        pageTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pageTitle.setText("Netflix");
        getContentPane().add(pageTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 1383, 68));

        username.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        username.setForeground(new java.awt.Color(229, 9, 20));
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 330, 223, -1));

        passwordLabel.setFont(new java.awt.Font("Bebas Neue", 0, 36)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(229, 9, 20));
        passwordLabel.setText("Password:");
        getContentPane().add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 400, -1, 34));

        usernameLabel.setFont(new java.awt.Font("Bebas Neue", 0, 36)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(229, 9, 20));
        usernameLabel.setText("Username / Email:");
        getContentPane().add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, 218, 32));

        login.setBackground(new java.awt.Color(229, 9, 20));
        login.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 470, 170, -1));

        createAccount.setBackground(new java.awt.Color(255, 255, 255));
        createAccount.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        createAccount.setForeground(new java.awt.Color(229, 9, 20));
        createAccount.setText("Create Account");
        createAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountActionPerformed(evt);
            }
        });
        getContentPane().add(createAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 530, 170, -1));

        password.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        password.setForeground(new java.awt.Color(229, 9, 20));
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 394, 223, 40));

        jLabel1.setFont(new java.awt.Font("Bebas Neue", 0, 72)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 9, 20));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login Page");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 1363, 67));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //function applied when the login button is pressed by the user
    //used to determine if the login was successful 
    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        
        emailGlobal = username.getText();   //stores the email of the user currently logged in
        sqlConnection sC = new sqlConnection();
        
        //compares the values entered to those found in the database
        if(sC.sqlLoginCheck(username.getText(), password.getText())==true){
                UImanager uiMan = new UImanager();
                uiMan.loginToSearch();  //shows the search page when login successful 
                this.setVisible(false);     //hides this window and shows the search when logged in
        }
    }//GEN-LAST:event_loginActionPerformed

    //shows the user the account creation page when the button is pressed
    private void createAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountActionPerformed
        UImanager UIman = new UImanager();
        UIman.loginToCreateAccount();
    }//GEN-LAST:event_createAccountActionPerformed

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
            java.util.logging.Logger.getLogger(loginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createAccount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton login;
    private javax.swing.JLabel pageTitle;
    private javax.swing.JTextField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
