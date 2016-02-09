/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.entites;

import iti.chat.annotions.Column;
import iti.chat.annotions.Id;
import iti.chat.annotions.ManyToMany;
import iti.chat.annotions.ManyToOne;
import iti.chat.annotions.Table;
import java.io.Serializable;
import java.time.temporal.Temporal;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Abdalla
 */
@Table(name = "CHAT_GROUP")
public class ChatGroup implements Serializable {
    @Id
    @Column(name = "CG_ID")
    private Integer cgId;
    @Column(name = "CG_NAME")
    private String cgName;
    @Column(name = "LAST_MSG")
    private Date lastMsg;
    @ManyToMany(type = Client.class)
    private List<Client> clientList;
    @ManyToOne(type = Client.class)
    private Client uAdmin;

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

    public Client getuAdmin() {
        return uAdmin;
    }

    public void setuAdmin(Client uAdmin) {
        this.uAdmin = uAdmin;
    }
    
}
