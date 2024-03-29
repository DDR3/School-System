/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author NGR
 */
public class AdminInfo extends javax.swing.JFrame {

    /**
     * Creates new form AdminInfo
     */
    public AdminInfo() {
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
    DefaultTableModel table;
    
    public void connectDB() {
        try { // Automatically connected to database after the admin info was click 
            Class.forName(sqlDriver);
            connect = DriverManager.getConnection(url, sqlUser, sqlPass);
            statement = connect.createStatement();
            String queryAdmin = "SELECT * FROM admin_info";
            result = statement.executeQuery(queryAdmin);
            table = (DefaultTableModel)adminTable.getModel();
            if (connect != null) {
                System.out.println("Database Connected");
            }     
            while(result.next()) {
                table.addRow(new String[]{result.getString("admin_id"), result.getString("password")});
            }        
        } catch (SQLException ex) { // Exception for SQL
            Logger.getLogger(AdminInfo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Database Offline!", "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException ex) { //Exception for Class.forName()
            Logger.getLogger(AdminInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Check if the two textField is not Empty
    public void checkTextField() {
      if(!adminID.getText().isEmpty() && !pass.getText().isEmpty()) {
            btnAdd.setEnabled(true);
            btnSave.setEnabled(true);
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

        scrollTable = new javax.swing.JScrollPane();
        adminTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        searchLabel = new javax.swing.JLabel();
        searchBox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pass = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        adminID = new javax.swing.JTextField();
        closePanel = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        adminTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Admin ID", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        adminTable.getTableHeader().setReorderingAllowed(false);
        adminTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminTableMouseClicked(evt);
            }
        });
        scrollTable.setViewportView(adminTable);
        if (adminTable.getColumnModel().getColumnCount() > 0) {
            adminTable.getColumnModel().getColumn(0).setResizable(false);
            adminTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Admin Information");

        searchLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        searchLabel.setForeground(new java.awt.Color(102, 102, 255));
        searchLabel.setText("Search");

        searchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoxActionPerformed(evt);
            }
        });
        searchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBoxKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("Add & Edit ");

        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Admin ID:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Password");

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        adminID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                adminIDKeyPressed(evt);
            }
        });

        closePanel.setBackground(new java.awt.Color(204, 204, 255));

        btnClose.setBackground(new java.awt.Color(255, 153, 153));
        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout closePanelLayout = new javax.swing.GroupLayout(closePanel);
        closePanel.setLayout(closePanelLayout);
        closePanelLayout.setHorizontalGroup(
            closePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        closePanelLayout.setVerticalGroup(
            closePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(closePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(adminID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(98, 98, 98))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(221, 221, 221))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(closePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchBox))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adminID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try { // check if admin ID already exists
            String checkQuery = "SELECT * FROM admin_info WHERE admin_id = ?";
            prestate = connect.prepareStatement(checkQuery);
            prestate.setString(1, adminID.getText());
            result = prestate.executeQuery();
            if(result.next()) {
                JOptionPane.showMessageDialog(this, "Admin ID already exists!", "Warning", JOptionPane.WARNING_MESSAGE);
            } // add to databebase if adminID is a number  
            else {
            String addAdmin = "INSERT into admin_info (admin_id, password) VALUES (?, ?)";
            prestate = connect.prepareStatement(addAdmin);
            
            prestate.setString(1, adminID.getText());
            prestate.setString(2, pass.getText());
            prestate.executeUpdate();         
            // showMessageDialog
            JOptionPane.showMessageDialog(this, "Added Successfully!");
            //Clear all input
            adminID.setText("");
            pass.setText("");
            // disable add button
            btnAdd.setEnabled(false);
            // automatically update the table
            table.setRowCount(0);
            connectDB();                  
            }
        } catch (SQLException ex) { // Exception for SQL
            Logger.getLogger(AdminInfo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Database Offline!", "Warning", JOptionPane.WARNING_MESSAGE);
        } 
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        //Clear all input
        adminID.setText("");
        pass.setText("");
        searchBox.setText("");
        // automatically get table data
        if(searchBox.getText().isEmpty()){
            table.setRowCount(0);            
            connectDB();
        }  
        // enable adminID textfield
        adminID.setEnabled(true);
        // disable delete, Save and Add button
        btnDelete.setEnabled(false);
        btnSave.setEnabled(false);
        btnAdd.setEnabled(false);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // update table        
        table.setRowCount(0);
        connectDB();    
        JOptionPane.showMessageDialog(this, "Table has been Updated!");
        searchBox.setText("");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        AdminUI admin = new AdminUI();
        admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
    try {
        // Check if the admin_id already exists in the database
        String checkQuery = "SELECT * FROM admin_info WHERE admin_id = ?";
        prestate = connect.prepareStatement(checkQuery);
        prestate.setString(1, adminID.getText());
        result = prestate.executeQuery();

        if (result.next()) {
            // admin_id already exists, perform the update
            String editAdmin = "UPDATE admin_info SET password=? WHERE admin_id=?";
            prestate = connect.prepareStatement(editAdmin);
            prestate.setString(1, pass.getText());
            prestate.setString(2, adminID.getText());
            prestate.executeUpdate();
            // showMessageDialog
             JOptionPane.showMessageDialog(this, "Edit Successfully!");
            // Clear all input
            adminID.setText("");
            pass.setText("");
            // enable adminID textfield
            adminID.setEnabled(true);
            // disable save, add & delete button
            btnSave.setEnabled(false);
            btnAdd.setEnabled(false);
            btnDelete.setEnabled(false);
            // automatically update the table
            table.setRowCount(0);
            connectDB();
        } 
    } catch (SQLException ex) {
         // Exception for SQL
         Logger.getLogger(AdminInfo.class.getName()).log(Level.SEVERE, null, ex);
         JOptionPane.showMessageDialog(null, "Database Offline!", "Warning", JOptionPane.WARNING_MESSAGE);
       }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void adminTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminTableMouseClicked
        int row = adminTable.getSelectedRow();
        table = (DefaultTableModel)adminTable.getModel();
        //get and display info in textbox
        adminID.setText(table.getValueAt(row, 0).toString());
        pass.setText(table.getValueAt(row, 1).toString());
        // enable save & clear button
        btnSave.setEnabled(true);
        btnDelete.setEnabled(true);
        // disable adminID textfield & add button
        btnAdd.setEnabled(false);
        adminID.setEnabled(false);
    }//GEN-LAST:event_adminTableMouseClicked

    private void adminIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminIDKeyPressed
        // disable save button
        btnSave.setEnabled(false);
        // Check if the two textField is not Empty
        checkTextField();
    }//GEN-LAST:event_adminIDKeyPressed

    private void passKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyTyped
        // disable save button
        btnSave.setEnabled(false);
        // Check if the two textField is not Empty
        checkTextField();
    }//GEN-LAST:event_passKeyTyped

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       try {
           int row = adminTable.getSelectedRow();
           String queryDelete = "DELETE FROM admin_info WHERE admin_id = '" + adminTable.getModel().getValueAt(row, 0) + "'";
           prestate = connect.prepareStatement(queryDelete);
           prestate.executeUpdate();
           // delete indication
           JOptionPane.showMessageDialog(this, "Delete Successfully!");
           // disable delete & save button
           btnDelete.setEnabled(false);
           btnSave.setEnabled(false);
           // enable adminID textfield
           adminID.setEnabled(true);
           // clear all two textfields
           adminID.setText("");
           pass.setText("");    
           // automatically update the table
           table.setRowCount(0);
           connectDB();
       } catch (SQLException ex) { // Exception for SQL
           Logger.getLogger(AdminInfo.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "Database Offline!", "Warning", JOptionPane.WARNING_MESSAGE);
       } 
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // disable delete, Save and Add button when window is open
        btnDelete.setEnabled(false);
        btnSave.setEnabled(false);
        btnAdd.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened

    private void searchBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBoxKeyReleased
        try {
            String querySearch = "SELECT admin_id, password FROM admin_info WHERE admin_id=? or password=?";
            prestate = connect.prepareStatement(querySearch);
            prestate.setString(1, searchBox.getText());   
            prestate.setString(2, searchBox.getText());
            result = prestate.executeQuery();
            table.setRowCount(0);
            while(result.next()){
                table.addRow(new String[]{result.getString("admin_id"), result.getString("password")});
            }
            // automatically get table data
            if(searchBox.getText().isEmpty()) {
                connectDB();
            }              
        } catch (SQLException ex) {
            Logger.getLogger(AdminInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchBoxKeyReleased

    private void searchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoxActionPerformed

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
            java.util.logging.Logger.getLogger(AdminInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adminID;
    private javax.swing.JTable adminTable;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel closePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField pass;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTextField searchBox;
    private javax.swing.JLabel searchLabel;
    // End of variables declaration//GEN-END:variables
}
