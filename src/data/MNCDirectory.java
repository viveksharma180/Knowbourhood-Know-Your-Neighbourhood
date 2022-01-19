/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.FileUtils;

/**
 *
 * @author prath
 */
public class MNCDirectory {
    
    private static MNCDirectory personDirectory;
    public static ArrayList<MNC> person;

    public MNCDirectory() {
        person = new ArrayList<>();
        ArrayList<MNCReperesentative> re = FileUtils.readMNCR();
        MNC person1 = new MNC(re);     
        person.add(person1);
        FileUtils.writeMNC(person);
        Gson g = new Gson();
        String json = FileUtils.readFile("src/database/mnc-enterprise.json");
        person = g.fromJson(json, new TypeToken<List<MNC>>() {
        }.getType());
    }

    private ArrayList<MNCReperesentative> getResident() {
        ArrayList<MNCReperesentative> resident = FileUtils.readMNCR();
        for (int i = 0; i < resident.size(); i++) {
            return resident;
        }
        return null;
    }

    private Date convert(String stringDate) {
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(stringDate);
            return date;
        } catch (ParseException ex) {
            Logger.getLogger(UsersDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<MNC> getPersonList() {
        return person;
    }

    public List<Community> getPatientList() {
        ArrayList<Community> newPatient = new ArrayList<Community>();
        for (MNC p : person) {
        }
        return newPatient;
    }
    
}
