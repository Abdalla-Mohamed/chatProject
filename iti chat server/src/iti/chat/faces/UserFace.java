/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.faces;

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

    int checkMail(String mail) throws RemoteException;

    int checkpass(String mail, String pass) throws RemoteException;

    int checkUserName(String userName) throws RemoteException;

    int signup(Client newuser) throws RemoteException;

    int signin(Client user) throws RemoteException;

    int resetPass(Client userForget) throws RemoteException;

    void register(ClientFace c) throws RemoteException;

    void unRegister(ClientFace c) throws RemoteException;

    void changeStatus(ClientFace c) throws RemoteException;

    public void sendMessage(String msg, String session, String to, String from, Style msgStyle) throws RemoteException;

    public void sendFile(File file) throws RemoteException;

    public String loadContactList(Client user) throws RemoteException;

    public ArrayList loadFriendsAddRequests() throws RemoteException;

    public void acceptFriendRequest(String myEmail, String friendEmail) throws RemoteException;

    //public boolean addFriend(String myEmail, String friendEmail) throws RemoteException;
    public boolean addFriend(int userID, int friendID) throws RemoteException;

    // public void blockFriend(String myEmail, String frienfEmail) throws RemoteException;
    public void blockFriend(int userID, int friendID) throws RemoteException;

    public ArrayList loadCategory() throws RemoteException;

}
