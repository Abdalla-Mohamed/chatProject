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
        ArrayList<Client> result = excuteQury("Select * from CLIENT where Email='" + mail + "' ");
        if (result.size() > 1) {
            check = 1;
        } else {
            check = 0;
        }
        return check;
    }
    
    public int checkPassDoa(String mail, String pass) {
        Client client = new Client( null, null, mail, pass, null, null);
        
        int check = 0;
        ArrayList<Client> result = excuteQury("Select PASSWORD from CLIENT where Email='" + mail + "' ");
        if (result.size() > 1) {
            check = 1;
        } else {
            check = 0;
        }
        return check;
    }
    
    public Client readImpByEmail(String mail, String pass) {
        
        ArrayList<Client> result = excuteQury("Select * from CLIENT where Email='" + mail + "' AND PASSWORD ='" + pass + "' ");
        
        return result.get(0);
    }

    public Client readImpByEmail2(String mail, String pass) {
        ResultSet res = null;
        Client client = new Client();
        try {
            query= "Select * from CLIENT where Email='" + mail + "' AND PASSWORD ='" + pass + "' ";
            res=Stmt.executeQuery(query);
            while (res.next()) {
              client.setClientId(res.getInt("CLIENT_ID"));
              client.setUserName(res.getString("USER_NAME"));
              client.setDisplayName(res.getString("DisplayName"));
              client.setEmail(res.getString("email"));
              client.setPassword(res.getString("Password"));
              client.setBirthDate(res.getDate("BirthDate"));
              client.setPhone(res.getString("Phone"));
              client.setGender(res.getString("gender"));
              client.setCountry(res.getString("country"));
              client.setStatus(res.getInt("Status"));
   
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return client;
    }
    
    public int checkUserNameDoa(String user_name) {
        int check = 0;
        ArrayList<Client> result = excuteQury("Select * from CLIENT where USER_NAME='" + user_name + "' ");
        if (result.size() > 1) {
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
