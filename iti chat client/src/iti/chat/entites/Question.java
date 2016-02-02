/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.entites;

import java.io.Serializable;

import java.util.List;

/**
 *
 * @author Abdalla
 */
public class Question implements Serializable {
    private Integer qId;
    private String qValue;
    private List<Client> clientList;

    public Question() {
    }

    public Question(Integer qId) {
        this.qId = qId;
    }

    public Question(Integer qId, String qValue) {
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

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qId != null ? qId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.qId == null && other.qId != null) || (this.qId != null && !this.qId.equals(other.qId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "iti.chat.entites.Question[ qId=" + qId + " ]";
    }
    
}
