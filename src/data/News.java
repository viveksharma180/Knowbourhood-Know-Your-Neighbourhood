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
public class News {
    
    private String subject;
    private String message;
    private String community;
    private Date date;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public News(String subject, String message, String community, Date date, String email) {
        this.subject = subject;
        this.message = message;
        this.community = community;
        this.date = date;
        this.email = email;
    }

    @Override
    public String toString() {
        return "News{" + "subject=" + subject + ", message=" + message + ", community=" + community + ", date=" + date + ", email=" + email + '}';
    }
    
}
