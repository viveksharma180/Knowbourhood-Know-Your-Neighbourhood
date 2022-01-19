/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author viveksharma
 */
public class Community {
    
    private ArrayList<Resident> r;
    private ArrayList<CommunityAdmin> ca;

    public ArrayList<Resident> getR() {
        return r;
    }

    public void setR(ArrayList<Resident> r) {
        this.r = r;
    }

    public ArrayList<CommunityAdmin> getCa() {
        return ca;
    }

    public void setCa(ArrayList<CommunityAdmin> ca) {
        this.ca = ca;
    }

    public Community(ArrayList<Resident> r, ArrayList<CommunityAdmin> ca) {
        this.r = r;
        this.ca = ca;
    }

    @Override
    public String toString() {
        return "Community{" + "r=" + r + ", ca=" + ca + '}';
    }
}
