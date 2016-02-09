/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.server.dao.services;

import iti.chat.entites.Client;
import iti.chat.faces.UserFace;
import iti.chat.server.dao.DaoUser;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;
import iti.chat.faces.ClientFace;
import java.util.ArrayList;
import javax.swing.text.Style;

/**
 *
 * @author Abdalla
 */
public class UserServices extends UnicastRemoteObject implements UserFace{

    Vector<ClientFace> userList ;
    DaoUser daoUser;
    int check;
    
    public UserServices() throws RemoteException {
    }

    
    
    @Override
    public int checkMail(String mail) throws RemoteException {
       check=daoUser.checkMailDoa(mail);
       return check;
    }

    @Override
    public int checkpass(String mail, String pass) throws RemoteException {
        check=daoUser.checkPassDoa(mail,pass);
       return check;
    }

    @Override
    public int checkUserName(String userName) throws RemoteException {
          check=daoUser.checkUserNameDoa(userName);
       return check;
    }

    @Override
    public int signup(Client newuser) throws RemoteException {
         if(checkMail(newuser.getEmail())==1&&checkUserName(newuser.getUserName())==1)
        {
            check=daoUser.create(newuser);
        }
        return check;
    }

    @Override
    public int signin(Client user) throws RemoteException {
            check=0;
        if(checkMail(user.getEmail())==1&&checkpass(user.getEmail(), user.getPassword())==1)
        {
            check=1;
        }
        return check;
    }

    @Override
    public int resetPass(Client userForget) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  @Override
    public void register(ClientFace c) throws RemoteException {
        userList.add(c);
        System.out.println("client add");
    }

    @Override
    public void unRegister(ClientFace c) throws RemoteException {
        userList.remove(c);
        System.out.println("client remove");
    }

    @Override
    public void changeStatus(ClientFace c) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendMessage(String msg, String session, String to, String from, Style msgStyle) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendFile() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String loadContactList() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList loadFriendsAddRequests() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void acceptFriendRequest(String myEmail, String friendEmail) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addFriend(String myEmail, String friendEmail) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void blockFriend(String myEmail, String frienfEmail) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
