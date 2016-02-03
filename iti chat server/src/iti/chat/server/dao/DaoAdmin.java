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
            query = "INSERT INTO ADMIN "
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateImp(Admins o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteImp(Admins o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
