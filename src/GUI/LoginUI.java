/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author NGR
 */
public class LoginUI extends javax.swing.JFrame {

    /**
     * Creates new form LoginUI
     */
    public LoginUI() throws ClassNotFoundException {
        initComponents();
        connectDB();
        // lock window size
        this.setResizable(false);        
    }
    
    final String url = "jdbc:mysql://localhost:3306/schooldb";
    final String sqlDriver = "com.mysql.cj.jdbc.Driver";
    final String sqlUser = "root";
    final String sqlPass = "@mySQL36";
    
    Connection connect;
    PreparedStatement prestate;
    Statement statement;
    ResultSet result;
    
    // Connect to database
    public void connectDB() throws ClassNotFoundException {
        try { 
            Class.forName(sqlDriver);
            connect = DriverManager.getConnection(url, sqlUser, sqlPass);
            statement = connect.createStatement();
            if (connect != null) {
                System.out.println("Database Connected");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Database Offline!");
        }
    }
    
    // LogIn() Method
    public void LogIn() {
        //If userID and Password is Empty
        if (userID.getText().equals("") && password.getText().equals("") ) {
            JOptionPane.showMessageDialog(null, "User ID and Password are Required!", "Warning", JOptionPane.WARNING_MESSAGE);
        } // if userID is Empty
        else if (userID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "User ID Required!", "Warning", JOptionPane.WARNING_MESSAGE);
        } // if Password is Empty
        else if (password.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Password Required!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try { // if Admin
                String queryLogin = "SELECT * FROM admin_info WHERE admin_id = ? AND password = ?";
                prestate = connect.prepareStatement(queryLogin);
                prestate.setString(1, userID.getText());
                prestate.setString(2, password.getText());
                result = prestate.executeQuery();
                if (result.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successfully!");
                    AdminUI admin = new AdminUI();
                    admin.setVisible(true);
                    this.dispose();
                } else {   // if Teacher
                    queryLogin = "SELECT * FROM teacher_info WHERE teacher_id = ? AND password = ?";
                    prestate = connect.prepareStatement(queryLogin);
                    prestate.setString(1, userID.getText());
                    prestate.setString(2, password.getText());
                    result = prestate.executeQuery();
                    if (result.next()) {
                        JOptionPane.showMessageDialog(null, "Login Successfully!");
                        TeacherUI teacher = new TeacherUI();
                        teacher.setVisible(true);
                        this.dispose();
                    } else {  // if Student
                        queryLogin = "SELECT * FROM student_info WHERE student_id = ? AND password = ?";
                        prestate = connect.prepareStatement(queryLogin);
                        prestate.setString(1, userID.getText());
                        prestate.setString(2, password.getText());
                        result = prestate.executeQuery();
                        if (result.next()) {
                            JOptionPane.showMessageDialog(null, "Login Successfully!");
                            StudentUI student = new StudentUI(userID.getText());
                            student.setVisible(true);
                            this.dispose();
                        } else { // if user ID and Password does not match in the database
                            JOptionPane.showMessageDialog(null, "Invalid User ID or Password!", "Warning", JOptionPane.WARNING_MESSAGE);
                            userID.setText("");
                            password.setText("");
                        }
                    }
                }
            }  catch (SQLException ex) { // Exception for SQL
                Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        schoolName = new javax.swing.JLabel();
        motto = new javax.swing.JLabel();
        welcome = new javax.swing.JLabel();
        labeluserID = new javax.swing.JLabel();
        userID = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        showPassword = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        leftPanel.setBackground(new java.awt.Color(204, 204, 255));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/School Icon/StoreLogo.scale-300.png"))); // NOI18N

        schoolName.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        schoolName.setForeground(new java.awt.Color(255, 102, 102));
        schoolName.setText("MAXIS HIGH SCHOOL ACADEMY");

        motto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        motto.setForeground(new java.awt.Color(102, 102, 255));
        motto.setText("Innovate, Invent & Lead");

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logo)
                .addGap(37, 37, 37))
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(schoolName))
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(motto)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(schoolName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(motto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        welcome.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        welcome.setForeground(new java.awt.Color(102, 102, 255));
        welcome.setText("Welcome!");

        labeluserID.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        labeluserID.setText("User ID:");

        userID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userIDKeyPressed(evt);
            }
        });

        labelPassword.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        labelPassword.setText("Password:");

        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        showPassword.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        showPassword.setText("Show Password");
        showPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPassword)
                            .addComponent(showPassword)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(labeluserID, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(userID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(welcome)))
                .addGap(0, 47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(welcome)
                .addGap(28, 28, 28)
                .addComponent(labeluserID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userID, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(labelPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(showPassword)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // run login method    
        LogIn();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        //Clear UserID and Password
        userID.setText("");
        password.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void showPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordActionPerformed
        //enable show password
        if (showPassword.isSelected()) {
            password.setEchoChar((char)0);
        } else { //disable show password
            password.setEchoChar('*');
        }
    }//GEN-LAST:event_showPasswordActionPerformed

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        // if enter key is press run logIn() method
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
           LogIn();
        }    
    }//GEN-LAST:event_passwordKeyPressed

    private void userIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userIDKeyPressed
        // if enter key is press move inpunt to password    
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
           password.requestFocus();
        }    
    }//GEN-LAST:event_userIDKeyPressed

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
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LoginUI().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labeluserID;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel motto;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel schoolName;
    private javax.swing.JCheckBox showPassword;
    private javax.swing.JTextField userID;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
