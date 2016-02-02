/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.entitiy;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Abdalla
 */
public class UserQus implements Serializable {
    private Short uId;
    private String qAns;
    private Questions qId;
    private UserTab userTab;

    public UserQus() {
    }

    public UserQus(Short uId) {
        this.uId = uId;
    }

    public UserQus(Short uId, String qAns) {
        this.uId = uId;
        this.qAns = qAns;
    }

    public Short getUId() {
        return uId;
    }

    public void setUId(Short uId) {
        this.uId = uId;
    }

    public String getQAns() {
        return qAns;
    }

    public void setQAns(String qAns) {
        this.qAns = qAns;
    }

    public Questions getQId() {
        return qId;
    }

    public void setQId(Questions qId) {
        this.qId = qId;
    }

    public UserTab getUserTab() {
        return userTab;
    }

    public void setUserTab(UserTab userTab) {
        this.userTab = userTab;
    }

   

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserQus)) {
            return false;
        }
        UserQus other = (UserQus) object;
        if ((this.uId == null && other.uId != null) || (this.uId != null && !this.uId.equals(other.uId))) {
            return false;
        }
        return true;
    }
 
    
}
