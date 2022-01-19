/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Date;

/**
 *
 * @author prath
 */
public class MNCReperesentative {
    
    private String name;
    private Date dob;
    private long contact;
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

    public MNCReperesentative(String name, Date dob, long contact, String username, String password, String email) {
        this.name = name;
        this.dob = dob;
        this.contact = contact;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "CommunityAdmin{" + "name=" + name + ", dob=" + dob + ", contact=" + contact + ", username=" + username + ", password=" + password + ", email=" + email + '}';
    }
    
}
