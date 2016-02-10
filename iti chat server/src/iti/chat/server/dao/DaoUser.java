/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.server.dao;

import iti.chat.entites.Category;
import iti.chat.entites.Client;
import iti.chat.entites.FriendList;
import java.util.ArrayList;

/**
 *
 * @author Abdalla
 */
public class DaoUser extends GenricDao<Client> {

    String query;

    public DaoUser() {
        super(Client.class);
    }

    public boolean checkMailDoa(String mail) {
        boolean check = false;
        Client c = new Client();
        c.setEmail(mail);
        if (check(c)) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    public boolean checkPassDoa( String pass) {
        Client client = new Client();
        client.setPassword(pass);

        if (check(client)) {
            return true;
        } else {
            return false;
        }

    }

    public Client readImpByEmail(String mail, String pass) {
        Client client = new Client();
        client.setEmail(mail);
        client.setPassword(mail);

        ArrayList<Client> result = selectAllBy(client);
        return result.get(0);
    }


    public boolean checkUserNameDoa(String user_name) {
        boolean check = false;
        Client c = new Client();
        c.setUserName(user_name);
        if (check(c)) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    public ArrayList<Category> getClientFrindList(Client client){
        
        client.getClientId();
        FriendList friendList = new  FriendList(client, null);
        ArrayList<Category> categorys = new DaoCategory().selectAllBy(new Category());
        for (Category category : categorys) {
            category.setClientList(new ArrayList<>());
            friendList = new  FriendList(client, null,category);
            ArrayList<FriendList> friendLists = new DaoFriendList().selectAllBy(friendList);
               for (FriendList friend : friendLists) {
                Client friendObj = selectAllBy(friend.getFriend()).get(0);
                category.getClientList().add(friendObj);
                friend.setFriend(friendObj);
            }
        
        }
       return categorys;
    }
    
    

}
