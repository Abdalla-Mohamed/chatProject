/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.entitiy;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Abdalla
 */
public class ChatGroup implements Serializable {
    private Short cgId;
    private String cgName;
    private Date lastMsg;
    private List<UserTab> userTabList;
    private UserTab uAdmin;

    public ChatGroup() {
    }

    public ChatGroup(Short cgId) {
        this.cgId = cgId;
    }

    public Short getCgId() {
        return cgId;
    }

    public void setCgId(Short cgId) {
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

    public List<UserTab> getUserTabList() {
        return userTabList;
    }

    public void setUserTabList(List<UserTab> userTabList) {
        this.userTabList = userTabList;
    }

    public UserTab getUAdmin() {
        return uAdmin;
    }

    public void setUAdmin(UserTab uAdmin) {
        this.uAdmin = uAdmin;
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

    
}
