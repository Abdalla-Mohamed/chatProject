/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.server.dao;

import iti.chat.entites.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdalla
 */
public class DaoUser extends GenricDao<Client> {

    String query;

    public DaoUser() {
        super(Client.class);
    }

    public int checkMailDoa(String mail) {
        int check = 0;
        Client c = new Client();
        c.setEmail(mail);
        if (check(c)) {
            check = 1;
        } else {
            check = 0;
        }
        return check;
    }

    public int checkPassDoa(String mail, String pass) {
        Client client = new Client();
        client.setEmail(mail);
        client.setPassword(mail);

        if (check(client)) {
            return 1;
        } else {
            return 0;
        }

    }

    public Client readImpByEmail(String mail, String pass) {
        Client client = new Client();
        client.setEmail(mail);
        client.setPassword(mail);

        ArrayList<Client> result = selectAllBy(client);
        return result.get(0);
    }


    public int checkUserNameDoa(String user_name) {
        int check = 0;
        Client c = new Client();
        c.setUserName(user_name);
        if (check(c)) {
            check = 1;
        } else {
            check = 0;
        }
        return check;
    }

    private ArrayList<Client> excuteQury(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
