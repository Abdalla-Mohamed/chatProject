/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdalla
 */
public abstract class Config {

    final public static String dateFormat = "yyyy/MM/dd";

    public Config() {
    }

    static public String formatedDate(Date date) {
        return new SimpleDateFormat(dateFormat).format(date);

    }

    static public Date convetToDate(String date) {
        Date dateConv = null;
        try {
            dateConv = new SimpleDateFormat(dateFormat).parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dateConv;
    }

}
