/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.entitiy;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Abdalla
 */
public class FriendList implements Serializable {
    protected FriendListPK friendListPK;
    private Category fCat;
    private UserTab userTab;
    private UserTab userTab1;

    public FriendList() {
    }

    public FriendList(FriendListPK friendListPK) {
        this.friendListPK = friendListPK;
    }

    public FriendList(short fId, short uId) {
        this.friendListPK = new FriendListPK(fId, uId);
    }

    public FriendListPK getFriendListPK() {
        return friendListPK;
    }

    public void setFriendListPK(FriendListPK friendListPK) {
        this.friendListPK = friendListPK;
    }

    public Category getFCat() {
        return fCat;
    }

    public void setFCat(Category fCat) {
        this.fCat = fCat;
    }

    public UserTab getUserTab() {
        return userTab;
    }

    public void setUserTab(UserTab userTab) {
        this.userTab = userTab;
    }

    public UserTab getUserTab1() {
        return userTab1;
    }

    public void setUserTab1(UserTab userTab1) {
        this.userTab1 = userTab1;
    }


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FriendList)) {
            return false;
        }
        FriendList other = (FriendList) object;
        if ((this.friendListPK == null && other.friendListPK != null) || (this.friendListPK != null && !this.friendListPK.equals(other.friendListPK))) {
            return false;
        }
        return true;
    }

    
}
