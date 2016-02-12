/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framepackage;

import iti.chat.client.connections.ConnctionHndlr;
import iti.chat.entites.Category;
import iti.chat.entites.ChatGroup;
import iti.chat.entites.Client;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 *
 * @author user
 */
public class clientmainview extends javax.swing.JFrame {

    Client c;
    ConnctionHndlr controller;
    HashMap<DefaultMutableTreeNode, Object> treeMap;

    public clientmainview(Client client) {
        initComponents();
        c = client;
        treeMap = new HashMap<>();
        DefaultTreeModel treeModel = new DefaultTreeModel(processHierarchy());
        jTree1.setModel(treeModel);
        controller = new ConnctionHndlr();
        repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jTree1 = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        block_Button = new javax.swing.JToggleButton();
        my_avilabilty_ComboBox = new javax.swing.JComboBox<>();
        add_friend_Buttom = new javax.swing.JButton();
        new_chat_group_Buttom = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        Friends_Menu = new javax.swing.JMenu();
        add_friend_menuItem = new javax.swing.JMenuItem();
        remove_friend_menuItem = new javax.swing.JMenuItem();
        block_Friend_MenuItem = new javax.swing.JMenuItem();
        send_Mail_MenuItem = new javax.swing.JMenuItem();
        settings_Menu = new javax.swing.JMenu();
        Create_Chat_Group_menuItem = new javax.swing.JMenuItem();
        my_availability_menuItem = new javax.swing.JMenu();
        available_MenuItem = new javax.swing.JMenuItem();
        busy_MenuItem = new javax.swing.JMenuItem();
        invisible_MenuItem = new javax.swing.JMenuItem();
        logout_Menu = new javax.swing.JMenu();
        Log_Out_MenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTree1.setAutoscrolls(true);
        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTree1MousePressed(evt);
            }
        });
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });

        block_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientGUI/Images/blocked offline.png"))); // NOI18N
        block_Button.setToolTipText("block friend");
        block_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                block_ButtonActionPerformed(evt);
            }
        });

        my_avilabilty_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "my availabilty", "available ", "busy", "invisable" }));

        add_friend_Buttom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientGUI/Images/add.png"))); // NOI18N
        add_friend_Buttom.setToolTipText("add friend");
        add_friend_Buttom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add_friend_Buttom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_friend_ButtomActionPerformed(evt);
            }
        });

        new_chat_group_Buttom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientGUI/Images/27.png"))); // NOI18N
        new_chat_group_Buttom.setToolTipText("new chat");
        new_chat_group_Buttom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_chat_group_ButtomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(my_avilabilty_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(new_chat_group_Buttom, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(add_friend_Buttom, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(block_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {add_friend_Buttom, block_Button});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(new_chat_group_Buttom, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(my_avilabilty_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(block_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(add_friend_Buttom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        Friends_Menu.setText("Friends");

        add_friend_menuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientGUI/Images/add.png"))); // NOI18N
        add_friend_menuItem.setText("Add Friend");
        add_friend_menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_friend_menuItemActionPerformed(evt);
            }
        });
        Friends_Menu.add(add_friend_menuItem);

        remove_friend_menuItem.setText("Remove Friend");
        remove_friend_menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_friend_menuItemActionPerformed(evt);
            }
        });
        Friends_Menu.add(remove_friend_menuItem);

        block_Friend_MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientGUI/Images/blocked offline.png"))); // NOI18N
        block_Friend_MenuItem.setText("Block Friend");
        block_Friend_MenuItem.setToolTipText("");
        block_Friend_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                block_Friend_MenuItemActionPerformed(evt);
            }
        });
        Friends_Menu.add(block_Friend_MenuItem);

        send_Mail_MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientGUI/Images/22.png"))); // NOI18N
        send_Mail_MenuItem.setText("Send Mail");
        send_Mail_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_Mail_MenuItemActionPerformed(evt);
            }
        });
        Friends_Menu.add(send_Mail_MenuItem);

        jMenuBar1.add(Friends_Menu);

        settings_Menu.setText("Options");

        Create_Chat_Group_menuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientGUI/Images/27.png"))); // NOI18N
        Create_Chat_Group_menuItem.setText("Create Chat Group");
        Create_Chat_Group_menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Create_Chat_Group_menuItemActionPerformed(evt);
            }
        });
        settings_Menu.add(Create_Chat_Group_menuItem);

        my_availability_menuItem.setText("my availability");
        my_availability_menuItem.setToolTipText("");

        available_MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientGUI/Images/13.png"))); // NOI18N
        available_MenuItem.setText("available");
        available_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                available_MenuItemActionPerformed(evt);
            }
        });
        my_availability_menuItem.add(available_MenuItem);

        busy_MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientGUI/Images/15.png"))); // NOI18N
        busy_MenuItem.setText("busy");
        busy_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busy_MenuItemActionPerformed(evt);
            }
        });
        my_availability_menuItem.add(busy_MenuItem);

        invisible_MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientGUI/Images/14.png"))); // NOI18N
        invisible_MenuItem.setText("invisible");
        invisible_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invisible_MenuItemActionPerformed(evt);
            }
        });
        my_availability_menuItem.add(invisible_MenuItem);

        settings_Menu.add(my_availability_menuItem);

        jMenuBar1.add(settings_Menu);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTree1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTree1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
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

    private void add_friend_menuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_friend_menuItemActionPerformed
        AddFriendFram addFriend = new AddFriendFram(c);//my email
        addFriend.setVisible(true);
    }//GEN-LAST:event_add_friend_menuItemActionPerformed

    private void remove_friend_menuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_friend_menuItemActionPerformed
        RemoveFriendFrame removeFriend = new RemoveFriendFrame(c);
        removeFriend.setVisible(true);
    }//GEN-LAST:event_remove_friend_menuItemActionPerformed

    private void block_Friend_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_block_Friend_MenuItemActionPerformed
        RemoveFriendFrame removeFriend = new RemoveFriendFrame(c);
        removeFriend.setVisible(true);
    }//GEN-LAST:event_block_Friend_MenuItemActionPerformed

    private void send_Mail_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_Mail_MenuItemActionPerformed
        SendMailFrame sendMail = new SendMailFrame();
        sendMail.setVisible(true);
    }//GEN-LAST:event_send_Mail_MenuItemActionPerformed

    private void block_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_block_ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_block_ButtonActionPerformed

    private void add_friend_ButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_friend_ButtomActionPerformed
        AddFriendFram addFriend = new AddFriendFram(c);//my email
        addFriend.setVisible(true);

    }//GEN-LAST:event_add_friend_ButtomActionPerformed

    private void new_chat_group_ButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_chat_group_ButtomActionPerformed
//        new ChatForm().setVisible(true);
    }//GEN-LAST:event_new_chat_group_ButtomActionPerformed

    private void available_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_available_MenuItemActionPerformed
        c.setStatus(1);
        controller.changeStatus(c);
//        jTree1.getSelectionPath()
    }//GEN-LAST:event_available_MenuItemActionPerformed

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        System.out.println(evt.getNewLeadSelectionPath());
        Client selectNode = getSelectNode();
        if (selectNode != null) {
            System.out.println(selectNode.getClientId() + " : " + selectNode.getEmail());
        }
    }//GEN-LAST:event_jTree1ValueChanged

    private void jTree1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MousePressed
        if (evt.getClickCount() == 2) {
            Client selectNode = getSelectNode();
            if (selectNode != null) {
                ChatGroup chatGroup = new ChatGroup();
                chatGroup.setClientList(new ArrayList<>());
                chatGroup.getClientList().add(c);
                chatGroup.getClientList().add(selectNode);
                chatGroup.setuAdmin(c);
                System.out.println(selectNode.getClientId() + " : " + selectNode.getEmail());
                controller.startChat(chatGroup);

            }

        }
    }//GEN-LAST:event_jTree1MousePressed

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
//                new clientmainview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Create_Chat_Group_menuItem;
    private javax.swing.JMenu Friends_Menu;
    private javax.swing.JMenuItem Log_Out_MenuItem;
    private javax.swing.JButton add_friend_Buttom;
    private javax.swing.JMenuItem add_friend_menuItem;
    private javax.swing.JMenuItem available_MenuItem;
    private javax.swing.JToggleButton block_Button;
    private javax.swing.JMenuItem block_Friend_MenuItem;
    private javax.swing.JMenuItem busy_MenuItem;
    private javax.swing.JMenuItem invisible_MenuItem;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JMenu logout_Menu;
    private javax.swing.JMenu my_availability_menuItem;
    private javax.swing.JComboBox<String> my_avilabilty_ComboBox;
    private javax.swing.JButton new_chat_group_Buttom;
    private javax.swing.JMenuItem remove_friend_menuItem;
    private javax.swing.JMenuItem send_Mail_MenuItem;
    private javax.swing.JMenu settings_Menu;
    // End of variables declaration//GEN-END:variables

    public DefaultMutableTreeNode processHierarchy() {
        DefaultMutableTreeNode frindList = new DefaultMutableTreeNode("freinds list");
        DefaultMutableTreeNode cat, frnds;

        List<Category> categorys = this.c.getCategoryList();
        for (Category category : categorys) {
            cat = new DefaultMutableTreeNode(category.getCatName());
            frindList.add(cat);
            treeMap.put(cat, category);

            List<Client> clientList = category.getClientList();
            if (clientList.isEmpty()) {
                frnds = new DefaultMutableTreeNode();
                treeMap.put(frnds, "");

            } else {
                for (Client client : clientList) {
                    frnds = new DefaultMutableTreeNode(client.getDisplayName());
                    cat.add(frnds);
                    treeMap.put(frnds, client);

                }
            }
        }

        return (frindList);
    }

    Client getSelectNode() {
        Object lastSelectedPathComponent = jTree1.getLastSelectedPathComponent();
        Object selectedNode = treeMap.get(lastSelectedPathComponent);
        if (selectedNode instanceof Client) {
            return (Client) selectedNode;
        }
        return null;
    }
}
