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
 public class Category implements Serializable {
 
    private Integer catId;
    private String catName;
    private List<Client> clientList;
    private List<FriendList> friendListList;

    public Category() {
    }

    public Category(Integer catId) {
        this.catId = catId;
    }

    public Category(Integer catId, String catName) {
        this.catId = catId;
        this.catName = catName;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public List<FriendList> getFriendListList() {
        return friendListList;
    }

    public void setFriendListList(List<FriendList> friendListList) {
        this.friendListList = friendListList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catId != null ? catId.hashCode() : 0);
        return hash;
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

    @Override
    public String toString() {
        return "iti.chat.entites.Category[ catId=" + catId + " ]";
    }
    
}
