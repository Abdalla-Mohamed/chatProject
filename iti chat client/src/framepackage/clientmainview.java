/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framepackage;

/**
 *
 * @author user
 */
public class clientmainview extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    public clientmainview() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTree1 = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        add_friend_Buttom = new javax.swing.JToggleButton();
        new_chat_group_Buttom = new javax.swing.JToggleButton();
        block_Button = new javax.swing.JToggleButton();
        my_avilabilty_ComboBox = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        add_friend_menuItem = new javax.swing.JMenuItem();
        Create_Chat_Group_menuItem = new javax.swing.JMenuItem();
        my_availability_menuItem = new javax.swing.JMenu();
        available_MenuItem = new javax.swing.JMenuItem();
        busy_MenuItem = new javax.swing.JMenuItem();
        invisible_MenuItem = new javax.swing.JMenuItem();
        logout_Menu = new javax.swing.JMenu();
        Log_Out_MenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("contact list");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("family");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("abdallah");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("friends");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("bakar");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("coworkers");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("shorouk");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("iti");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("aya");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));

        add_friend_Buttom.setText("add friend");

        new_chat_group_Buttom.setText("new chat group");

        block_Button.setText("block");

        my_avilabilty_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "my availabilty", "available ", "busy", "invisable" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(new_chat_group_Buttom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(my_avilabilty_ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(add_friend_Buttom, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(block_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_friend_Buttom)
                    .addComponent(new_chat_group_Buttom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(block_Button)
                    .addComponent(my_avilabilty_ComboBox))
                .addContainerGap())
        );

        menu.setText("Menu");

        add_friend_menuItem.setText("Add Friend");
        menu.add(add_friend_menuItem);

        Create_Chat_Group_menuItem.setText("Create Chat Group");
        Create_Chat_Group_menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Create_Chat_Group_menuItemActionPerformed(evt);
            }
        });
        menu.add(Create_Chat_Group_menuItem);

        my_availability_menuItem.setText("my availability");
        my_availability_menuItem.setToolTipText("");

        available_MenuItem.setText("available");
        my_availability_menuItem.add(available_MenuItem);

        busy_MenuItem.setText("busy");
        busy_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busy_MenuItemActionPerformed(evt);
            }
        });
        my_availability_menuItem.add(busy_MenuItem);

        invisible_MenuItem.setText("invisible");
        invisible_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invisible_MenuItemActionPerformed(evt);
            }
        });
        my_availability_menuItem.add(invisible_MenuItem);

        menu.add(my_availability_menuItem);

        jMenuBar1.add(menu);

        logout_Menu.setText("Log Out ");

        Log_Out_MenuItem.setText("Log Out");
        logout_Menu.add(Log_Out_MenuItem);

        jMenuBar1.add(logout_Menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTree1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTree1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Create_Chat_Group_menuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Create_Chat_Group_menuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Create_Chat_Group_menuItemActionPerformed

    private void busy_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busy_MenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_busy_MenuItemActionPerformed

    private void invisible_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invisible_MenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invisible_MenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(clientmainview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clientmainview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clientmainview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clientmainview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new clientmainview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Create_Chat_Group_menuItem;
    private javax.swing.JMenuItem Log_Out_MenuItem;
    private javax.swing.JToggleButton add_friend_Buttom;
    private javax.swing.JMenuItem add_friend_menuItem;
    private javax.swing.JMenuItem available_MenuItem;
    private javax.swing.JToggleButton block_Button;
    private javax.swing.JMenuItem busy_MenuItem;
    private javax.swing.JMenuItem invisible_MenuItem;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTree jTree1;
    private javax.swing.JMenu logout_Menu;
    private javax.swing.JMenu menu;
    private javax.swing.JMenu my_availability_menuItem;
    private javax.swing.JComboBox<String> my_avilabilty_ComboBox;
    private javax.swing.JToggleButton new_chat_group_Buttom;
    // End of variables declaration//GEN-END:variables
}