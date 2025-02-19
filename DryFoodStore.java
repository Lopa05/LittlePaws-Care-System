/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petscare;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Maryam Tariq
 */
public class DryFoodStore extends javax.swing.JFrame {
    
    Connection con;
    Statement st;
    ResultSet rs;

    /**
     * Creates new form DryFoodStore
     */
    public DryFoodStore() {
        initComponents();
        fillMenu();
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
    
    public void fillMenu()
    {
        try
        {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/PetsCare","root","root");
            st=con.createStatement();
            rs=st.executeQuery("SELECT Count(*) FROM Food WHERE Food_Type = 'Dry' AND Quantity > 0");
            rs.next();
            
            int numOfRecored = rs.getInt(1);
            
            JPanel[] panels = new JPanel[numOfRecored];
            Box[] box = new Box[numOfRecored];
            JLabel[] imageLabels = new JLabel[numOfRecored];
            JLabel[] IDLabels = new JLabel[numOfRecored];
            JLabel[] nameLabels = new JLabel[numOfRecored];
            JLabel[] venNameLabels = new JLabel[numOfRecored];
            JLabel[] peiceLabels = new JLabel[numOfRecored];
            
            for(int i = 0; i < numOfRecored; i++)
            {
                panels[i] = new JPanel();
                panels[i].setBackground(new Color(237,240,255));
                panels[i].setPreferredSize(new Dimension(350,400));
                //panels[i].setSize(600, 600);
                
                imageLabels[i] = new JLabel();
                IDLabels[i] = new JLabel();
                nameLabels[i] = new JLabel();
                venNameLabels[i] = new JLabel();
                peiceLabels[i] = new JLabel();
                box[i] = Box.createVerticalBox();
                
                IDLabels[i].setFont(new Font("Century Gothic", Font.PLAIN, 16));
                nameLabels[i].setFont(new Font("Century Gothic", Font.PLAIN, 16));
                venNameLabels[i].setFont(new Font("Century Gothic", Font.PLAIN, 16));
                peiceLabels[i].setFont(new Font("Century Gothic", Font.PLAIN, 16));
            }
            
            rs=st.executeQuery("SELECT * FROM Food WHERE Food_Type = 'Dry' AND Quantity > 0");
            rs.next();
            
                for(int i = 0; i < numOfRecored; i++)
                {
                    String path = rs.getString("ImagePath");
                    imageLabels[i].setIcon(new ImageIcon(getClass().getResource("Icon/" + path)));
                    IDLabels[i].setText("Prouduct ID: " + rs.getInt("FoodID"));
                    nameLabels[i].setText(rs.getString("Food_Name"));
                    venNameLabels[i].setText("Vendor Name: " + rs.getString("VendorName"));
                    peiceLabels[i].setText("Price: " + rs.getDouble("Price") + " SAR");

                    
                    box[i].add(new JLabel(" "));
                    box[i].add(imageLabels[i]);
                    box[i].add(new JLabel(" "));
                    box[i].add(new JLabel(" "));
                    box[i].add(IDLabels[i]);
                    box[i].add(nameLabels[i]);
                    box[i].add(venNameLabels[i]);
                    box[i].add(peiceLabels[i]);

                    panels[i].add(box[i]);
                    menuPanel.add(panels[i]);
                    rs.next();
                }           
        }
        
        catch (SQLException ex)
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
        jScrollPane1 = new javax.swing.JScrollPane();
        menuPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        cartLabel = new javax.swing.JLabel();
        backLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dry Food Store");
        setMaximumSize(new java.awt.Dimension(900, 550));
        setMinimumSize(new java.awt.Dimension(900, 550));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        menuPanel.setBackground(new java.awt.Color(255, 255, 255));
        menuPanel.setPreferredSize(new java.awt.Dimension(600, 1800));
        jScrollPane1.setViewportView(menuPanel);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(78, 95, 200));
        jLabel38.setText("DRY FOOD");

        cartLabel.setForeground(new java.awt.Color(144, 143, 150));
        cartLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petscare/Icon/shopping-cart (1) (1) (1) (1).png"))); // NOI18N
        cartLabel.setText("CART");
        cartLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartLabelMouseClicked(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(backLabel)
                .addGap(259, 259, 259)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cartLabel)
                .addGap(39, 39, 39))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cartLabel)
                    .addComponent(backLabel)
                    .addComponent(jLabel38))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(914, 587));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLabelMouseClicked
        // TODO add your handling code here:

        this.setVisible(false);
        PetFood food = new PetFood();
        food.setVisible(true);
    }//GEN-LAST:event_backLabelMouseClicked

    private void cartLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartLabelMouseClicked
        // TODO add your handling code here:
        
        this.setVisible(false);
        Cart cart = new Cart();
        cart.setVisible(true);
    }//GEN-LAST:event_cartLabelMouseClicked

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
            java.util.logging.Logger.getLogger(DryFoodStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DryFoodStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DryFoodStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DryFoodStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DryFoodStore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backLabel;
    private javax.swing.JLabel cartLabel;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menuPanel;
    // End of variables declaration//GEN-END:variables
}
