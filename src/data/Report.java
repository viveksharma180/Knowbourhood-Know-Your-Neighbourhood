/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.Date;

/**
 *
 * @author viveksharma
 */
public class Report {
    
    private String name;
    private String subject;
    private String message;
    private String community;
    private Date date;
    private long contact;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Report(String name, String subject, String message, String community, Date date, long contact, String email) {
        this.name = name;
        this.subject = subject;
        this.message = message;
        this.community = community;
        this.date = date;
        this.contact = contact;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Report{" + "name=" + name + ", subject=" + subject + ", message=" + message + ", community=" + community + ", date=" + date + ", contact=" + contact + ", email=" + email + '}';
    }
}
