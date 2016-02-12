/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.client.connections;

import framepackage.ChatForm;
import framepackage.StartFrame;
import iti.chat.client.Services.ClientImpOperation;
import iti.chat.entites.Category;
import iti.chat.entites.ChatGroup;
import iti.chat.entites.Client;
import iti.chat.faces.ClientFace;
import iti.chat.faces.UserFace;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.Style;

/**
 *
 * @author Abdalla
 */
public class ConnctionHndlr {

    Registry registry;
    UserFace user;
    ClientFace client;
    public  static String serverIP;
     public  static int serverPort;

    ChatForm chfram;
   public static Client me;
    public ConnctionHndlr() {
        try {
            client = new ClientImpOperation();
            registry = LocateRegistry.getRegistry(serverIP,serverPort);
//            registry = LocateRegistry.getRegistry(5005);
            user = (UserFace) registry.lookup(UserFace.serviceName);
        } catch (RemoteException | NotBoundException ex) {
            ex.printStackTrace();
        }

    }

    public boolean singup(Client client) {
        boolean check = false;
        try {
            check = user.signup(client);
            if (check == true) {
                System.out.println("done");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;

    }

    public boolean singin(Client client) {
        boolean check = false;
        try {
//            registry = LocateRegistry.getRegistry("127.0.0.1", 5005);
//            user = (UserFace) registry.lookup(UserFace.serviceName);
            check = user.login(client);
            if (check == true) {
                me = user.getMe(client);
                user.register( me, this.client);
                System.out.println("done");
                //      user.register((ClientFace) client);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;

    }

    public void displayMessage(String msg, Client client) {
        chfram.displayMessage(msg, client);
    }

    public boolean addFriend(Client owner, Client frnd) {
        boolean check = false;
        try {
            if (user.checkMail(frnd.getEmail())) {
                Client myFrnd = user.getMe(frnd);
                check = user.addFriend(owner, myFrnd);
            } else {
                JOptionPane.showMessageDialog(null, "Not found");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public boolean removeFriend(Client owner, Client frnd) {
        boolean check = false;
        try {
            if (user.checkMail(frnd.getEmail())) {
                check = user.removeFriend(owner, frnd);
            } else {
                JOptionPane.showMessageDialog(null, "Not found");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public boolean blockFriend(Client owner, Client frnd) {
        boolean check = false;
        try {
            if (user.checkMail(frnd.getEmail())) {
                check = user.blockFriend(owner, frnd);
            } else {
                JOptionPane.showMessageDialog(null, "Not found");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public boolean changeStatus(Client c) {
        boolean check = false;
        try {
            check = user.changeStatus(c);
        } catch (RemoteException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public Client getMe(Client c) {
        Client client = new Client();
        try {
            client = user.getMe(c);
        } catch (RemoteException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return client;
    }
     public void startChat(ChatGroup chat) {
        try {
            user.startChat(chat);
        } catch (RemoteException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void sendMessage(String msg, int chatid, Client sender) {
        try {
            user.sendMessage(msg, chatid, sender);
            System.out.println("msg send");
        } catch (RemoteException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
