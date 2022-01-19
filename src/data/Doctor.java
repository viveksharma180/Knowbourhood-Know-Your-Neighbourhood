/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author jarvis
 */
public class Doctor {
    
    private String name;
    private String hospitalName;
    private String email;
    private String username;
    private String password;
    private long contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public Doctor(String name, String hospitalName, String email, String username, String password, long contact) {
        this.name = name;
        this.hospitalName = hospitalName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Doctor{" + "name=" + name + ", hospitalName=" + hospitalName + ", email=" + email + ", username=" + username + ", password=" + password + ", contact=" + contact + '}';
    }
    
}
