/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.server.dao;

import iti.chat.config.Config;
import iti.chat.entites.Category;
import iti.chat.entites.Client;
import iti.chat.entites.FriendList;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Abdalla
 */
public class Main {

    public Main() {
    
                
    }
    
    public static void main(String[] args) {
        
        Client c = new Client();
        c.setEmail("a@g.com");
        c.setClientId(1);
        FriendList list = new FriendList(c, null);
//        FriendList friendList= new FriendList(c, c, new Category(2, "cat"));
        GenricDao<Client> genricDao = new GenricDao<>(Client.class);
        GenricDao<FriendList> genric = new GenricDao<>(FriendList.class);
        ArrayList<FriendList> selectAllBy1 = genric.selectAllBy(list);
        
        for (FriendList selectAllBy11 : selectAllBy1) {
            System.out.println(selectAllBy11.getOwner()+"."+selectAllBy11.getFriend()+"."+selectAllBy11.getCategory());
        }
//        
//        if(genricDao.check(c)){
//            System.out.println("founded");
//        }
//        
                ArrayList<Client> selectAllBy = genricDao.selectAllBy(c);

        for (Client client : selectAllBy) {
            System.out.println(client.getClientId()+" : "+client.getEmail()+" : "+Config.formatedDate(client.getBirthDate()));
        }
//        GenricDao<FriendList> xgenricDao = new GenricDao<>(FriendList.class);
//        genricDao.insert(c);
//        genricDao.delete(c);
//        genricDao.select(c);
//        genricDao.selectAllBy(c);
//        genricDao.update(c);
//    
//        xgenricDao.insert(friendList);
//        xgenricDao.delete(friendList);
//        xgenricDao.select(friendList);
//        xgenricDao.update(friendList);
    }
    
}
