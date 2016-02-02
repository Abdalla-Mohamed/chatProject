/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.client.connections;

import iti.chat.faces.UserFace;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdalla
 */
public class ConnctionHndlr {

    Registry registry;
    UserFace user;
    public ConnctionHndlr() {

         try {
            
         //   v.setVisible(true);
            registry = LocateRegistry.getRegistry("127.0.0.1", 5005);
            user = (UserFace) registry.lookup("ChatService");
            
        } catch (RemoteException | NotBoundException ex) {
            ex.printStackTrace();
        }

    }

}
