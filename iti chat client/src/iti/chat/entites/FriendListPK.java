/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.entites;

import iti.chat.annotions.Column;
import java.io.Serializable;


/**
 *
 * @author Abdalla
 */

public class FriendListPK implements Serializable {
     @Column(name = "F_ID")
    private Integer fId;
    @Column(name = "U_ID")
    private Integer uId;
    public FriendListPK() {
    }

    public FriendListPK(Integer fId, Integer uId) {
        this.fId = fId;
        this.uId = uId;
    }

    public Integer getFId() {
        return fId;
    }

    public void setFId(Integer fId) {
        this.fId = fId;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fId != null ? fId.hashCode() : 0);
        hash += (uId != null ? uId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FriendListPK)) {
            return false;
        }
        FriendListPK other = (FriendListPK) object;
        if ((this.fId == null && other.fId != null) || (this.fId != null && !this.fId.equals(other.fId))) {
            return false;
        }
        if ((this.uId == null && other.uId != null) || (this.uId != null && !this.uId.equals(other.uId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "iti.chat.entites.FriendListPK[ fId=" + fId + ", uId=" + uId + " ]";
    }
    
}
