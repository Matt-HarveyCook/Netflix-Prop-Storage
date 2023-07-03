package netflixpropstorage;
import java.util.LinkedList;

public class recommendationPage extends javax.swing.JFrame{

    public recommendationPage() {
        initComponents();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("Recommendation Page:");

        searchButton.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(308, 308, 308))
            .addGroup(layout.createSequentialGroup()
                .addGap(406, 406, 406)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(448, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addContainerGap(442, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //stores the results of the function in a linked list 
    LinkedList<String> publicRecommendationList = new LinkedList<>();
    LinkedList<String> finalList = new LinkedList<>();      //stores the final set of values 
    
    //used to create a linked list which stores the ID of props which are most similar
    public LinkedList<String> generateRecc( String emailField){
        
        sqlConnection sC = new sqlConnection();     //allows access to the functions found in sql connection
        recommendationSystem recSys = new recommendationSystem();   //access to the functions in recommendation system
        
        recSys.accessProps(emailField);     //calls the access props function using the email found in parameter
        LinkedList<Integer> similarScores = new LinkedList<>();     //stores the similarity score of each prop
        

        
        for (int i = 0; i < sC.numberOfProps()+1; i++) {        //this creates a linked list with the size equal to the number of total props
            similarScores.add(0);       //fills the list with blank values which can be replaced
        }
        
        
        
        recSys.compareValues(recSys.propDetails1 , similarScores );     //runs the programme for prop1
        recSys.compareValues(recSys.propDetails2 , similarScores);      //same but for prop 2
        recSys.compareValues(recSys.propDetails3 , similarScores);      //same but for prop 3
        
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
            java.util.logging.Logger.getLogger(recommendationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(recommendationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(recommendationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(recommendationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new recommendationPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
