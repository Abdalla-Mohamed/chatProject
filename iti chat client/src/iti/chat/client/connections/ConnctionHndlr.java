/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.client.connections;

import iti.chat.client.Services.ClientImpOperation;
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
            user = (UserFace) registry.lookup(serviceName);
            user.register(client);
        } catch (RemoteException | NotBoundException ex) {
            ex.printStackTrace();
        }

    }

}
