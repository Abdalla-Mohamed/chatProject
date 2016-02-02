/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.entitiy;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Abdalla
 */
public class Questions implements Serializable {
    private Integer qId;
    private String qValue;
    private List<UserQus> userQusList;

    public Questions() {
    }

    public Questions(Integer qId) {
        this.qId = qId;
    }

    public Questions(Integer qId, String qValue) {
        this.qId = qId;
        this.qValue = qValue;
    }

    public Integer getQId() {
        return qId;
    }

    public void setQId(Integer qId) {
        this.qId = qId;
    }

    public String getQValue() {
        return qValue;
    }

    public void setQValue(String qValue) {
        this.qValue = qValue;
    }

    public List<UserQus> getUserQusList() {
        return userQusList;
    }

    public void setUserQusList(List<UserQus> userQusList) {
        this.userQusList = userQusList;
    }

     
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questions)) {
            return false;
        }
        Questions other = (Questions) object;
        if ((this.qId == null && other.qId != null) || (this.qId != null && !this.qId.equals(other.qId))) {
            return false;
        }
        return true;
    }

     
}
