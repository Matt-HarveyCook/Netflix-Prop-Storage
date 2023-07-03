package netflixpropstorage;

import java.awt.Color;
import javax.swing.JOptionPane;

public class addPropExisting extends javax.swing.JFrame {

    public addPropExisting() {
        getContentPane().setBackground(Color.WHITE);        //set the background colour
        getContentPane().setSize(714, 361); //set the prefered size 
        initComponents();
        setLocationRelativeTo(null);    //centre the window when shown
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(714, 361));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bebas Neue", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 9, 20));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Return Existing Prop");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 710, 74));

        jLabel2.setFont(new java.awt.Font("Bebas Neue", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(229, 9, 20));
        jLabel2.setText("Enter the prop id:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 120, -1));

        idField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        idField.setForeground(new java.awt.Color(229, 9, 20));
        idField.setMinimumSize(new java.awt.Dimension(714, 361));
        getContentPane().add(idField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 123, -1));

        submitButton.setBackground(new java.awt.Color(255, 255, 255));
        submitButton.setFont(new java.awt.Font("Bebas Neue", 0, 14)); // NOI18N
        submitButton.setForeground(new java.awt.Color(229, 9, 20));
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 237, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //run when the submit button is pressed
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        sqlConnection sC = new sqlConnection();
        sC.returnProp(idField.getText());   //changes the availability value of the corresponding prop
        JOptionPane.showMessageDialog(null, "This prop has been returned");
    }//GEN-LAST:event_submitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(addPropExisting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addPropExisting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addPropExisting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addPropExisting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addPropExisting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
