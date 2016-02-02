/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.entites;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Abdalla
 */
public class ChatGroup implements Serializable {
    private Integer cgId;
    private String cgName;
    private Date lastMsg;
    private List<Client> clientList;
    private Client client;

    public ChatGroup() {
    }

    public ChatGroup(Integer cgId) {
        this.cgId = cgId;
    }

    public Integer getCgId() {
        return cgId;
    }

    public void setCgId(Integer cgId) {
        this.cgId = cgId;
    }

    public String getCgName() {
        return cgName;
    }

    public void setCgName(String cgName) {
        this.cgName = cgName;
    }

    public Date getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(Date lastMsg) {
        this.lastMsg = lastMsg;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cgId != null ? cgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChatGroup)) {
            return false;
        }
        ChatGroup other = (ChatGroup) object;
        if ((this.cgId == null && other.cgId != null) || (this.cgId != null && !this.cgId.equals(other.cgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "iti.chat.entites.ChatGroup[ cgId=" + cgId + " ]";
    }
    
}
