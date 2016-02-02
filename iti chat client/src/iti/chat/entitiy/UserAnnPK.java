/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.entitiy;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Abdalla
 */
public class UserAnnPK implements Serializable {
    private short uId;
    private short aId;

    public UserAnnPK() {
    }

    public UserAnnPK(short uId, short aId) {
        this.uId = uId;
        this.aId = aId;
    }

    public short getUId() {
        return uId;
    }

    public void setUId(short uId) {
        this.uId = uId;
    }

    public short getAId() {
        return aId;
    }

    public void setAId(short aId) {
        this.aId = aId;
    }

 
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAnnPK)) {
            return false;
        }
        UserAnnPK other = (UserAnnPK) object;
        if (this.uId != other.uId) {
            return false;
        }
        if (this.aId != other.aId) {
            return false;
        }
        return true;
    }

    
}
