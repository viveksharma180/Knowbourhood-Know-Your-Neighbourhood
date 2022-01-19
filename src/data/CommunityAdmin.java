/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.Date;

/**
 *
 * @author jarvis
 */
public class CommunityAdmin {
    private String name;
    private Date dob;
    private long contact;
    private String communityName;
    private String username;
    private String password;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CommunityAdmin(String name, Date dob, long contact, String communityName, String username, String password, String email) {
        this.name = name;
        this.dob = dob;
        this.contact = contact;
        this.communityName = communityName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "CommunityAdmin{" + "name=" + name + ", dob=" + dob + ", contact=" + contact + ", communityName=" + communityName + ", username=" + username + ", password=" + password + ", email=" + email + '}';
    }
    
}
