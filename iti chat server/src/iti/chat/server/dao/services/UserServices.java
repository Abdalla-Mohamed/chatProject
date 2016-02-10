/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.server.dao.services;

import iti.chat.entites.Category;
import iti.chat.entites.Client;
import iti.chat.faces.UserFace;
import iti.chat.server.dao.DaoUser;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;
import iti.chat.faces.ClientFace;
import iti.chat.server.dao.DaoCategory;
import java.util.ArrayList;
import javax.swing.text.Style;

/**
 *
 * @author Abdalla
 */
public class UserServices extends UnicastRemoteObject implements UserFace{

    Vector<ClientFace> userList ;
    DaoUser daoUser;
    DaoCategory doaCategory;
    int check;
    
    
    public UserServices() throws RemoteException {
        userList = new Vector<>();
        daoUser =  new DaoUser();
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
        check=0;
         if(checkMail(newuser.getEmail())==0&&checkUserName(newuser.getUserName())==0)
        {
           newuser.setClientId(0);
            boolean insert = daoUser.insert(newuser);
           if(insert)
               check=1;
        }
        return check;
    }

    @Override
    public int signin(Client user) throws RemoteException {
            check=0;
        if(daoUser.check(user))
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
        c.recieve("registred");
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

    @Override
    public String loadContactList(Client user) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList loadCategory() throws RemoteException {
          check=0;
          Category category=new Category();
          doaCategory=new DaoCategory();
          ArrayList<Category> catList=new ArrayList<>();
        catList=doaCategory.selectAllBy(category);
        return catList;
    }
    
}
