/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.faces;

import iti.chat.entites.Category;
import iti.chat.entites.ChatGroup;
import iti.chat.entites.Client;
import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.text.Style;

/**
 *
 * @author Abdalla
 */
public interface UserFace extends Remote {

    String serviceName = "userService";

    boolean checkMail(String mail) throws RemoteException;

    boolean checkpass(String pass) throws RemoteException;

    boolean checkUserName(String userName) throws RemoteException;

    boolean signup(Client newuser) throws RemoteException;

    boolean login(Client loginUser) throws RemoteException;

    Client getMe(Client loginUser) throws RemoteException;

    boolean resetPass(Client userForget) throws RemoteException;

    public void changeStatus(Integer clientID, Integer status)throws RemoteException;

//    String loadContactList(Client c)throws RemoteException;
    //--------------------------------------------------------------------------
    ArrayList loadFriendsAddRequests() throws RemoteException;

    boolean acceptFriendRequest(Client owner, Client frnd) throws RemoteException;

    boolean addFriend(Client owner, Client frnd) throws RemoteException;

    boolean blockFriend(Client owner, Client frnd) throws RemoteException;

    boolean removeFriend(Client owner, Client frnd) throws RemoteException;
//    void sendFile()throws RemoteException;

    //--------------------------------------------------------------------------
    void sendMessage(String msg, int chatid, Client sender) throws RemoteException;

    void startChat(ChatGroup chatGroup) throws RemoteException;

//---------------------------------------------------
    void register(Client client, ClientFace c) throws RemoteException;

    void logout(ClientFace c) throws RemoteException;

}
