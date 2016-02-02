/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdalla
 * @param <T>
 */
abstract public class GenricDao<T> {

    
    private final String DBurl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
    private final String userName = "chat";
    private final String password = "chat";
    Connection con=null;
    Statement Stmt = null;
    ResultSet result = null;
   // private String query = null;

    
    public GenricDao() {
        
    }

    public int create(T o) {
        int createImp = 0;
        try {
            openConnection();
             createImp = createImp(o);
            closeConnection();
            
        } catch (SQLException ex) {
            Logger.getLogger(GenricDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return createImp;
    }

    public T read(int id) {
        
        T readImp = null; 
        try {
            openConnection();
            readImp = readImp(id);
            closeConnection();
           
        } catch (SQLException ex) {
            Logger.getLogger(GenricDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return readImp;
    }

    public void update(T o) {
        try {
            openConnection();
            updateImp(o);
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(GenricDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(T o) {
        try {
            openConnection();
            deleteImp(o);
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(GenricDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<T> getAll() {
         ArrayList<T> allImp = null;
        try {
            openConnection();
            allImp = getAllImp();
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(GenricDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allImp;
    }

    public ArrayList<T> excuteQury(String query) {
        try {
            openConnection();
            result = Stmt.executeQuery(query);
            closeConnection();  
        } catch (SQLException ex) {
            Logger.getLogger(GenricDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ArrayList<T>) result;
    }

    abstract  int createImp(T o);

    abstract  T readImp(int id);

    abstract  void updateImp(T o);

    abstract  void deleteImp(T o);

    abstract  ArrayList<T> getAllImp();
    
    public void openConnection() throws SQLException
    {
             Stmt = con.createStatement();
             con = DriverManager.getConnection(DBurl, userName, password);

    }
    public void closeConnection() throws SQLException
    {
            con.close();
    }
    

}
