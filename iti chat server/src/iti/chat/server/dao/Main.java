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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abdalla
 */
public class Main {

    public Main() {

    }

    public static void main(String[] args) {

        Client c = new Client();
        c.setClientId(1);
        c.setStatus(2);
        Client c2 = new Client();
        c2.setClientId(2);
        Category cat = new Category(3);

        if (new DaoUser().check(c)) {
            ArrayList<Client> selectAllBy = new DaoUser().selectAllBy(c);
        } else {
            System.out.println("not");
        }

//        GenricDao<FriendList> xgenricDao = new GenricDao<>(FriendList.class);
//        genricDao.insert(c);
//        genricDao.delete(c);
//        genricDao.selectAny(c);
//        genricDao.selectAllBy(c);
//        genricDao.update(c);
//    
//        xgenricDao.insert(friendList);
//        xgenricDao.delete(friendList);
//        xgenricDao.selectAny(friendList);
//        xgenricDao.update(friendList);
    }

}
