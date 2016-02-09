/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.server.dao;

import iti.chat.entites.Announcement;
import java.util.ArrayList;

/**
 *
 * @author Abdalla
 */
public class DaoAnnouncement extends GenricDao<Announcement>{

    public DaoAnnouncement() {
        super(Announcement.class);
    }

    
}
