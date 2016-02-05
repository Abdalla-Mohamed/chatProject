/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.server.dao;

import iti.chat.entites.Admins;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.rsa.RSACore;

/**
 *
 * @author Abdalla
 */
public class DaoAdmin extends GenricDao<Admins> {

    String query;

    public DaoAdmin() {
    }

    @Override
    public int createImp(Admins o) {
        int chk = 0;
        try {
            query = "INSERT INTO ADMINS "
                    + "VALUES ('" + o.getAdminId() + "', '" + o.getAdminName() + "', '" + o.getAdminPass() + "')";
            if (Stmt.executeUpdate(query) > 0) {
                chk = 1;
            } else {
                chk = 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }

    @Override
    public Admins readImp(int id) {
        Admins admin = new Admins();
        admin.setAdminId(id);
        try {
            query = "SELECT ADMIN_NAME,ADMIN_PASS FROM ADMINS WHERE ADMIN_ID='" + id + "'";
            result = Stmt.executeQuery(query);
            admin.setAdminName(result.getString("ADMIN_NAME"));
            admin.setAdminPass(result.getString("ADMIN_PASS"));
        } catch (SQLException ex) {
            Logger.getLogger(DaoAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admin;
    }

    @Override
    public void updateImp(Admins o) {
        try {
            query = "UPDATE ADMINS SET ADMIN_PASS" + o.getAdminPass()
                    + " WHERE ADMIN_ID = " + o.getAdminId();
            Stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DaoAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteImp(Admins o) {
        try {
            query = "DELETE FROM ADMINS WHERE ADMIN_ID=" + o.getAdminId();
            Stmt.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<Admins> getAllImp() {
        ArrayList<Admins> adminlst = new ArrayList<Admins>();
        Admins admin = null;
        try {
            query = "SELECT * FROM ADMIN";
            result = Stmt.executeQuery(query);
            while (result.next()) {
                admin.setAdminId(result.getInt("ADMIN_ID"));
                admin.setAdminName(result.getString("ADMIN_NAME"));
                adminlst.add(admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adminlst;
    }

}
