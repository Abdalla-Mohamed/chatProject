/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.entites;

import iti.chat.annotions.Column;
import iti.chat.annotions.Id;
import iti.chat.annotions.Table;
import java.io.Serializable;


/**
 *
 * @author Abdalla
 */
@Table(name = "ADMINS")
public class Admins implements Serializable {
    @Id
    @Column(name = "ADMIN_ID",sequnce = "seq_admin.nextval"   )
    private Integer adminId;
    @Column(name = "ADMIN_NAME")
    private String adminName;
    @Column(name = "ADMIN_PASS")
    private String adminPass;
    public Admins() {
    }

    public Admins(Integer adminId) {
        this.adminId = adminId;
    }

    public Admins(Integer adminId, String adminName, String adminPass) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPass = adminPass;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminId != null ? adminId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admins)) {
            return false;
        }
        Admins other = (Admins) object;
        if ((this.adminId == null && other.adminId != null) || (this.adminId != null && !this.adminId.equals(other.adminId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "iti.chat.entites.Admins[ adminId=" + adminId + " ]";
    }
    
}
