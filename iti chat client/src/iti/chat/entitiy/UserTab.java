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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Abdalla
 */

public class UserTab implements Serializable {
    private static final long serialVersionUID = 1L;
    private Short userId;
    private String userName;
    private String displayName;
    private String email;
    private String uPassword;
    private Date birthDate;
    private Long uPhone;
    private String gender;
    private String country;
    private short uStatus;
    private List<Category> categoryList;
    private List<ChatGroup> chatGroupList;
    private List<ChatGroup> chatGroupList1;
    private List<UserAnn> userAnnList;
    private UserQus userQus;
    private List<FriendList> friendListList;
    private List<FriendList> friendListList1;

  
    
    
    //<editor-fold defaultstate="collapsed" desc="constractors">
    
    
    public UserTab() {
    }
    
    public UserTab(Short userId) {
        this.userId = userId;
    }
    
    public UserTab(Short userId, String userName, String displayName, String email, String uPassword, short uStatus) {
        this.userId = userId;
        this.userName = userName;
        this.displayName = displayName;
        this.email = email;
        this.uPassword = uPassword;
        this.uStatus = uStatus;
    }
    
    public UserTab(Short userId, String userName, String displayName, String email, String uPassword, Date birthDate, Long uPhone, String gender, String country, short uStatus, List<Category> categoryList, List<ChatGroup> chatGroupList, List<ChatGroup> chatGroupList1, List<UserAnn> userAnnList, UserQus userQus, List<FriendList> friendListList, List<FriendList> friendListList1) {
        this.userId = userId;
        this.userName = userName;
        this.displayName = displayName;
        this.email = email;
        this.uPassword = uPassword;
        this.birthDate = birthDate;
        this.uPhone = uPhone;
        this.gender = gender;
        this.country = country;
        this.uStatus = uStatus;
        this.categoryList = categoryList;
        this.chatGroupList = chatGroupList;
        this.chatGroupList1 = chatGroupList1;
        this.userAnnList = userAnnList;
        this.userQus = userQus;
        this.friendListList = friendListList;
        this.friendListList1 = friendListList1;
    }
    
    
//</editor-fold>
    
    
    public Short getUserId() {
        return userId;
    }

    public void setUserId(Short userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUPassword() {
        return uPassword;
    }

    public void setUPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getUPhone() {
        return uPhone;
    }

    public void setUPhone(Long uPhone) {
        this.uPhone = uPhone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public short getUStatus() {
        return uStatus;
    }

    public void setUStatus(short uStatus) {
        this.uStatus = uStatus;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<ChatGroup> getChatGroupList() {
        return chatGroupList;
    }

    public void setChatGroupList(List<ChatGroup> chatGroupList) {
        this.chatGroupList = chatGroupList;
    }

    public List<ChatGroup> getChatGroupList1() {
        return chatGroupList1;
    }

    public void setChatGroupList1(List<ChatGroup> chatGroupList1) {
        this.chatGroupList1 = chatGroupList1;
    }

    public List<UserAnn> getUserAnnList() {
        return userAnnList;
    }

    public void setUserAnnList(List<UserAnn> userAnnList) {
        this.userAnnList = userAnnList;
    }

    public UserQus getUserQus() {
        return userQus;
    }

    public void setUserQus(UserQus userQus) {
        this.userQus = userQus;
    }

    public List<FriendList> getFriendListList() {
        return friendListList;
    }

    public void setFriendListList(List<FriendList> friendListList) {
        this.friendListList = friendListList;
    }

    public List<FriendList> getFriendListList1() {
        return friendListList1;
    }

    public void setFriendListList1(List<FriendList> friendListList1) {
        this.friendListList1 = friendListList1;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTab)) {
            return false;
        }
        UserTab other = (UserTab) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

  
}
