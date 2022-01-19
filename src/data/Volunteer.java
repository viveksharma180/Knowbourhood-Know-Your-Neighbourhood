/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author prath
 */
public class Volunteer {
    
    private Resident resident;
    private Help help;

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public Help getHelp() {
        return help;
    }

    public void setHelp(Help help) {
        this.help = help;
    }

    public Volunteer(Resident resident, Help help) {
        this.resident = resident;
        this.help = help;
    }

    @Override
    public String toString() {
        return "Volunteer{" + "resident=" + resident + ", help=" + help + '}';
    }
}
