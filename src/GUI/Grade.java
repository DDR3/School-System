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
public class Grade extends javax.swing.JFrame {

    /**
     * Creates new form TeacherInfo
     */
    public Grade() {
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
        try { // Automatically connected to database after the grade info was click 
            Class.forName(sqlDriver);
            connect = DriverManager.getConnection(url, sqlUser, sqlPass);
            statement = connect.createStatement();
            String queryGrade = "SELECT * FROM grades";
            result = statement.executeQuery(queryGrade);
            table = (DefaultTableModel)gradeTable.getModel();
            if (connect != null) {
                System.out.println("Database Connected");
            }     
            while(result.next()) {
                table.addRow(new String[]{result.getString("grade_id"), result.getString("student_id"), result.getString("teacher_id"), result.getString("subject_id"), result.getString("grade")});
            }        
        } catch (SQLException ex) { // Exception for SQL
            Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Database Offline!", "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException ex) { //Exception for Class.forName()
            Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Check if the four textField is not Empty
    public void checkTextField() {
      if(!gradeID.getText().isEmpty() && !studentID.getText().isEmpty() && !teacherID.getText().isEmpty() && !subjectID.getText().isEmpty() && !grade.getText().isEmpty()) {
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
        gradeTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        searchLabel = new javax.swing.JLabel();
        searchBox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        teacherID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        subjectID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        gradeID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        studentID = new javax.swing.JTextField();
        closePanel = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        grade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        gradeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Grade ID", "Student ID", "Teacher ID", "Subject ID", "Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gradeTable.getTableHeader().setReorderingAllowed(false);
        gradeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradeTableMouseClicked(evt);
            }
        });
        scrollTable.setViewportView(gradeTable);
        if (gradeTable.getColumnModel().getColumnCount() > 0) {
            gradeTable.getColumnModel().getColumn(0).setResizable(false);
            gradeTable.getColumnModel().getColumn(1).setResizable(false);
            gradeTable.getColumnModel().getColumn(2).setResizable(false);
            gradeTable.getColumnModel().getColumn(3).setResizable(false);
            gradeTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Grade Management");

        searchLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        searchLabel.setForeground(new java.awt.Color(102, 102, 255));
        searchLabel.setText("Search");

        searchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBoxKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Teacher ID");

        teacherID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                teacherIDKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("Add & Edit");

        subjectID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                subjectIDKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Grade ID");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Subject ID");

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

        gradeID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gradeIDKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Student ID");

        studentID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                studentIDKeyTyped(evt);
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

        grade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gradeKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Grade");

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
                                    .addComponent(gradeID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(studentID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(teacherID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(subjectID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(grade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(103, 103, 103))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(197, 197, 197))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(closePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchBox))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gradeID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(studentID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(teacherID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(scrollTable))
                .addGap(40, 40, 40))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
    // check if userID is not a number
    if(!gradeID.getText().matches("[0-9]+")) {
        JOptionPane.showMessageDialog(this, "Grade ID must be a number!");
    } else {   
        try { // check if grade ID already exists
            String checkQuery = "SELECT * FROM grades WHERE grade_id= ?";
            prestate = connect.prepareStatement(checkQuery);
            prestate.setString(1, gradeID.getText());
            result = prestate.executeQuery();
            if(result.next()) {
                JOptionPane.showMessageDialog(this, "Grade ID already exists!", "Warning", JOptionPane.WARNING_MESSAGE);
            } // add to databebase if teacherID is a number  
            else {
            String addTeacher = "INSERT into grades (grade_id, student_id, teacher_id, subject_id, grade) VALUES (?, ?, ?, ?, ?)";
            prestate = connect.prepareStatement(addTeacher);
            
            prestate.setString(1, gradeID.getText());
            prestate.setString(2, studentID.getText());
            prestate.setString(3, teacherID.getText());
            prestate.setString(4, subjectID.getText());
            prestate.setString(5, grade.getText());
            prestate.executeUpdate();         
            // showMessageDialog
            JOptionPane.showMessageDialog(this, "Added Successfully!");
            //Clear all input
            gradeID.setText("");
            studentID.setText("");
            teacherID.setText("");
            subjectID.setText("");
            // disable add button
            btnAdd.setEnabled(false);
            // automatically update the table
            table.setRowCount(0);
            connectDB();                  
            }
        } catch (SQLException ex) { // Exception for SQL
            Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Database Offline!", "Warning", JOptionPane.WARNING_MESSAGE);
        } 
      }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        //Clear all input
        gradeID.setText("");
        studentID.setText("");
        teacherID.setText("");
        subjectID.setText("");
        grade.setText("");
        searchBox.setText("");
        // automatically get table data
        if(searchBox.getText().isEmpty()){
            table.setRowCount(0);            
            connectDB();
        }     
        // enable teacherID textfield
        gradeID.setEnabled(true);
        studentID.setEnabled(true);
        teacherID.setEnabled(true);
        subjectID.setEnabled(true);
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
        // Check if the teacher_id already exists in the database
        String checkQuery = "SELECT * FROM grades WHERE grade_id = ?";
        prestate = connect.prepareStatement(checkQuery);
        prestate.setString(1, gradeID.getText());
        result = prestate.executeQuery();

        if (result.next()) {
            // teacher_id already exists, perform the update
            String editTeacher = "UPDATE grades SET student_id=?, teacher_id=?, subject_id=?, grade=? WHERE grade_id=?";
            prestate = connect.prepareStatement(editTeacher);
            prestate.setString(1, studentID.getText());
            prestate.setString(2, teacherID.getText());
            prestate.setString(3, subjectID.getText());
            prestate.setString(4, grade.getText());
            prestate.setString(5, gradeID.getText());
            prestate.executeUpdate();
            // showMessageDialog
             JOptionPane.showMessageDialog(this, "Edit Successfully!");
            // Clear all input
            gradeID.setText("");
            studentID.setText("");
            teacherID.setText("");
            subjectID.setText("");
            grade.setText("");
            //enable button
            gradeID.setEnabled(true);
            studentID.setEnabled(true);
            teacherID.setEnabled(true);
            subjectID.setEnabled(true);
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
         Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
         JOptionPane.showMessageDialog(null, "Database Offline!", "Warning", JOptionPane.WARNING_MESSAGE);
       }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void gradeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeTableMouseClicked
        int row = gradeTable.getSelectedRow();
        table = (DefaultTableModel)gradeTable.getModel();
        //get and display info in textbox
        gradeID.setText(table.getValueAt(row, 0).toString());
        studentID.setText(table.getValueAt(row, 1).toString());
        teacherID.setText(table.getValueAt(row, 2).toString());
        subjectID.setText(table.getValueAt(row, 3).toString());
        grade.setText(table.getValueAt(row, 4).toString());
        // enable save & clear button
        btnSave.setEnabled(true);
        btnDelete.setEnabled(true);
        // disable teachID textfield & add button
        btnAdd.setEnabled(false);
        gradeID.setEnabled(false);
        studentID.setEnabled(false);
        teacherID.setEnabled(false);
        subjectID.setEnabled(false);
    }//GEN-LAST:event_gradeTableMouseClicked

    private void gradeIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gradeIDKeyPressed
        // disable save button
        btnSave.setEnabled(false);
        // Check if the four textField is not Empty
        checkTextField();
    }//GEN-LAST:event_gradeIDKeyPressed

    private void studentIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentIDKeyTyped
        // disable save button
        btnSave.setEnabled(false);
        // Check if the four textField is not Empty
        checkTextField();
    }//GEN-LAST:event_studentIDKeyTyped

    private void teacherIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teacherIDKeyTyped
        // disable save button
        btnSave.setEnabled(false);
        // Check if the four textField is not Empty
        checkTextField();
    }//GEN-LAST:event_teacherIDKeyTyped

    private void subjectIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subjectIDKeyTyped
        // disable save button
        btnSave.setEnabled(false);
        // Check if the four textField is not Empty
        checkTextField();
    }//GEN-LAST:event_subjectIDKeyTyped

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       try {
           int row = gradeTable.getSelectedRow();
           String queryDelete = "DELETE FROM grades WHERE grade_id = '" + gradeTable.getModel().getValueAt(row, 0) + "'";
           prestate = connect.prepareStatement(queryDelete);
           prestate.executeUpdate();
           // delete conformation
           JOptionPane.showMessageDialog(this, "Delete Successfully!");
           // disable delete & save button
           btnDelete.setEnabled(false);
           btnSave.setEnabled(false);
           // enable all four textfield
           gradeID.setEnabled(true);
           studentID.setEnabled(true);
           teacherID.setEnabled(true);
           subjectID.setEnabled(true);
           // clear all five textfields
           gradeID.setText("");
           studentID.setText("");
           teacherID.setText("");
           subjectID.setText("");    
           grade.setText("");
           // automatically update the table
           table.setRowCount(0);
           connectDB();
       } catch (SQLException ex) { // Exception for SQL
           Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
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
            String querySearch = "SELECT grade_id, student_id, teacher_id, subject_id, grade FROM grades WHERE grade_id=? OR student_id=? OR teacher_id=? OR subject_id=? OR grade=?";
            prestate = connect.prepareStatement(querySearch);
            prestate.setString(1, searchBox.getText());
            prestate.setString(2, searchBox.getText());
            prestate.setString(3, searchBox.getText());     
            prestate.setString(4, searchBox.getText());
            prestate.setString(5, searchBox.getText());
            result = prestate.executeQuery();
            table.setRowCount(0);
            while(result.next()){
                table.addRow(new String[]{result.getString("grade_id"), result.getString("student_id"), result.getString("teacher_id"), result.getString("subject_id"), result.getString("grade")});
            }
            // automatically get table data
            if(searchBox.getText().isEmpty()) {
                connectDB();
            }              
        } catch (SQLException ex) {
            Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchBoxKeyReleased

    private void gradeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gradeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_gradeKeyTyped

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
            java.util.logging.Logger.getLogger(Grade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Grade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel closePanel;
    private javax.swing.JTextField grade;
    private javax.swing.JTextField gradeID;
    private javax.swing.JTable gradeTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTextField searchBox;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JTextField studentID;
    private javax.swing.JTextField subjectID;
    private javax.swing.JTextField teacherID;
    // End of variables declaration//GEN-END:variables
}
