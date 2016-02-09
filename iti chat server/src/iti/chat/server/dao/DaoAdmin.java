/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.server.dao;

import iti.chat.entites.Admins;

/**
 *
 * @author Abdalla
 */
public class DaoAdmin extends GenricDao<Admins> {

    String query;

    public DaoAdmin() {
        super(Admins.class);
    }



}
