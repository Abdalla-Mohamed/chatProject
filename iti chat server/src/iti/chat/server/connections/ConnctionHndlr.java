/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.server.connections;

import iti.chat.faces.UserFace;
import static iti.chat.faces.UserFace.serviceName;
import iti.chat.server.dao.services.UserServices;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdalla
 */
public class ConnctionHndlr {

    Registry registry;
    public static final int SERVER_PORT = 5005;

    public ConnctionHndlr() {
        //  UnicastRemoteObject.unexportObject(serviceName, true);
    }

    public void openService() {
        try {
            UserFace obj = new UserServices();
            registry = LocateRegistry.createRegistry(SERVER_PORT);
            registry.rebind(UserFace.serviceName, obj);
            System.out.println("start.........");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    public void stopService() {
        try {
            registry.unbind(serviceName);
            UnicastRemoteObject.unexportObject(registry,true);
                    
        } catch (RemoteException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
