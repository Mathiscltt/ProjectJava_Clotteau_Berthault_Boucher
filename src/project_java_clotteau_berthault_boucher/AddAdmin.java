/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_java_clotteau_berthault_boucher;

/*private Object Bank;*/
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mclot
 */
public class AddAdmin extends javax.swing.JFrame {

    /**
     * Creates new form AddAdmin
     */
    public AddAdmin() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        AName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ALastname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        APassword = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        APasswordConfirmation = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ASSN = new javax.swing.JTextField();
        CreateAccountBtn = new javax.swing.JButton();
        BackMainMenuBtn = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Create Admin Account");

        jPanel3.setLayout(new java.awt.GridLayout(5, 2));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Name");
        jPanel3.add(jLabel2);

        AName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ANameActionPerformed(evt);
            }
        });
        jPanel3.add(AName);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Lastname");
        jPanel3.add(jLabel3);
        jPanel3.add(ALastname);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Password");
        jPanel3.add(jLabel4);
        jPanel3.add(APassword);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Confirm Password");
        jPanel3.add(jLabel5);
        jPanel3.add(APasswordConfirmation);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Social Security Number");
        jPanel3.add(jLabel7);
        jPanel3.add(ASSN);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(87, 87, 87))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CreateAccountBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        CreateAccountBtn.setText("Create Account");
        CreateAccountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateAccountBtnActionPerformed(evt);
            }
        });

        BackMainMenuBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BackMainMenuBtn.setText("Back Main Menu");
        BackMainMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackMainMenuBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(CreateAccountBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(BackMainMenuBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(CreateAccountBtn)
                .addGap(18, 18, 18)
                .addComponent(BackMainMenuBtn)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ANameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ANameActionPerformed

    private void CreateAccountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAccountBtnActionPerformed
        StringBuilder warning = new StringBuilder();
        String name = "", lastname = "", ssn = "", password = "";
        if (AName.getText().isEmpty()) {
            warning.append("You must enter a first name\n");
        } else {
            name = AName.getText();
        }
        if (ALastname.getText().isEmpty()) {
            warning.append("You must enter a last name\n");
        } else {
            lastname = ALastname.getText();
        }
        DBService d = new DBService();
        if (APassword.getText().isEmpty() == false && APasswordConfirmation.getText().isEmpty() == false) {
            if (d.checkPassword(APassword.getText(), APasswordConfirmation.getText())) {
                JOptionPane.showMessageDialog(this, "the passwords : " + APassword.getText() + "  " + APasswordConfirmation.getText());
                password = APassword.getText();
            } else {
                warning.append("Your passwords must match\n");
            }
        } else {
            warning.append("You must enter a password\n");
        }
        if (!ASSN.getText().matches("\\d{3}-?\\d{2}-?\\d{4}")) { // RegExr website
            warning.append("You must enter correct Social Security Number : xxx-xx-xxxx or xxxxxxxxx\n");
        } else {
            ssn = ASSN.getText().replace("-", "");
        }

        if (warning.length() > 0) {
            JOptionPane.showMessageDialog(this, warning, "ERROR", JOptionPane.WARNING_MESSAGE);
        } else {
            Connection connection = d.connect();
            if (d.findAdminRegister(ssn)) {
                JOptionPane.showMessageDialog(this, "Admin already exist, Rederecting to Login", "ERROR", JOptionPane.WARNING_MESSAGE);
                LoginAdmin menu = new LoginAdmin();
                menu.show();
                dispose();
            } else {
                d.AddAdminAccount(name, lastname, password, ssn);
                MainMenu menu = new MainMenu();
                menu.show();
                dispose();
            }

        }


    }//GEN-LAST:event_CreateAccountBtnActionPerformed

    private void BackMainMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackMainMenuBtnActionPerformed
        MainMenu menu = new MainMenu();
        menu.show();
        dispose();
    }//GEN-LAST:event_BackMainMenuBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ALastname;
    private javax.swing.JTextField AName;
    private javax.swing.JTextField APassword;
    private javax.swing.JTextField APasswordConfirmation;
    private javax.swing.JTextField ASSN;
    private javax.swing.JButton BackMainMenuBtn;
    private javax.swing.JButton CreateAccountBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
