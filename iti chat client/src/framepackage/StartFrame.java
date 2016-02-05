/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framepackage;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author 7amouda
 */
public class StartFrame extends javax.swing.JFrame {

    public static String serverIP;
    public static int clientPort;

    /**
     * Creates new form StartFrame
     */
    public StartFrame() {
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

        jLabel2 = new javax.swing.JLabel();
        txtIPAddressField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPortNoField = new javax.swing.JTextField();
        btnConnect = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("URL Address :");

        txtIPAddressField.setText("localhost");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Port Number :");

        btnConnect.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnConnect.setText("Connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIPAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnConnect)
                                .addGap(34, 34, 34)
                                .addComponent(btnCancel))
                            .addComponent(txtPortNoField))))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIPAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPortNoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnConnect))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        // TODO add your handling code here:

        String ipAddress = txtIPAddressField.getText().trim();
        String portNo = txtPortNoField.getText().trim();
        if (validateIPAddress(ipAddress) && validatePortNo(portNo)) {
            this.dispose();
            new clientloginframe().setVisible(true);
        }


    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
            // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private boolean validateIPAddress(String ipAddress) {
        String regex = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        boolean validIP = false;
        if (!(ipAddress.equals(""))) {
            if (ipAddress.equalsIgnoreCase("localhost")) {
                serverIP = ipAddress.toLowerCase();
                validIP = true;
            } else if (Pattern.matches(regex, ipAddress)) {
                serverIP = ipAddress;
                validIP = true;
            } else {
                JOptionPane.showMessageDialog(rootPane, "Invalid IP Address !!!", "Invalid URL", JOptionPane.ERROR_MESSAGE);
                validIP = false;
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Please Enter an IP Address !!!", "Invalid URL", JOptionPane.ERROR_MESSAGE);
            validIP = false;
        }
        return validIP;
    }

    private boolean validatePortNo(String portNo) {
        String regex = "(\\d){1,9}";
        boolean validPort = false;
        int port;
        if (!(portNo.equals("2009")) && !(portNo.equals("587"))) {
            if (!(portNo.equals(""))) {
                if (Pattern.matches(regex, portNo)) {
                    port = Integer.parseInt(portNo);
                    clientPort = port;
                    validPort = true;
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Invalid Port Number !!!", "Invalid Port", JOptionPane.ERROR_MESSAGE);
                    validPort = false;
                    
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Pleas Enter a Port Number !!!", "Invalid Port", JOptionPane.ERROR_MESSAGE);
                validPort = false;
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "This Port is Reserved for the Server, Try another Port No.","Invalid Port.",JOptionPane.ERROR_MESSAGE);
        }

        return validPort;
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConnect;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtIPAddressField;
    private javax.swing.JTextField txtPortNoField;
    // End of variables declaration//GEN-END:variables
}
