/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.entites;

import iti.chat.annotions.Column;
import iti.chat.annotions.Id;
import iti.chat.annotions.ManyToMany;
import iti.chat.annotions.ManyToOne;
import iti.chat.annotions.OneToMany;
import iti.chat.annotions.Table;
import java.io.Serializable;
import java.time.temporal.Temporal;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Abdalla
 */
@Table(name = "CLIENT")
public class Client implements Serializable {

    @Id
    @Column(name = "CLIENT_ID",sequnce = "seq_cli.nextval")
    private Integer clientId;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "DISPLAY_NAME")
    private String displayName;
    @Id
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "BIRTH_DATE")
    private Date birthDate;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "STATUS")
    private Integer status;
    @Column(name = "Q_ANS")
    private String qAns;
    @ManyToMany(type = Category.class)
    private List<Category> categoryList;
    @ManyToMany(type = ChatGroup.class)
    private List<ChatGroup> myChatList;
    @ManyToMany(type = Announcement.class)
    private List<Announcement> announcementList;
    @OneToMany(type = ChatGroup.class)
    private List<ChatGroup> chatGroupList;
    @ManyToOne(type = Question.class)
    @Column(name = "SECQUS")
    private Question question;
    @OneToMany(type = FriendList.class)
    private List<FriendList> friendList;
    @OneToMany(type = FriendList.class)
    private List<FriendList> friendAtList;

    public Client() {
    }

    public Client(Integer clientId) {
        this.clientId = clientId;
    }

    public Client( String userName, String displayName, String email, String password, Date birthDate, String qAns) {
        this.clientId = 0;
        this.userName = userName;
        this.displayName = displayName;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.qAns = qAns;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getQAns() {
        return qAns;
    }

    public void setQAns(String qAns) {
        this.qAns = qAns;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<ChatGroup> getMyChatList() {
        return myChatList;
    }

    public void setMyChatList(List<ChatGroup> myChatList) {
        this.myChatList = myChatList;
    }

    public List<Announcement> getAnnouncementList() {
        return announcementList;
    }

    public void setAnnouncementList(List<Announcement> announcementList) {
        this.announcementList = announcementList;
    }

    public List<ChatGroup> getChatGroupList() {
        return chatGroupList;
    }

    public void setChatGroupList(List<ChatGroup> chatGroupList) {
        this.chatGroupList = chatGroupList;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<FriendList> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<FriendList> friendList) {
        this.friendList = friendList;
    }

    public List<FriendList> getFriendAtList() {
        return friendAtList;
    }

    public void setFriendAtList(List<FriendList> friendAtList) {
        this.friendAtList = friendAtList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientId != null ? clientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clientId == null && other.clientId != null) || (this.clientId != null && !this.clientId.equals(other.clientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + clientId ;
    }

}
