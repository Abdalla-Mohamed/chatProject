/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.config;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Abdalla
 */
public abstract class Config {
    
    final public static String dateFormat="yyyy/MM/dd";

    public Config() {
    }
    
    
    
        
   static public String formatedDate(Date date){
         return  new SimpleDateFormat(dateFormat).format(date);

   }
    
    
}
