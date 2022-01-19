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
public class Help {
    
    private String workTitle;
    private String workDescription;
    private long contact;
    private Date date;
    private String community;
    private String email;
    private boolean paid;

    public String getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Help(String workTitle, String workDescription, long contact, Date date, String community, String email, boolean paid) {
        this.workTitle = workTitle;
        this.workDescription = workDescription;
        this.contact = contact;
        this.date = date;
        this.community = community;
        this.email = email;
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Help{" + "workTitle=" + workTitle + ", workDescription=" + workDescription + ", contact=" + contact + ", date=" + date + ", community=" + community + ", email=" + email + ", paid=" + paid + '}';
    }
}
