/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.entites;

import iti.chat.annotions.Column;
import iti.chat.annotions.ForignKey;
import iti.chat.annotions.Id;
import iti.chat.annotions.ManyToOne;
import iti.chat.annotions.Table;
import java.io.Serializable;

/**
 *
 * @author Abdalla
 */
@Table(name = "FRIEND_LIST")
public class FriendList implements Serializable {

    protected FriendListPK friendListPK;
    @Column(name = "f_cat")
    @ForignKey(type = Category.class, keyField = "catId")
    private Category category;
    @Id
    @Column(name = "U_ID")
    @ForignKey(type = Client.class, keyField = "clientId")
    private Client owner;
    @Id
    @Column(name = "F_ID")
    @ForignKey(type = Client.class, keyField = "clientId")
    private Client friend;

    public FriendList() {
    }

    public FriendList(Client own, Client frd) {
        this.owner = own;
        this.friend = frd;
    }

    public FriendList(Client own, Client frnd, Category category) {
        this.category = category;
        this.owner = own;
        this.friend = frnd;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public Client getFriend() {
        return friend;
    }

    public void setFriend(Client friend) {
        this.friend = friend;
    }

}
