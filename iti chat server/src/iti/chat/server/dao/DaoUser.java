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

    @Override
    int createImp(Client obj) {
        int check = 0;
        try {            
            query = "INSERT INTO Uset_Tab(userName,DisplayName,email,Password,BirthDate,Phone,gender,country,Status)"
                    + "VALUES('" + obj.getUserName() + "','" + obj.getDisplayName() + "','" + obj.getEmail() + "','" + obj.getPassword() + "','" + obj.getBirthDate() + "','" + obj.getPhone() + "','" + obj.getGender() + "','" + obj.getCountry() + "','" + obj.getStatus() + ")";
            if (Stmt.executeUpdate(query) > 0) {
                check = 1;
            }
            else
            {
                check=0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @Override
    Client readImp(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void updateImp(Client o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void deleteImp(Client o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    ArrayList<Client> getAllImp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int checkMailDoa(String mail) {
        int check = 0;
        ArrayList<Client> result = excuteQury("Select * from Uset_Tab where Email='" + mail + "' ");
        if (result.size() > 1) {
            check = 1;
        } else {
            check = 0;
        }
        return check;
    }
    
    public int checkPassDoa(String mail, String pass) {
        int check = 0;
        ArrayList<Client> result = excuteQury("Select uPassword from Uset_Tab where Email='" + mail + "' ");
        if (result.size() > 1) {
            check = 1;
        } else {
            check = 0;
        }
        return check;
    }
    
    public Client readImpByEmail(String mail, String pass) {
        
        ArrayList<Client> result = excuteQury("Select * from Uset_Tab where Email='" + mail + "' AND uPassword ='" + pass + "' ");
        
        return result.get(0);
    }
    public Client readImpByEmail2(String mail, String pass) {
        ResultSet res = null;
        Client client = new Client();
        try {
            query= "Select * from Uset_Tab where Email='" + mail + "' AND uPassword ='" + pass + "' ";
            res=Stmt.executeQuery(query);
            while (res.next()) {
              client.setClientId(res.getInt("CLIENT_ID"));
              client.setUserName(res.getString("userName"));
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
    
    public int checkUserNameDoa(String userName) {
        int check = 0;
        ArrayList<Client> result = excuteQury("Select * from Uset_Tab where userName='" + userName + "' ");
        if (result.size() > 1) {
            check = 1;
        } else {
            check = 0;
        }
        return check;
    }

}
