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
    
    
    public ClientImpOperation(ConnctionHndlr contro) throws RemoteException {
        toasterManager = new Toaster();
        controller= contro;
        
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
    public void recieveMessage(String msg,int chatId, Client client,Style msgStyle) throws RemoteException {
      //  controller.displayMessage(msg, client);
        controller.recieveMessage(msg, chatId, client,msgStyle);

    }

    @Override
    public void openChatFram(ChatGroup chatGroup) throws RemoteException {
        controller.openChatFram(chatGroup);
    }

    @Override
    public void updateFrndStates(Integer clientID, Integer status) {
        controller.updateFrndStates(clientID, status);
    }

    @Override
    public void reciveFrndRqust(Client owner, Client friend) throws RemoteException {
                controller.reciveFrndRqust(owner, friend);

    }

    @Override
    public void addToChat(Integer cgId, Client client) {
        controller.addToChat( cgId,  client);
    }

    
}
