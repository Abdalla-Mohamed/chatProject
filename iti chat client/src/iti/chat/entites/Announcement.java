/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.entites;

import iti.chat.annotions.Column;
import iti.chat.annotions.Id;
import iti.chat.annotions.ManyToMany;
import iti.chat.annotions.Table;
import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Abdalla
 */
@Table(name = "ANNOUNCEMENTS")
public class Announcement implements Serializable {
    @Id
    @Column(name = "ANN_ID")
    private Integer annId;
    @Column(name = "ANN_TITLE")
    private String annTitle;
    @Column(name = "ANN_CONTENTS")
    private String annContents;
    @Column(name = "ANN_DATE")
    private Date annDate;
    @ManyToMany(type = Client.class)
    private List<Client> clientList;
    
    public Announcement() {
    }

    public Announcement(Integer annId) {
        this.annId = annId;
    }

    public Announcement(Integer annId, String annContents, Date annDate) {
        this.annId = annId;
        this.annContents = annContents;
        this.annDate = annDate;
    }

    public Integer getAnnId() {
        return annId;
    }

    public void setAnnId(Integer annId) {
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

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (annId != null ? annId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Announcement)) {
            return false;
        }
        Announcement other = (Announcement) object;
        if ((this.annId == null && other.annId != null) || (this.annId != null && !this.annId.equals(other.annId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "iti.chat.entites.Announcement[ annId=" + annId + " ]";
    }
    
}
