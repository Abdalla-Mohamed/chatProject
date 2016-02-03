/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.faces;

import iti.chat.entites.Client;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Abdalla
 */
public interface UserFace extends Remote{
    String serviceName="userService";
    int checkMail(String mail) throws RemoteException;
    int checkpass(String mail,String pass) throws RemoteException;
    int checkUserName(String userName) throws RemoteException;
    int signup(Client newuser) throws RemoteException;
    int signin(Client user) throws RemoteException;
    int resetPass(Client userForget) throws RemoteException;
    void register(ClientFace c)throws RemoteException;
    void unRegister(ClientFace c)throws RemoteException;
}
