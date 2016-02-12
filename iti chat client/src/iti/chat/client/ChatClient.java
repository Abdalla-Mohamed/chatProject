/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.client;

import com.nitido.utils.toaster.Toaster;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import javax.swing.UIManager;
import framepackage.StartFrame;
import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Abdalla
 */
public class ChatClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
  
            Toaster toasterManager = new Toaster();

            toasterManager.showToaster("Welcom In Java Chat v1.0");
            try {
                UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
                
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new StartFrame().setVisible(true);
                }
            });
        }
    }
    
