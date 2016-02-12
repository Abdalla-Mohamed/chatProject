/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.client.Services;

import com.nitido.utils.toaster.Toaster;
import framepackage.ChatForm;
import iti.chat.client.connections.ConnctionHndlr;
import iti.chat.entites.ChatGroup;
import iti.chat.entites.Client;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import iti.chat.faces.ClientFace;
import java.io.File;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.text.Style;

/**
 *
 * @author Bakar M.M.R
 */
public class ClientImpOperation extends UnicastRemoteObject implements ClientFace {

    ConnctionHndlr controller;
    Toaster toasterManager;
    transient  HashMap<Integer,ChatForm> hashMap;
    public ClientImpOperation() throws RemoteException {
        toasterManager = new Toaster();
        hashMap = new HashMap<>();
    }

    @Override
    public void statusNotify(Client c) throws RemoteException {
        toasterManager.showToaster(c.getUserName());
    }

    @Override
    public void recieveAnnoucement(String text, ImageIcon img) throws RemoteException {
        toasterManager.showToaster(img, text);
    }

    @Override
    public boolean terminateNotify(String msg) throws RemoteException {
        toasterManager.showToaster(msg);
        return true;
    }

    @Override
    public void acceptRequestNtify(Client client) throws RemoteException {
        toasterManager.showToaster(client.getUserName()+" accept your friend request");
    }

    @Override
    public void recieveFile(File file) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void serverIsDown() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recieveMessage(String msg,int chatId, Client client) throws RemoteException {
      //  controller.displayMessage(msg, client);
        System.out.println("reiceved: "+msg);
        hashMap.get(chatId).displayMessage(msg, client);

    }

    @Override
    public void openChatFram(ChatGroup chatGroup) throws RemoteException {
        ChatForm ch=new ChatForm(chatGroup);
        ch.setTitle(""+chatGroup.getCgId());
        hashMap.put(chatGroup.getCgId(), ch);
        ch.setVisible(true);
    }

}
