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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Abdalla
 */
public class Category implements Serializable {
    private Short catId;
    private String catName;
    private List<UserTab> userTabList;
    private List<FriendList> friendListList;

    public Category() {
    }

    public Category(Short catId) {
        this.catId = catId;
    }

    public Category(Short catId, String catName) {
        this.catId = catId;
        this.catName = catName;
    }

    public Short getCatId() {
        return catId;
    }

    public void setCatId(Short catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public List<UserTab> getUserTabList() {
        return userTabList;
    }

    public void setUserTabList(List<UserTab> userTabList) {
        this.userTabList = userTabList;
    }

    public List<FriendList> getFriendListList() {
        return friendListList;
    }

    public void setFriendListList(List<FriendList> friendListList) {
        this.friendListList = friendListList;
    }

  
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.catId == null && other.catId != null) || (this.catId != null && !this.catId.equals(other.catId))) {
            return false;
        }
        return true;
    }

   
    
}
