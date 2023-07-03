package netflixpropstorage;

import java.awt.Color;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class addProp extends javax.swing.JFrame {

    public addProp() {
        getContentPane().setBackground(Color.WHITE);
        this.setExtendedState(this.MAXIMIZED_BOTH); 
        initComponents();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        getPhotoButton = new javax.swing.JButton();
        filePathLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        typeCombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        colourCombo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        periodCombo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        eraCombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        descriptionField = new javax.swing.JTextField();
        submitPropButton = new javax.swing.JButton();
        returnHired = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bebas Neue", 0, 72)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 9, 20));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Prop Page:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, 40, 1920, 58));

        getPhotoButton.setBackground(new java.awt.Color(255, 255, 255));
        getPhotoButton.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        getPhotoButton.setForeground(new java.awt.Color(229, 9, 20));
        getPhotoButton.setText("Get Photo File Path");
        getPhotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getPhotoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(getPhotoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, -1, -1));

        filePathLabel.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        filePathLabel.setForeground(new java.awt.Color(229, 9, 20));
        filePathLabel.setText("This is the file path: none");
        getContentPane().add(filePathLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 690, -1));

        jLabel3.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(229, 9, 20));
        jLabel3.setText("Prop Type:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, 142, -1));

        typeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Other", "Chair", "Light", "Sofa", "Table Big", "Table Small", " " }));
        getContentPane().add(typeCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 300, 109, -1));

        jLabel4.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(229, 9, 20));
        jLabel4.setText("Prop Colour:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, 142, -1));

        colourCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Other", "Red", "Green", "Yellow", "Blue", "Orange", "Pink/Purple", " " }));
        getContentPane().add(colourCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 350, 109, -1));

        jLabel5.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(229, 9, 20));
        jLabel5.setText("Prop Period:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 142, -1));

        periodCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Other", "Georgian", "Victorian", "Retro", "Modern" }));
        getContentPane().add(periodCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 400, 109, -1));

        jLabel6.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(229, 9, 20));
        jLabel6.setText("Prop Era:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, 142, -1));

        eraCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Other", "1900", "1910", "1920", "1930", "1940", "1950", "1960", "1970", "1980" }));
        getContentPane().add(eraCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 450, 109, -1));

        jLabel7.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(229, 9, 20));
        jLabel7.setText("Prop Description:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 490, 142, -1));

        descriptionField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        getContentPane().add(descriptionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 490, 210, 27));

        submitPropButton.setBackground(new java.awt.Color(255, 255, 255));
        submitPropButton.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        submitPropButton.setForeground(new java.awt.Color(229, 9, 20));
        submitPropButton.setText("Submit Prop");
        submitPropButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitPropButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitPropButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 560, 134, 54));

        returnHired.setBackground(new java.awt.Color(255, 255, 255));
        returnHired.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        returnHired.setForeground(new java.awt.Color(229, 9, 20));
        returnHired.setText("Return a hired prop");
        returnHired.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnHiredActionPerformed(evt);
            }
        });
        getContentPane().add(returnHired, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 160, 232, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //run when the get photo button is pressed
    private void getPhotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getPhotoButtonActionPerformed
        JFileChooser file = new JFileChooser("D:\\Homework A Levels\\Computing\\NEA\\projectImages");     //creates a file chooser button
        file.setMultiSelectionEnabled(false);    //allows the user to only select one file
        file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);  //allows both files and directories to be displayed
        file.setFileHidingEnabled(false);   //shows file
        if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
           java.io.File f = file.getSelectedFile();     //gets the file path of the selected file from the file chooser
           filePathLabel.setText(f.getPath());      //sets the label to the path
      }
        
    }//GEN-LAST:event_getPhotoButtonActionPerformed

    //run when the submit prop button is pressed
    private void submitPropButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitPropButtonActionPerformed
        String imagePath = filePathLabel.getText();     //gets the file path from the value which is found in the label
        if (imagePath.equals("This is the file path: none")) {      //determines whether a file has been selected
            JOptionPane.showMessageDialog(null, "There is no prop image selected");
        }
        else{
            JOptionPane.showMessageDialog(null, "The prop has been submitted");
            imagePath = imagePath.replace("\\", "\\\\"); //adds the escape characters to allow the file path to function when stored
            sqlConnection sC = new sqlConnection ();
            sC.addProp((String)typeCombo.getSelectedItem(), (String)colourCombo.getSelectedItem(), (String)periodCombo.getSelectedItem(), (String)eraCombo.getSelectedItem(), descriptionField.getText(), imagePath);
            //creates a new prop using the characteristics entered
    }//GEN-LAST:event_submitPropButtonActionPerformed
    }
    
    //transitions to the return a hired prop page when button pressed
    private void returnHiredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnHiredActionPerformed
        UImanager uiMan = new UImanager();
        uiMan.addPropToExisting();
    }//GEN-LAST:event_returnHiredActionPerformed


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
            java.util.logging.Logger.getLogger(addProp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addProp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addProp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addProp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addProp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> colourCombo;
    private javax.swing.JTextField descriptionField;
    private javax.swing.JComboBox<String> eraCombo;
    private javax.swing.JLabel filePathLabel;
    private javax.swing.JButton getPhotoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox<String> periodCombo;
    private javax.swing.JButton returnHired;
    private javax.swing.JButton submitPropButton;
    private javax.swing.JComboBox<String> typeCombo;
    // End of variables declaration//GEN-END:variables
}
