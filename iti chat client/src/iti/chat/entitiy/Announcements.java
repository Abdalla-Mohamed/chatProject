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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Abdalla
 */

public class Announcements implements Serializable {
    
    private Short annId;
    
    private String annTitle;
    
    
    private String annContents;
    
    
    private Date annDate;
    
    private List<UserAnn> userAnnList;

    public Announcements() {
    }

    public Announcements(Short annId) {
        this.annId = annId;
    }

    public Announcements(Short annId, String annContents, Date annDate) {
        this.annId = annId;
        this.annContents = annContents;
        this.annDate = annDate;
    }

    public Short getAnnId() {
        return annId;
    }

    public void setAnnId(Short annId) {
        this.annId = annId;
    }

    public String getAnnTitle() {
        return annTitle;
    }

    public void setAnnTitle(String annTitle) {
        this.annTitle = annTitle;
    }

    public String getAnnContents() {
        return annContents;
    }

    public void setAnnContents(String annContents) {
        this.annContents = annContents;
    }

    public Date getAnnDate() {
        return annDate;
    }

    public void setAnnDate(Date annDate) {
        this.annDate = annDate;
    }

    public List<UserAnn> getUserAnnList() {
        return userAnnList;
    }

    public void setUserAnnList(List<UserAnn> userAnnList) {
        this.userAnnList = userAnnList;
    }


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Announcements)) {
            return false;
        }
        Announcements other = (Announcements) object;
        if ((this.annId == null && other.annId != null) || (this.annId != null && !this.annId.equals(other.annId))) {
            return false;
        }
        return true;
    }

    
}
