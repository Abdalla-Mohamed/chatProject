/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.entitiy;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
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
public class UserAnn implements Serializable {
    protected UserAnnPK userAnnPK;
    private int annStatus;
    private Announcements announcements;
    private UserTab userTab;

    public UserAnn() {
    }

    public UserAnn(UserAnnPK userAnnPK) {
        this.userAnnPK = userAnnPK;
    }

    public UserAnn(UserAnnPK userAnnPK, int annStatus) {
        this.userAnnPK = userAnnPK;
        this.annStatus = annStatus;
    }

    public UserAnn(short uId, short aId) {
        this.userAnnPK = new UserAnnPK(uId, aId);
    }

    public UserAnnPK getUserAnnPK() {
        return userAnnPK;
    }

    public void setUserAnnPK(UserAnnPK userAnnPK) {
        this.userAnnPK = userAnnPK;
    }

    public int getAnnStatus() {
        return annStatus;
    }

    public void setAnnStatus(int annStatus) {
        this.annStatus = annStatus;
    }

    public Announcements getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(Announcements announcements) {
        this.announcements = announcements;
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
        if (!(object instanceof UserAnn)) {
            return false;
        }
        UserAnn other = (UserAnn) object;
        if ((this.userAnnPK == null && other.userAnnPK != null) || (this.userAnnPK != null && !this.userAnnPK.equals(other.userAnnPK))) {
            return false;
        }
        return true;
    }

    
}
