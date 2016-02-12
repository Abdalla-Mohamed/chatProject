/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framepackage;

import com.healthmarketscience.rmiio.RemoteInputStreamServer;
import com.healthmarketscience.rmiio.SimpleRemoteInputStream;
import iti.chat.client.connections.ConnctionHndlr;
import iti.chat.entites.ChatGroup;
import iti.chat.entites.Client;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author 7amouda
 */
public class ChatForm extends javax.swing.JFrame implements Serializable{

    private String friendEmail = "";
    private String myEmail;
//    private ClientConnection client;
    private ArrayList<String> emails;
    private boolean Conference;
    private String friendEmail_;
    private String otherSideSession;
    private Thread send;
    ArrayList<String> msglist;
    //   MssageSaver msgsave;
    String line;
    String path;
    static String color = "red";
    static int txtSize = 12;
    String face;
    StyleContext sc;
    Color msgColor = Color.red;
    DefaultStyledDocument doc;
    DefaultStyledDocument msgDoc;
    Style txtChatStyle;
    ArrayList<String> filelines;
    ConnctionHndlr controller;
    ChatGroup chGroup;
    
    public ChatForm(ChatGroup chatGroup) {
        super("Chat Form");
        initComponents();
        chGroup=chatGroup;
        controller =new ConnctionHndlr();

        String[] fontsList = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String font : fontsList) {
            comboBoxTxtFont.addItem(font);
        }
        for (int i = 12; i < 80; i += 2) {
            comboBoxTxtSize.addItem(i);
        }
        msglist = new ArrayList<>();
//        msgsave = new MssageSaver();
//
//        friendEmail_ = friendEmail;
//
//        String[] friends = friendEmail.split("%##%");
//        this.myEmail = Messenger.myEmail;
//        for (String friendE : friends) {
//            if (!friendE.equals(this.myEmail)) {
//                this.friendEmail += friendE;
//                this.friendEmail += "%##%";
//            }
//        }
//
//        this.friendEmail = this.friendEmail.substring(0, this.friendEmail.length() - 4);
//        this.client = client;
//
//        this.emails = Messenger.emails;
//
//        String[] currentChatingFriends = this.friendEmail.split("%##%");
//        DefaultListModel listModel = new DefaultListModel();
//        for (String chatFriend : currentChatingFriends) {
//            listModel.addElement(chatFriend);
//
//        }
//        listChatWithFriends.setModel(listModel);
//
//        if (emails != null) {
//            for (String mail : emails) {
//                for (String chatFriend : currentChatingFriends) {
//
//                    if (!(mail.equals(chatFriend))) {
//                        comboBoxFriends.addItem(mail);
//                    }
//                }
//            }
//        }
//        if (currentChatingFriends.length == 1) {
//            //Conference = false;
//            otherSideSession = this.myEmail;
//        } else {
//            // Conference = true;
//            otherSideSession = friendEmail;
//        }
        sc = new StyleContext();
        doc = new DefaultStyledDocument(sc);
        txtChatArea.setDocument(doc);
        face = "Tahoma";
        txtSize = Integer.parseInt(comboBoxTxtSize.getSelectedItem().toString());
        msgColor = Color.red;
//
//        this.client.registerAppendingArea(txtChatArea, listChatWithFriends, comboBoxFriends, friendEmail_, otherSideSession, this.friendEmail);
//        Conference = this.client.getConfFlag(friendEmail_);
//
        txtsend.setFont(new Font(face, Font.PLAIN, txtSize));
        txtsend.setForeground(msgColor);

    }

    public void setFriendEmail(String friendEmail) {
        //   this.friendEmail = friendEmail;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtChatArea = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtsend = new javax.swing.JTextArea();
        btnSendMsg = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listChatWithFriends = new javax.swing.JList();
        btnAddFriend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comboBoxFriends = new javax.swing.JComboBox();
        btnAttachFile = new javax.swing.JButton();
        comboBoxTxtFont = new javax.swing.JComboBox();
        btnTxtColor = new javax.swing.JButton();
        btnSaveChat = new javax.swing.JButton();
        comboBoxTxtSize = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemSaveChat = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuItemExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtChatArea.setEditable(false);
        jScrollPane1.setViewportView(txtChatArea);

        txtsend.setColumns(20);
        txtsend.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtsend.setRows(5);
        txtsend.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(txtsend);

        btnSendMsg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSendMsg.setForeground(new java.awt.Color(0, 51, 51));
        btnSendMsg.setText("Send");
        btnSendMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMsgActionPerformed(evt);
            }
        });

        listChatWithFriends.setEnabled(false);
        listChatWithFriends.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                listChatWithFriendsComponentShown(evt);
            }
        });
        listChatWithFriends.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                listChatWithFriendsComponentAdded(evt);
            }
        });
        listChatWithFriends.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                listChatWithFriendsAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                listChatWithFriendsAncestorRemoved(evt);
            }
        });
        jScrollPane3.setViewportView(listChatWithFriends);

        btnAddFriend.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAddFriend.setText("Add");
        btnAddFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFriendActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Chatting with");

        comboBoxFriends.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Add Friends to Chat" }));

        btnAttachFile.setText("Attach File");
        btnAttachFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttachFileActionPerformed(evt);
            }
        });

        comboBoxTxtFont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Font" }));
        comboBoxTxtFont.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxTxtFontItemStateChanged(evt);
            }
        });

        btnTxtColor.setIcon(new javax.swing.ImageIcon("Images/red.png"));
        btnTxtColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTxtColorActionPerformed(evt);
            }
        });

        btnSaveChat.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        btnSaveChat.setText("Save Chat");
        btnSaveChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChatActionPerformed(evt);
            }
        });

        comboBoxTxtSize.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "12" }));
        comboBoxTxtSize.setToolTipText("Font Size");
        comboBoxTxtSize.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxTxtSizeItemStateChanged(evt);
            }
        });

        jMenu1.setText("File");

        menuItemSaveChat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuItemSaveChat.setText("Save Chat Session");
        menuItemSaveChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSaveChatActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemSaveChat);
        jMenu1.add(jSeparator1);

        menuItemExit.setText("Exit");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemExit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSaveChat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxTxtFont, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(comboBoxTxtSize, 0, 58, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTxtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(comboBoxFriends, 0, 122, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAddFriend, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAttachFile, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSendMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(comboBoxFriends, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddFriend)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAttachFile))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTxtColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboBoxTxtFont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSaveChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboBoxTxtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSendMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMsgActionPerformed

//        friendEmail_ = client.getNewSessionName(txtChatArea);
//        friendEmail = client.getSessiontFriendEMail(friendEmail_);
//        otherSideSession = client.getOtherSideSession(friendEmail_);
//        Conference = client.getConfFlag(friendEmail_);
        String msg = txtsend.getText().trim();
//        Style chatStyle = sc.addStyle("chat", null);
//        chatStyle.addAttribute(StyleConstants.FontSize, txtSize);
//        chatStyle.addAttribute(StyleConstants.FontFamily, face);
//        chatStyle.addAttribute(StyleConstants.Foreground, msgColor);
//        doc.setParagraphAttributes(doc.getEndPosition().getOffset(), msg.length(), , false);
        if (!(msg.equals(""))) {
//                doc.insertString(doc.getEndPosition().getOffset(), myEmail + "(" + Calendar.getInstance().getTime().toString() + "): " + msg + "\n", chatStyle);
//                client.addLineStyle(chatStyle, friendEmail_);
//                client.sendMsg(friendEmail.trim(), this.myEmail, otherSideSession, msg, chatStyle);
                controller.sendMessage(msg, chGroup.getCgId(),ConnctionHndlr.me  );
                txtsend.setText("");
//
        }
    }//GEN-LAST:event_btnSendMsgActionPerformed

    private void btnAddFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFriendActionPerformed
        // TODO add your handling code here:

//        String friendSelected = comboBoxFriends.getSelectedItem().toString();
//        if (friendSelected.equals(comboBoxFriends.getItemAt(0))) {
//            JOptionPane.showMessageDialog(rootPane, "Please select a friend to add to conference !! ");
//        } else {
//            comboBoxFriends.removeItem(friendSelected);
//            DefaultListModel model = (DefaultListModel) listChatWithFriends.getModel();
//
//
//            String oldOtherSideSession=otherSideSession;
//            friendEmail_ = client.getNewSessionName(txtChatArea);
//            friendEmail = client.getSessiontFriendEMail(friendEmail_);
//            otherSideSession = client.getOtherSideSession(friendEmail_);
//            Conference = client.getConfFlag(friendEmail_);
//            String newMySession;
//            String newOtherSideSession = "";
//            String newFriendEmail;
//            if (Conference == false) {
//                if (!this.client.sessionFound(myEmail + "%##%" + friendEmail_ + "%##%" + friendSelected)) {
//                    model.addElement(friendSelected);
//                    listChatWithFriends.setModel(model);
//                    if (comboBoxFriends.getSelectedIndex() != 0) {
//                        JOptionPane.showMessageDialog(rootPane, friendSelected);
//                    }
//                    newMySession = myEmail + "%##%" + friendEmail_ + "%##%" + friendSelected;
//                    newOtherSideSession = newMySession;
//                    newFriendEmail = friendEmail + "%##%" + friendSelected;
//                    client.modifyAppedingArea(friendEmail_, newMySession);
//                } else {
//                    JOptionPane.showMessageDialog(null, "You already has a session with them !! ");
//                }
//            } else {
//                if (!this.client.sessionFound(friendEmail_ + "%##%" + friendSelected)) {
//                    model.addElement(friendSelected);
//                    listChatWithFriends.setModel(model);
//                    if (comboBoxFriends.getSelectedIndex() != 0) {
//                        JOptionPane.showMessageDialog(rootPane, friendSelected);
//                    }
//                    newMySession = friendEmail_ + "%##%" + friendSelected;
//                    newOtherSideSession = newMySession;
//                    newFriendEmail = friendEmail + "%##%" + friendSelected;
//                    client.modifyAppedingArea(friendEmail_, newMySession);
//                } else {
//                    JOptionPane.showMessageDialog(null, "You already has a session with them !! ");
//                }
//            }
//            client.updateCoresspondingTextAreas(friendEmail, otherSideSession, newOtherSideSession);
//        }
    }//GEN-LAST:event_btnAddFriendActionPerformed

    private void listChatWithFriendsAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_listChatWithFriendsAncestorAdded
        // TODO add your handling code here:

//        DefaultListModel listModel = (DefaultListModel) listChatWithFriends.getModel();
//        friendEmail = "";
//        for (int i = 0; i < listModel.size(); i++) {
//            friendEmail += listModel.get(i);
//            friendEmail += "%##%";
//        }
//        friendEmail = friendEmail.substring(0, friendEmail.length() - 4);

    }//GEN-LAST:event_listChatWithFriendsAncestorAdded

    private void listChatWithFriendsAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_listChatWithFriendsAncestorRemoved
        // TODO add your handling code here:

//        DefaultListModel listModel = (DefaultListModel) listChatWithFriends.getModel();
//        friendEmail = "";
//        for (int i = 0; i < listModel.size(); i++) {
//            friendEmail += listModel.get(i);
//            friendEmail += "%##%";
//        }
//        friendEmail = friendEmail.substring(0, friendEmail.length() - 4);
    }//GEN-LAST:event_listChatWithFriendsAncestorRemoved

    private void listChatWithFriendsComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_listChatWithFriendsComponentShown
        // TODO add your handling code here:

//        DefaultListModel listModel = (DefaultListModel) listChatWithFriends.getModel();
//        friendEmail = "";
//        for (int i = 0; i < listModel.size(); i++) {
//            friendEmail += listModel.get(i);
//            friendEmail += "%##%";
//        }
//        friendEmail = friendEmail.substring(0, friendEmail.length() - 4);
    }//GEN-LAST:event_listChatWithFriendsComponentShown

    private void listChatWithFriendsComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_listChatWithFriendsComponentAdded
        // TODO add your handling code here:

//        DefaultListModel listModel = (DefaultListModel) listChatWithFriends.getModel();
//        friendEmail = "";
//        for (int i = 0; i < listModel.size(); i++) {
//            friendEmail += listModel.get(i);
//            friendEmail += "%##%";
//        }
//        friendEmail = friendEmail.substring(0, friendEmail.length() - 4);
    }//GEN-LAST:event_listChatWithFriendsComponentAdded

    private void btnAttachFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttachFileActionPerformed
        // TODO add your handling code here:
//        friendEmail_ = client.getNewSessionName(txtChatArea);
//        friendEmail = client.getSessiontFriendEMail(friendEmail_);
//        otherSideSession = client.getOtherSideSession(friendEmail_);
//        Conference = client.getConfFlag(friendEmail_);
//        JFileChooser fc = new JFileChooser();
//        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//            try {
//                File file = fc.getSelectedFile();
//                RemoteInputStreamServer stream = new SimpleRemoteInputStream(new FileInputStream(file));
//                client.sendFile(friendEmail, otherSideSession, stream.export(), file.getName());
//            } catch (RemoteException ex) {
//                JOptionPane.showMessageDialog(this, "Can't Attach File !!", "File Sending Error!!", JOptionPane.ERROR_MESSAGE, null);
//            } catch (FileNotFoundException ex) {
//                JOptionPane.showMessageDialog(this, "Can't Attach File !!", "File Sending Error!!", JOptionPane.ERROR_MESSAGE, null);
//            }
//
//
//        }
    }//GEN-LAST:event_btnAttachFileActionPerformed

    private void btnSaveChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChatActionPerformed
        // TODO add your handling code here:
//        msglist.clear();
//         msgsave = new MssageSaver();
//          
//        LinkedList<Style> sessionStyle = client.getLineStyle(friendEmail_);
//        if (!txtChatArea.getText().isEmpty()) {
//            String Chat = txtChatArea.getText();
//            FileNameExtensionFilter _fileFilter = new FileNameExtensionFilter("XML Files (*.xml)", "xml");
//            JFileChooser fc = new JFileChooser();
//            fc.setFileFilter(_fileFilter);
//            if ((fc.showSaveDialog(this)) == JFileChooser.APPROVE_OPTION) {
//                path = fc.getSelectedFile().getPath() + ".xml";
//            }
//            StringTokenizer chatlines = new StringTokenizer(Chat,"\n");
//            while (chatlines.hasMoreTokens()) {
//              String temp=chatlines.nextToken();
//                if(temp.endsWith("\n"))
//                {
//                    temp=temp.substring(0, temp.length()-1);
//                }
//               
//                msglist.add(temp);
//                
//            }
//            msglist.remove(0);
//            
//             System.err.println(msglist.get(0));
//
//            for (int i = 0; i < msglist.size(); i++) {
//                
//               
//
//                savetoXML(msglist.get(i), sessionStyle.get(i), path);
//                
//            }
//
//            this.writeToFile();
//        }
//       
    }//GEN-LAST:event_btnSaveChatActionPerformed

//    public void savetoXML(String msgline, Style chatStyle, String path) {
//        
//        int size = Integer.parseInt(chatStyle.getAttribute(StyleConstants.FontSize).toString());
//        String fontFamilyName = chatStyle.getAttribute(StyleConstants.FontFamily).toString();
//        String colorTemp = Integer.toHexString(((Color) chatStyle.getAttribute(StyleConstants.Foreground)).getRGB());
//        String color = colorTemp.substring(2, colorTemp.length());
//
//
//        msgsave.saveXML(msgline, path, size, color, fontFamilyName);
//    }
//    public void writeToFile() {
//
//        try {
//            filelines = new ArrayList<String>();
//            Scanner sc = new Scanner(new File(path));
//            line = sc.nextLine();
//
//            while (sc.hasNext()) {
//                filelines.add(line);
//                line = sc.nextLine();
//
//            }//end of while
//            //add the close of </session>
//            filelines.add(line);
//            String xslpath = "<?xml-stylesheet type=" + '"' + "text/xsl" + '"' + " href=" + '"' + "C:\\" + "\\" + "Message.xsl" + '"' + "?> ";
//            /**
//             * add ref to xsl at 2nd line of xml file by add it firstly to the
//             * filelines array list
//             */
//            filelines.add(1, xslpath);
//            
//
//
//            /**
//             * write anew file with xslt path
//             */
//            PrintWriter bw = new PrintWriter(path);
//            bw.write("");
//            for (int r = 0; r < filelines.size(); r++) {
//                bw.append(filelines.get(r));
//                bw.append("\n");
//
//            }
//            bw.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public class myFileFilter extends FileFilter {
//
//        @Override
//        public String getDescription() {
//            return "Save Chat AS 'XML'";
//
//        }
//
//        @Override
//        public boolean accept(File f) {
//
//            if ((f.getName().toLowerCase().endsWith(".xml")) || (f.isDirectory())) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//    }
//    public class myFileView extends FileView {
//
//        @Override
//        public Icon getIcon(File f) {
//            if (f.isDirectory()) {
//                Image img = Toolkit.getDefaultToolkit().getImage("src/chsave/index.jpg").getScaledInstance(25, 25, Image.SCALE_SMOOTH);
//                ImageIcon myIcon = new ImageIcon(img);
//                return myIcon;
//            } else if (f.getName().toLowerCase().endsWith(".xml")) {
//                Image img = Toolkit.getDefaultToolkit().getImage("src/chsave/xmlicon.jpg").getScaledInstance(25, 25, Image.SCALE_SMOOTH);
//                ImageIcon gificon = new ImageIcon(img);
//                return gificon;
//            } else {
//                return null;
//            }
//        }
//    }

    private void btnTxtColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTxtColorActionPerformed
        // TODO add your handling code here:
        Color color = Color.black;
        msgColor = JColorChooser.showDialog(rootPane, "Select Color.", color);
        btnTxtColor.setBackground(msgColor);
        txtsend.setFont(new Font(face, Font.PLAIN, txtSize));
        txtsend.setForeground(msgColor);

    }//GEN-LAST:event_btnTxtColorActionPerformed

    private void menuItemSaveChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSaveChatActionPerformed
        // TODO add your handling code here:
        btnSaveChat.doClick();
    }//GEN-LAST:event_menuItemSaveChatActionPerformed

    private void comboBoxTxtFontItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxTxtFontItemStateChanged
        // TODO add your handling code here:
        face = comboBoxTxtFont.getSelectedItem().toString();
        txtsend.setFont(new Font(face, Font.PLAIN, txtSize));
        txtsend.setForeground(msgColor);
    }//GEN-LAST:event_comboBoxTxtFontItemStateChanged

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
//        friendEmail_ = client.getNewSessionName(txtChatArea);
//        client.unregisterAppendingArea(friendEmail_);
    }//GEN-LAST:event_formWindowClosing

    private void comboBoxTxtSizeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxTxtSizeItemStateChanged
        // TODO add your handling code here:
        txtSize = Integer.parseInt(comboBoxTxtSize.getSelectedItem().toString());
        txtsend.setFont(new Font(face, Font.PLAIN, txtSize));
        txtsend.setForeground(msgColor);
    }//GEN-LAST:event_comboBoxTxtSizeItemStateChanged
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ChatForm().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFriend;
    private javax.swing.JButton btnAttachFile;
    private javax.swing.JButton btnSaveChat;
    private javax.swing.JButton btnSendMsg;
    private javax.swing.JButton btnTxtColor;
    private javax.swing.JComboBox comboBoxFriends;
    private javax.swing.JComboBox comboBoxTxtFont;
    private javax.swing.JComboBox comboBoxTxtSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JList listChatWithFriends;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemSaveChat;
    private javax.swing.JTextPane txtChatArea;
    private javax.swing.JTextArea txtsend;
    // End of variables declaration//GEN-END:variables

    public void displayMessage(String msg, Client client) {
        // msg = txtsend.getText().trim();
        //     Style chatStyle = sc.addStyle("chat", null);
        //     chatStyle.addAttribute(StyleConstants.FontSize, txtSize);
        //     chatStyle.addAttribute(StyleConstants.FontFamily, face);
        //     chatStyle.addAttribute(StyleConstants.Foreground, msgColor);
//        doc.setParagraphAttributes(doc.getEndPosition().getOffset(), msg.length(), false);
        // if (!(msg.equals(""))) {
        //   doc.insertString(doc.getEndPosition().getOffset(), client.getEmail() + "(" + Calendar.getInstance().getTime().toString() + "): " + msg + "\n");
//                client.addLineStyle(chatStyle, friendEmail_);
//                client.sendMsg(friendEmail.trim(), this.myEmail, otherSideSession, msg, chatStyle);
//                JOptionPane.showMessageDialog(null, msg+" from "+client.getDisplayName());
        String text = txtChatArea.getText();
        
                

                txtChatArea.setText(text+"\n"+client.getDisplayName()+": "+msg);
              //  repaint();
//
      //  }
    }
}
