/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author prath
 */
public class Users {
    
    private ArrayList<Resident> r;
    private ArrayList<Police> p;
    private ArrayList<CommunityAdmin> c;
    private ArrayList<Fireman> f;

    public ArrayList<Resident> getR() {
        return r;
    }

    public void setR(ArrayList<Resident> r) {
        this.r = r;
    }

    public ArrayList<Police> getP() {
        return p;
    }

    public void setP(ArrayList<Police> p) {
        this.p = p;
    }

    public ArrayList<CommunityAdmin> getC() {
        return c;
    }

    public void setC(ArrayList<CommunityAdmin> c) {
        this.c = c;
    }

    public ArrayList<Fireman> getF() {
        return f;
    }

    public void setF(ArrayList<Fireman> f) {
        this.f = f;
    }

    public Users(ArrayList<Resident> r, ArrayList<Police> p, ArrayList<CommunityAdmin> c, ArrayList<Fireman> f) {
        this.r = r;
        this.p = p;
        this.c = c;
        this.f = f;
    }

    @Override
    public String toString() {
        return "Users{" + "r=" + r + ", p=" + p + ", c=" + c + ", f=" + f + '}';
    }
}
