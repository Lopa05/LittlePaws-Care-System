/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petscare;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils; 

/**
 *
 * @author Maryam Tariq
 */
public class ManageCustomer extends javax.swing.JFrame {
    
    Connection con;
    Statement st;
    ResultSet rs;

    /**
     * Creates new form ManageCustomer
     */
    public ManageCustomer() {
        initComponents();
        fillTable();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(
            new WindowAdapter()
            {
                @Override
                public void windowClosed(WindowEvent event)
                {
                    closeDB();
                    System.exit(0);
                }
            }
        );
    }
    
    public void fillTable()
    {
        try
        {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/PetsCare","root","root");
            st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM Customer");
            
            custTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    
    public void closeDB()
    {
        try
        {
            rs.close();
            st.close();
            con.close();
        }
        
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(this, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        custIDTxt = new javax.swing.JTextField();
        fNameTxt = new javax.swing.JTextField();
        lNameTxt = new javax.swing.JTextField();
        usernameTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        custTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        passTxt = new javax.swing.JTextField();
        phoneTxt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        genderBox = new javax.swing.JComboBox<>();
        backLabel = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Customer");
        setMaximumSize(new java.awt.Dimension(900, 550));
        setMinimumSize(new java.awt.Dimension(900, 550));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(78, 95, 200));
        jLabel4.setText("Manage Customer");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(144, 143, 150));
        jLabel5.setText("First Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(144, 143, 150));
        jLabel6.setText("Customer ID");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(144, 143, 150));
        jLabel7.setText("Last Name");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(144, 143, 150));
        jLabel8.setText("Gender");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(144, 143, 150));
        jLabel10.setText("Phone");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(144, 143, 150));
        jLabel11.setText("Password");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(144, 143, 150));
        jLabel12.setText("User Name");

        custIDTxt.setEditable(false);
        custIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custIDTxtActionPerformed(evt);
            }
        });

        lNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lNameTxtActionPerformed(evt);
            }
        });

        custTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Customer_ID", "FirstName", "LastName", "Gender", "UserName", "Password", "Phone"
            }
        ));
        custTable.setRowHeight(20);
        custTable.setSelectionBackground(new java.awt.Color(204, 204, 255));
        custTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(custTable);

        addButton.setBackground(new java.awt.Color(78, 95, 200));
        addButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setBackground(new java.awt.Color(78, 95, 200));
        removeButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        removeButton.setForeground(new java.awt.Color(255, 255, 255));
        removeButton.setText("REMOVE");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(78, 95, 200));
        editButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("EDIT");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        clearButton.setBackground(new java.awt.Color(78, 95, 200));
        clearButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        phoneTxt.setText("05");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 27)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(193, 193, 255));
        jLabel15.setText("CUSTOMER LIST");

        genderBox.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        genderBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        genderBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderBoxActionPerformed(evt);
            }
        });

        backLabel.setForeground(new java.awt.Color(144, 143, 150));
        backLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petscare/Icon/back (1) (1) (1) (1).png"))); // NOI18N
        backLabel.setText(" BACK");
        backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backLabelMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(144, 143, 150));
        jLabel13.setText("Email");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(removeButton)
                .addGap(37, 37, 37)
                .addComponent(clearButton)
                .addGap(116, 116, 116))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(329, 329, 329)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(backLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(47, 47, 47))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(211, 211, 211)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(custIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fNameTxt)
                                    .addComponent(lNameTxt)
                                    .addComponent(genderBox, 0, 144, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel13))
                                .addGap(51, 51, 51)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(132, 132, 132))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backLabel)))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(custIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(fNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(genderBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(passTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(removeButton)
                    .addComponent(clearButton)
                    .addComponent(editButton))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(914, 587));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void custIDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custIDTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custIDTxtActionPerformed

    private void lNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lNameTxtActionPerformed

    private void genderBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderBoxActionPerformed

    private void backLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLabelMouseClicked
        // TODO add your handling code here:

        this.setVisible(false);
        Employee emp = new Employee();
        emp.setVisible(true);
    }//GEN-LAST:event_backLabelMouseClicked

    private void custTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custTableMouseClicked
        // TODO add your handling code here:
        
        try
        {
            int selectRow = custTable.getSelectedRow();
            int SelectID = Integer.parseInt(custTable.getModel().getValueAt(selectRow,0).toString());

            String query = "SELECT * FROM Customer WHERE CustomerID = " + SelectID;
            rs = st.executeQuery(query);

            rs.next();
            custIDTxt.setText(String.format("%d", rs.getInt("CustomerID")));
            fNameTxt.setText(rs.getString("FirstName"));
            lNameTxt.setText(rs.getString("LastName"));
            String s = rs.getString("Gender");
            char gender = s.charAt(0);
            if(gender == 'M')
                genderBox.setSelectedIndex(0);
            else
                genderBox.setSelectedIndex(1);
            usernameTxt.setText(rs.getString("UserName"));
            passTxt.setText(rs.getString("Password"));
            phoneTxt.setText(String.format("%d", rs.getInt("Phone")));
            emailTxt.setText(rs.getString("Email"));
        }

        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_custTableMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        if(fNameTxt.getText().isEmpty() || lNameTxt.getText().isEmpty() || genderBox.getSelectedIndex() == -1 || usernameTxt.getText().isEmpty() || passTxt.getText().isEmpty() || phoneTxt.getText().isEmpty())
            JOptionPane.showMessageDialog(this, "Missing Information", "Error", JOptionPane.WARNING_MESSAGE);
        
        else if (!phoneTxt.getText().matches("(05)([0-9]{8})"))
                JOptionPane.showMessageDialog(this, "Invalid Phone Number: Please Enter 10 digit Start with 05 only", "Invalid Phone Number", JOptionPane.ERROR_MESSAGE);
        
        else if (!emailTxt.getText().matches("^(.+)@(\\S+)$"))
            JOptionPane.showMessageDialog(this, "Invalid Email: Please Check your Entery", "Invalid Invalid Email", JOptionPane.ERROR_MESSAGE);
        
        else
        {
            try
            {
                PreparedStatement insertQuery = con.prepareStatement("INSERT INTO Customer ( FirstName, LastName, Gender, UserName, Password, Phone, Email)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)");

                insertQuery.setString(1, fNameTxt.getText());
                insertQuery.setString(2, lNameTxt.getText());
                insertQuery.setString(3, (genderBox.getSelectedIndex() == 0) ? "M" : "F");
                insertQuery.setString(4, usernameTxt.getText());
                insertQuery.setString(5, passTxt.getText());
                insertQuery.setInt(6, Integer.valueOf(phoneTxt.getText()));
                insertQuery.setString(7, emailTxt.getText());

                int result = insertQuery.executeUpdate();
                if(result == 1)
                JOptionPane.showMessageDialog(this, "Customer " + fNameTxt.getText() + " " + lNameTxt.getText() + " is Addedd");

                closeDB();
                fillTable();
            }

            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(this, "You Enter Wrong Entery Type", "Error", JOptionPane.WARNING_MESSAGE);
            }

            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        
        custIDTxt.setText("");
        fNameTxt.setText("");
        lNameTxt.setText("");
        genderBox.setSelectedIndex(-1);
        usernameTxt.setText("");
        passTxt.setText("");
        phoneTxt.setText("05");
        emailTxt.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        
        if(fNameTxt.getText().isEmpty() || lNameTxt.getText().isEmpty() || genderBox.getSelectedIndex() == -1 || usernameTxt.getText().isEmpty() || passTxt.getText().isEmpty() || phoneTxt.getText().isEmpty() || emailTxt.getText().isEmpty())
            JOptionPane.showMessageDialog(this, "Missing Information", "Error", JOptionPane.WARNING_MESSAGE);
        
        else if (!phoneTxt.getText().matches("(05)([0-9]{8})"))
                JOptionPane.showMessageDialog(this, "Invalid Phone Number: Please Enter 10 digit Start with 05 only", "Invalid Phone Number", JOptionPane.ERROR_MESSAGE);
        
        else if (!emailTxt.getText().matches("^(.+)@(\\S+)$"))
            JOptionPane.showMessageDialog(this, "Invalid Email: Please Check your Entery", "Invalid Invalid Email", JOptionPane.ERROR_MESSAGE);
        
        else
        {
            try
            {
                PreparedStatement updateQuery = con.prepareStatement("UPDATE Customer SET FirstName = ?, LastName = ?, Gender = ?, UserName = ?, Password = ?, Phone = ?, Email = ? WHERE CustomerID = ?");

                updateQuery.setString(1, fNameTxt.getText());
                updateQuery.setString(2, lNameTxt.getText());
                updateQuery.setString(3, genderBox.getSelectedIndex() == 0 ? "M" : "F");
                updateQuery.setString(4, usernameTxt.getText());
                updateQuery.setString(5, passTxt.getText());
                updateQuery.setInt(6, Integer.valueOf(phoneTxt.getText()));
                updateQuery.setString(7, emailTxt.getText());
                updateQuery.setInt(8, Integer.valueOf(custIDTxt.getText()));
                

                int result = updateQuery.executeUpdate();
                if(result == 1)
                JOptionPane.showMessageDialog(this, "Selected Recored is Updated");
                else
                JOptionPane.showMessageDialog(this, "Failed: Selected Recored is not Updated");

                closeDB();
                fillTable();
            }

            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(this, "You Enter Wrong Entery Type", "Error", JOptionPane.WARNING_MESSAGE);
            }

            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        
        try
        {
            int confirm = JOptionPane.showConfirmDialog(this, "You Want to Delete Selected Recored?", "Delete Recored", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION)
            {
                String DeleteQuery = "DELETE FROM Customer WHERE CustomerID = " + custIDTxt.getText();
                int result = st.executeUpdate(DeleteQuery);
                if(result == 1)
                JOptionPane.showMessageDialog(this, "Selected Recored is Deleted");

                custIDTxt.setText("");
                fNameTxt.setText("");
                lNameTxt.setText("");
                genderBox.setSelectedIndex(-1);
                usernameTxt.setText("");
                passTxt.setText("");
                phoneTxt.setText("05");
                emailTxt.setText("");

                closeDB();
                fillTable();
            }
        }

        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(this, "Order in progress. Delete first!");
        }

        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_removeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ManageCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel backLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField custIDTxt;
    private javax.swing.JTable custTable;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField fNameTxt;
    private javax.swing.JComboBox<String> genderBox;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lNameTxt;
    private javax.swing.JTextField passTxt;
    private javax.swing.JTextField phoneTxt;
    private javax.swing.JButton removeButton;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}
