/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.client.Services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import iti.chat.faces.ClientFace;

/**
 *
 * @author Bakar M.M.R
 */
public class ClientImpOperation extends UnicastRemoteObject implements ClientFace{

    public ClientImpOperation() throws RemoteException {
    }

    @Override
    public void recieve(String msg) throws RemoteException {
        System.out.println("client side");
    }

    @Override
    public void recieveFile() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void serverIsDown() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void refreshContactsList(String email) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recieveAnnoucementNotification(String serverAnnounce) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recieveFriendStatus(int i, String sentMail) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recieveFriendRequest(String sentMail) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
