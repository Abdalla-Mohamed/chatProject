/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.client.connections;

import iti.chat.client.Services.ClientImpOperation;
import iti.chat.entites.Client;
import iti.chat.faces.ClientFace;
import iti.chat.faces.UserFace;
import static iti.chat.faces.UserFace.serviceName;
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
    ClientFace client;

    public ConnctionHndlr() {
        try {
            client = new ClientImpOperation();
            registry = LocateRegistry.getRegistry("127.0.0.1", 5005);
            user = (UserFace) registry.lookup(UserFace.serviceName);
            int checkpass = user.checkpass("a@g.com", " 123");
            if (checkpass == 1) {
                System.out.println("done");
                user.register(client);
            }

        } catch (RemoteException | NotBoundException ex) {
            ex.printStackTrace();
        }

    }

    public int singup(Client client) {
        int check=0;
        try {
            registry = LocateRegistry.getRegistry("127.0.0.1", 5005);
            user = (UserFace) registry.lookup(UserFace.serviceName);
            check = user.signup(client);
            if (check == 1) {
                System.out.println("done");
          //      user.register((ClientFace) client);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;

    }
    
    public int singin(Client client) {
        int check=0;
        try {
            registry = LocateRegistry.getRegistry("127.0.0.1", 5005);
            user = (UserFace) registry.lookup(UserFace.serviceName);
            check = user.signin(client);
            if (check == 1) {
                System.out.println("done");
          //      user.register((ClientFace) client);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;

    }

}
