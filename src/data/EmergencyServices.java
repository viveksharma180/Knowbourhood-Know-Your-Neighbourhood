/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author jarvis
 */
public class EmergencyServices {
    
    private ArrayList<Police> police;
    private ArrayList<Fireman> fireman;
    private ArrayList<Doctor> doctor;

    public ArrayList<Police> getPolice() {
        return police;
    }

    public void setPolice(ArrayList<Police> police) {
        this.police = police;
    }

    public ArrayList<Fireman> getFireman() {
        return fireman;
    }

    public void setFireman(ArrayList<Fireman> fireman) {
        this.fireman = fireman;
    }

    public ArrayList<Doctor> getDoctor() {
        return doctor;
    }

    public void setDoctor(ArrayList<Doctor> doctor) {
        this.doctor = doctor;
    }

    public EmergencyServices(ArrayList<Police> police, ArrayList<Fireman> fireman, ArrayList<Doctor> doctor) {
        this.police = police;
        this.fireman = fireman;
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "EmergencyServices{" + "police=" + police + ", fireman=" + fireman + ", doctor=" + doctor + '}';
    }
    
}
