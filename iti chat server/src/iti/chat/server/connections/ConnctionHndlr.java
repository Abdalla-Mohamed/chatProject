/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.server.connections;

import iti.chat.entites.ChatGroup;
import iti.chat.entites.Client;
import iti.chat.faces.ClientFace;
import iti.chat.faces.UserFace;
import static iti.chat.faces.UserFace.serviceName;
import iti.chat.server.dao.DaoChatGroub;
import iti.chat.server.dao.services.UserServices;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Abdalla
 */
public class ConnctionHndlr {

    Registry registry;
    public static final int SERVER_PORT = 5005;
    private static ConnctionHndlr sharedHndlr;

    HashMap<Integer, ClientFace> userList;
    HashMap<Integer, ChatGroup> onlineChat;

    private ConnctionHndlr() {

        userList = new HashMap<Integer, ClientFace>();
        onlineChat = new HashMap<Integer, ChatGroup>();
//  UnicastRemoteObject.unexportObject(serviceName, true);
    }

    public static ConnctionHndlr getHandeler() {
        if (sharedHndlr == null) {
            return new ConnctionHndlr();
        } else {
            return sharedHndlr;
        }
    }

    public void openService(String hostIp) {
        try {
            System.setProperty("java.rmi.server.hostname", hostIp);
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
            UnicastRemoteObject.unexportObject(registry, true);

        } catch (RemoteException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void register(Client client, ClientFace c) throws RemoteException {
        userList.put(client.getClientId(), c);
        System.out.println("client add");
        //  c.recieve("registred");
    }

    public void logout(ClientFace c) throws RemoteException {
        userList.remove(c);
        System.out.println("client remove");
    }

    public void startChat(ChatGroup chatGroup) throws RemoteException {
        chatGroup.setCgId(0);
        new DaoChatGroub().insert(chatGroup);
        chatGroup.setCgId(null);
        ChatGroup newChatGroup = new DaoChatGroub().selectAllBy(chatGroup).get(0);
        onlineChat.put(newChatGroup.getCgId(), newChatGroup);

        newChatGroup.setClientList(chatGroup.getClientList());
        List<Client> clients = newChatGroup.getClientList();

        for (Client client : clients) {
            ClientFace get = userList.get(client.getClientId());
            if (get != null) {
                get.openChatFram(newChatGroup);
            }
        }

    }

    public void sendMessage(String msg, int chatid, Client sender) throws RemoteException {
        ChatGroup get = onlineChat.get(chatid);
        List<Client> clientList = get.getClientList();
        for (Client client : clientList) {
            userList.get(client.getClientId()).recieveMessage(msg, chatid, sender);
            System.out.println("server send to " + client.getClientId());
        }

    }

    public void changeStatus(Integer clientID, Integer status) throws RemoteException {

        Collection<ClientFace> values = userList.values();
        for (ClientFace clientFace : values) {
            clientFace.updateFrndStates(clientID, status);
        }

    }
    
    public void sendAnnoncement(String annc,ImageIcon icon){
        Collection<ClientFace> clientFaces = userList.values();
        for (ClientFace clientFace : clientFaces) {
            try {
                clientFace.recieveAnnoucement(annc, icon);
            } catch (RemoteException ex) {
                Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    public void requstAddFreind(Client owner,Client fried){
        try {
            userList.get(fried.getClientId()).reciveFrndRqust(owner, fried);
        } catch (RemoteException ex) {
            Logger.getLogger(ConnctionHndlr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
