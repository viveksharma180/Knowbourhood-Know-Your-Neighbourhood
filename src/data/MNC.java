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
public class MNC {
    
    private MNCAdmin mnca;
    private ArrayList<MNCReperesentative> mncr;

    public ArrayList<MNCReperesentative> getR() {
        return mncr;
    }

    public void setR(ArrayList<MNCReperesentative> mncr) {
        this.mncr = mncr;
    }

    public MNC(ArrayList<MNCReperesentative> mncr) {
        this.mncr = mncr;
    }

    @Override
    public String toString() {
        return "MNCDirectory{" + "mncr=" + mncr + '}';
    }
}
