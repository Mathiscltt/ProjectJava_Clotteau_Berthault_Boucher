/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_java_clotteau_berthault_boucher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static project_java_clotteau_berthault_boucher.LoginAdmin.idadmin;

/**
 *
 * @author mclot
 */
public class LoginUser extends javax.swing.JFrame {

    public static String Ufirstname;
    public static String Ulastname;
    public static int idUser;
    public static String Upassword;

    /**
     * Creates new form LoginUser
     */
    public LoginUser() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        UFname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ULname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        UPassword = new javax.swing.JTextField();
        UserLogin = new javax.swing.JButton();
        BackMainMenuBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Login User");

        jPanel2.setLayout(new java.awt.GridLayout(3, 2));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Firstname");
        jPanel2.add(jLabel2);
        jPanel2.add(UFname);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Lastname");
        jPanel2.add(jLabel4);
        jPanel2.add(ULname);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Password");
        jPanel2.add(jLabel3);
        jPanel2.add(UPassword);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(142, 142, 142))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );

        UserLogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        UserLogin.setText("LOGIN");
        UserLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserLoginActionPerformed(evt);
            }
        });

        BackMainMenuBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(BackMainMenuBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(UserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(UserLogin)
                .addGap(18, 18, 18)
                .addComponent(BackMainMenuBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserLoginActionPerformed
        StringBuilder warning = new StringBuilder();
        String firstname = "", lastname = "", ssn = "", password = "";
        if (UFname.getText().isEmpty()) {
            warning.append("You must enter a first name\n");
        } else {
            firstname = UFname.getText();
            Ufirstname = firstname;
        }
        if (ULname.getText().isEmpty()) {
            warning.append("You must enter a last name\n");
        } else {
            lastname = ULname.getText();
            Ulastname = lastname;
        }
        if (UPassword.getText().isEmpty()) {
            warning.append("You must enter a password\n");
        } else {
            password = UPassword.getText();
            Upassword = password;
        }
        if (warning.length() > 0) {
            JOptionPane.showMessageDialog(this, warning, "LOGIN FAILED", JOptionPane.WARNING_MESSAGE);
        } else {
            DBService d = new DBService();
            if (d.findUser(firstname, lastname, password)) {
                JOptionPane.showMessageDialog(this, "Welcome" + UFname.getText());
                Connection connection = d.connect();
                Statement stmt;
                try {
                    stmt = connection.createStatement();
                    String ID = "SELECT UserID FROM users WHERE FirstName='" + firstname + "' AND LastName='" + lastname + "'";
                    ResultSet rset = stmt.executeQuery(ID);
                    rset.next();
                    System.out.println("The ID of the User is :" + rset.getInt(1));
                    idUser = rset.getInt(1);
                    UserView menu = new UserView();
                    menu.show();
                    dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(LoginAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Your informations are not correct");
            }
        }
    }//GEN-LAST:event_UserLoginActionPerformed

    private void BackMainMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackMainMenuBtnActionPerformed
        MainMenu menu = new MainMenu();
        menu.show();
        dispose();
    }//GEN-LAST:event_BackMainMenuBtnActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(LoginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackMainMenuBtn;
    private javax.swing.JTextField UFname;
    private javax.swing.JTextField ULname;
    private javax.swing.JTextField UPassword;
    private javax.swing.JButton UserLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
