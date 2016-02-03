/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.faces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Bakar M.M.R
 */
public interface ClientFace extends Remote{
    
     void recieve (String msg)throws RemoteException;
    
}
