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
public class UsersDirectory {

    private static UsersDirectory personDirectory;
//    private Person person = new Person();
    public static ArrayList<Users> person;

    public UsersDirectory() {
        person = new ArrayList<>();
        ArrayList<Resident> re = FileUtils.readResidents();
        ArrayList<Police> po = FileUtils.readPolice();
        ArrayList<Fireman> fi = FileUtils.readFiremen();
        ArrayList<CommunityAdmin> ca = FileUtils.readCommunityAdmins();
        Users person1 = new Users(re, po, ca, fi);
//        Person person2 = new Person("Hardik", "Shrivastava", convert("2002-01-01"), 8005493889L, FileUtils.createSingleCity("Huntington Community", 915, "715 Huntington Avenue", "Boston", "MA", 02120, 8005493889L), true);
//        Person person3 = new Person("Vibhi", "Pulgam", convert("1999-10-14"), 1111111111L, FileUtils.createSingleCity("Mission Hill Community", 1202, "1255 Calmon Street", "Boston", "MA", 02120, 1111111111L), true);
//        Person person4 = new Person("Anuj", "Raut", convert("1999-08-23"), 9702838033L, FileUtils.createSingleCity("Roxbury Community", 602, "1575 Tremont Street", "Boston", "MA", 02120, 9702838033L), false);
//        
        person.add(person1);
        FileUtils.writeUsers(person);
//        person.add(person2);
//        person.add(person3);
//        person.add(person4);
//        FileUtils.writePerson(person);
//        person.add(person2);
//        person.add(person3);
//        person.add(person4);
//        person.add(person5);
//        person.add(person6);
//        person.add(person7);
//        person.add(person8);
        Gson g = new Gson();
        String json = FileUtils.readFile("src/database/users-enterprise.json");
        person = g.fromJson(json, new TypeToken<List<Users>>() {
        }.getType());
    }

    private ArrayList<Resident> getResident() {
        ArrayList<Resident> resident = FileUtils.readResidents();
        for (int i = 0; i < resident.size(); i++) {
            return resident;
        }
        return null;
    }

    private ArrayList<Police> getPolice() {
        ArrayList<Police> police = FileUtils.readPolice();
        for (int i = 0; i < police.size(); i++) {
            return police;
        }
        return null;
    }

    private ArrayList<Fireman> getFireman() {
        ArrayList<Fireman> fireman = FileUtils.readFiremen();
        for (int i = 0; i < fireman.size(); i++) {
            return fireman;
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

    public List<Users> getPersonList() {
        return person;
    }

    public List<Users> getPatientList() {
        ArrayList<Users> newPatient = new ArrayList<Users>();
        for (Users p : person) {
        }
        return newPatient;
    }

}
