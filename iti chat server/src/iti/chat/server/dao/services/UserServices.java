/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.server.dao.services;

import iti.chat.entites.Category;
import iti.chat.entites.ChatGroup;
import iti.chat.entites.Client;
import iti.chat.entites.FriendList;
import iti.chat.faces.UserFace;
import iti.chat.server.dao.DaoUser;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;
import iti.chat.faces.ClientFace;
import iti.chat.server.dao.DaoChatGroub;
import iti.chat.server.dao.DaoFriendList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.text.Style;

/**
 *
 * @author Abdalla
 */
public class UserServices extends UnicastRemoteObject implements UserFace {

    HashMap<Integer, ClientFace> userList;
    HashMap<Integer, ChatGroup> onlineChat;
    DaoUser daoUser;
    boolean check;

    public UserServices() throws RemoteException {
        userList = new HashMap<Integer, ClientFace>();
        onlineChat = new HashMap<Integer, ChatGroup>();
        daoUser = new DaoUser();
    }

    @Override
    public boolean checkMail(String mail) throws RemoteException {

        return daoUser.checkMailDoa(mail);
    }

    @Override
    public boolean checkpass(String pass) throws RemoteException {
        return daoUser.checkPassDoa(pass);

    }

    @Override
    public boolean checkUserName(String userName) throws RemoteException {
        return daoUser.checkUserNameDoa(userName);
    }

    @Override
    public boolean signup(Client newuser) throws RemoteException {
        check = false;
        if (checkMail(newuser.getEmail()) == false && checkUserName(newuser.getUserName()) == false) {
            newuser.setClientId(0);
            boolean insert = daoUser.insert(newuser);
            if (insert) {
                check = true;
            }
        }
        return check;
    }

    @Override
    public boolean login(Client user) throws RemoteException {
        check = false;
        if (daoUser.check(user)) {
            check = true;
        }
        return check;
    }

    @Override
    public Client getMe(Client loginUser) throws RemoteException {
        Client loginedClient = daoUser.selectAllBy(loginUser).get(0);
        ArrayList<Category> clientFrindList = daoUser.getClientFrindList(loginedClient);
        loginedClient.setCategoryList(clientFrindList);

        return loginedClient;
    }

    @Override
    public boolean resetPass(Client userForget) throws RemoteException {
        return daoUser.update(userForget);
    }

    @Override
    public void register(Client client, ClientFace c) throws RemoteException {
        userList.put(client.getClientId(), c);
        System.out.println("client add");
        //  c.recieve("registred");
    }

    @Override
    public void logout(ClientFace c) throws RemoteException {
        userList.remove(c);
        System.out.println("client remove");
    }

    @Override
    public boolean changeStatus(Client c) throws RemoteException {
        return daoUser.update(c);
    }

//
//    @Override
//    public void sendFile() throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    @Override
//    public String loadContactList() throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public ArrayList loadFriendsAddRequests() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean acceptFriendRequest(Client owner, Client frnd) throws RemoteException {
        return new DaoFriendList().update(new FriendList(owner, frnd, new Category(1)));
    }

    @Override
    public boolean addFriend(Client owner, Client frnd) throws RemoteException {
        return new DaoFriendList().insert(new FriendList(new Client(owner.getClientId()), new Client(frnd.getClientId()), new Category(3)));

    }

    @Override
    public boolean blockFriend(Client owner, Client frnd) throws RemoteException {
        return new DaoFriendList().update(new FriendList(owner, frnd, new Category(1)));

    }

    @Override
    public boolean removeFriend(Client owner, Client frnd) throws RemoteException {
        return new DaoFriendList().delete(new FriendList(owner, frnd));
    }

    @Override
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

    @Override
    public void sendMessage(String msg, int chatid, Client sender) throws RemoteException {
        ChatGroup get = onlineChat.get(chatid);
        List<Client> clientList = get.getClientList();
        for (Client client : clientList) {
            userList.get(client.getClientId()).recieveMessage(msg,chatid, sender);
            System.out.println("server send to "+client.getClientId());
        }

    }

}
