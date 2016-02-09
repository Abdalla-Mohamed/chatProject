/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.entites;

import iti.chat.annotions.Column;
import iti.chat.annotions.ManyToOne;
import java.io.Serializable;

/**
 *
 * @author Abdalla
 */
public class FriendList implements Serializable {

    protected FriendListPK friendListPK;
    @Column(name ="fCat")
    @ManyToOne(type = Category.class)
    private Category category;
    @Column(name = "U_ID")
    @ManyToOne(type = Client.class)
    private Client owner;
     @Column(name = "F_ID")
    @ManyToOne(type = Client.class)
    private Client friend;

    public FriendList() {
    }

    public FriendList(Client client, Client client1) {
        this.owner = client;
        this.friend = client1;
    }

    public FriendList(Client client, Client client1, Category category) {
        this.category = category;
        this.owner = client;
        this.friend = client1;
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
