/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.faces;

import iti.chat.entites.ChatGroup;
import iti.chat.entites.Client;
import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.ImageIcon;
import javax.swing.text.Style;

/**
 *
 * @author Bakar M.M.R
 */
public interface ClientFace extends Remote {

    public void recieveMessage(String msg, int chatId, Client client,Style msgStyle) throws RemoteException;

    void statusNotify(Client c) throws RemoteException;

    void recieveAnnoucement(String text, ImageIcon img) throws RemoteException;

    boolean terminateNotify(String msg) throws RemoteException;

    void acceptRequestNtify(Client client) throws RemoteException;

    void recieveFile(File file) throws RemoteException;

    void serverIsDown() throws RemoteException;

    void openChatFram(ChatGroup chatGroup) throws RemoteException;
//    void refreshContactsList(String email) throws RemoteException;

    public void updateFrndStates(Integer clientID, Integer status) throws RemoteException;

    public void reciveFrndRqust(Client owner, Client friend) throws RemoteException;

    public void addToChat(Integer cgId, Client client);

}
