/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.client.connections;

import framepackage.StartFrame;
import iti.chat.client.Services.ClientImpOperation;
import iti.chat.entites.Category;
import iti.chat.entites.Client;
import iti.chat.faces.ClientFace;
import iti.chat.faces.UserFace;
import static iti.chat.faces.UserFace.serviceName;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdalla
 */
public class ConnctionHndlr {

    Registry registry;
    UserFace user;
    ClientFace client;
    StartFrame startfram;

    public ConnctionHndlr() {
        try {
            client = new ClientImpOperation();
            registry = LocateRegistry.getRegistry(StartFrame.serverIP,StartFrame.serverPort);
            user = (UserFace) registry.lookup(UserFace.serviceName);

        } catch (RemoteException | NotBoundException ex) {
            ex.printStackTrace();
        }

    }

    public int singup(Client client) {
        int check=0;
        try {
            check = user.signup(client);
            if (check == 1) {
                System.out.println("done");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return check;

    }
    
    public int singin(Client client) {
        int check=0;
        try {
            check = user.signin(client);
            if (check == 1) {
                System.out.println("done");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return check;

    }
     public int loadCategory() {
        int check=0;
        try {
            ArrayList<Category> Category=new ArrayList<>();
            Category = user.loadCategory();
            if (Category !=null) {
                JOptionPane.showMessageDialog(null, "cattegory loadeed");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return check;

    }  
    

}
