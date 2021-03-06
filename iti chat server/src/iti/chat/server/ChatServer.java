/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.server;

import com.nitido.utils.toaster.Toaster;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import framepackage.ServerControlFrame;
import iti.chat.server.connections.ConnctionHndlr;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Abdalla
 */
public class ChatServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Toaster toasterManager = new Toaster();

        toasterManager.showToaster("Welcom In Java Chat v1.0");
        try {
            UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());

        } catch (UnsupportedLookAndFeelException ex) {
          //  Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
          //  Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        new ServerControlFrame().setVisible(true);
    }

}
