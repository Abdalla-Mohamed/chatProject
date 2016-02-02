/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.server.connections;

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

    public ConnctionHndlr() {

        try {
            try {
                registry = LocateRegistry.createRegistry(2020);
            } catch (RemoteException ex) {
                registry = LocateRegistry.getRegistry(2020);
            }

            
            // rebind services
            
        } catch (RemoteException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
