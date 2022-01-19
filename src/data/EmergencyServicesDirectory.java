/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author jarvis
 */
public class EmergencyServicesDirectory {
    
    private static EmergencyServicesDirectory personDirectory;
    public static ArrayList<EmergencyServices> person;

    public EmergencyServicesDirectory() {
        person = new ArrayList<>();
        ArrayList<Police> re = FileUtils.readPolice();
        ArrayList<Fireman> ca = FileUtils.readFiremen();
        ArrayList<Doctor> dr = FileUtils.readDoctors();
        EmergencyServices person1 = new EmergencyServices(re, ca, dr);     
        person.add(person1);
        FileUtils.writeEs(person);
        Gson g = new Gson();
        String json = FileUtils.readFile("src/database/es-enterprise.json");
        person = g.fromJson(json, new TypeToken<List<EmergencyServices>>() {
        }.getType());
    }

    private ArrayList<Resident> getResident() {
        ArrayList<Resident> resident = FileUtils.readResidents();
        for (int i = 0; i < resident.size(); i++) {
            return resident;
        }
        return null;
    }

    private ArrayList<CommunityAdmin> getCAdmin() {
        ArrayList<CommunityAdmin> ca = FileUtils.readCommunityAdmins();
        for (int i = 0; i < ca.size(); i++) {
            return ca;
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

    public List<EmergencyServices> getPersonList() {
        return person;
    }

    public List<EmergencyServices> getPatientList() {
        ArrayList<EmergencyServices> newPatient = new ArrayList<EmergencyServices>();
        for (EmergencyServices p : person) {
        }
        return newPatient;
    }
    
    
}
