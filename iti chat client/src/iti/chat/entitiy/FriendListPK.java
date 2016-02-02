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
@Embeddable
public class FriendListPK implements Serializable {
    private short fId;
    private short uId;

    public FriendListPK() {
    }

    public FriendListPK(short fId, short uId) {
        this.fId = fId;
        this.uId = uId;
    }

    public short getFId() {
        return fId;
    }

    public void setFId(short fId) {
        this.fId = fId;
    }

    public short getUId() {
        return uId;
    }

    public void setUId(short uId) {
        this.uId = uId;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FriendListPK)) {
            return false;
        }
        FriendListPK other = (FriendListPK) object;
        if (this.fId != other.fId) {
            return false;
        }
        if (this.uId != other.uId) {
            return false;
        }
        return true;
    }

    
}
