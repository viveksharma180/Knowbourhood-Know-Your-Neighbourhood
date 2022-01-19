package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import data.Community;
import data.CommunityAdmin;
import data.Doctor;
import data.EmergencyServices;
import data.Fireman;
import data.Help;
import data.MNC;
import data.MNCReperesentative;
import data.News;
import data.Police;
import data.Report;
import data.Resident;
import data.Users;
import data.Volunteer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author jarvis
 */
public class FileUtils {

    private static final String nameRegex = "^[a-zA-Z ]+$";
    private static final String numberRegex = "^[0-9.]*$";
    private static final String nameNumberRegex = "^[a-zA-Z0-9-, ]+$";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM-DD-YYYY");
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static final SimpleDateFormat formatter3 = new SimpleDateFormat("MM-dd-yyyy");

    public static boolean validateName(String inputName) {
        return inputName.matches(nameRegex);
    }

    public static boolean validateNumber(String numberInput) {
        return numberInput.matches(numberRegex);
    }
    
    public static boolean validateEmail(String emailStr) {
        if (emailStr.equals("All")) {
            return true;
        }
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
}

    public static boolean validateNameNumber(String nameNumberInput) {
        return nameNumberInput.matches(nameNumberRegex);
    }

    public static boolean isValidDate(String input) {
        try {
            dateFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static Date convertStringToDate(String date) {
        if (date != null) {
            try {
                Date date3 = formatter3.parse(date);
                return date3;
            } catch (ParseException e) {
                // nothing we can do if the input is invalid
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public static int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static String readFile(String filepath) {
        BufferedReader reader = null;
        try {
            String s = "";
            reader = new BufferedReader(new FileReader(new File(filepath)));
            while (true) {
                String p = reader.readLine();
                if (p == null) {
                    break;
                } else {
                    s = s + p;
                }
            }
            reader.close();
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeFile(String filepath, String content) {
        try {
            File file = new File(filepath);
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(filepath))));
            pw.println(content);
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<CommunityAdmin> readCommunityAdmins() {
        Gson g = new Gson();
        String json = FileUtils.readFile("src/database/communityadmins.json");
        return g.fromJson(json, new TypeToken<ArrayList<CommunityAdmin>>() {
        }.getType());
    }

    public static void writeCommunityAdmins(ArrayList<CommunityAdmin> communityAdminList) {
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        writeFile("src/database/communityadmins.json", g.toJson(communityAdminList));
    }

    public static ArrayList<Fireman> readFiremen() {
        Gson g = new Gson();
        String json = FileUtils.readFile("src/database/firemen.json");
        return g.fromJson(json, new TypeToken<ArrayList<Fireman>>() {
        }.getType());
    }

    public static void writeFiremen(ArrayList<Fireman> firemenList) {
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        writeFile("src/database/firemen.json", g.toJson(firemenList));
    }

    public static ArrayList<Police> readPolice() {
        Gson g = new Gson();
        String json = FileUtils.readFile("src/database/police.json");
        return g.fromJson(json, new TypeToken<ArrayList<Police>>() {
        }.getType());
    }

    public static void writePolice(ArrayList<Police> policeList) {
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        writeFile("src/database/police.json", g.toJson(policeList));
    }

    public static ArrayList<Resident> readResidents() {
        Gson g = new Gson();
        String json = FileUtils.readFile("src/database/residents.json");
        return g.fromJson(json, new TypeToken<ArrayList<Resident>>() {
        }.getType());
    }

    public static void writeResidents(ArrayList<Resident> residentList) {
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        writeFile("src/database/residents.json", g.toJson(residentList));
    }

    public static ArrayList<Community> readCommunity() {
        Gson g = new Gson();
        String json = FileUtils.readFile("src/database/community-enterprise.json");
        return g.fromJson(json, new TypeToken<ArrayList<Community>>() {
        }.getType());
    }

    public static void writeCommunity(ArrayList<Community> communityList) {
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        writeFile("src/database/community-enterprise.json", g.toJson(communityList));
    }

    public static ArrayList<News> readNews() {
        Gson g = new Gson();
        String json = FileUtils.readFile("src/database/news.json");
        return g.fromJson(json, new TypeToken<ArrayList<News>>() {
        }.getType());
    }

    public static void writeNews(ArrayList<News> newsList) {
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        writeFile("src/database/news.json", g.toJson(newsList));
    }

    public static ArrayList<Report> readReport() {
        Gson g = new Gson();
        String json = FileUtils.readFile("src/database/reports.json");
        return g.fromJson(json, new TypeToken<ArrayList<Report>>() {
        }.getType());
    }

    public static void writeReport(ArrayList<Report> reportList) {
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        writeFile("src/database/reports.json", g.toJson(reportList));
    }

    public static ArrayList<Users> readUsers() {
        Gson g = new Gson();
        String json = FileUtils.readFile("src/database/users-enterprise.json");
        return g.fromJson(json, new TypeToken<ArrayList<Users>>() {
        }.getType());
    }

    public static void writeUsers(ArrayList<Users> usersList) {
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        writeFile("src/database/users-enterprise.json", g.toJson(usersList));
    }

    public static ArrayList<Doctor> readDoctors() {
        Gson g = new Gson();
        String json = FileUtils.readFile("src/database/doctor.json");
        return g.fromJson(json, new TypeToken<ArrayList<Doctor>>() {
        }.getType());
    }

    public static void writeDoctors(ArrayList<Doctor> doctorList) {
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        writeFile("src/database/doctor.json", g.toJson(doctorList));
    }

    public static ArrayList<EmergencyServices> readEs() {
        Gson g = new Gson();
        String json = FileUtils.readFile("src/database/es-enterprise.json");
        return g.fromJson(json, new TypeToken<ArrayList<EmergencyServices>>() {
        }.getType());
    }

    public static void writeEs(ArrayList<EmergencyServices> doctorList) {
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        writeFile("src/database/es-enterprise.json", g.toJson(doctorList));
    }

    public static ArrayList<MNC> readMNC() {
        Gson g = new Gson();
        String json = FileUtils.readFile("src/database/mnc-enterprise.json");
        return g.fromJson(json, new TypeToken<ArrayList<MNC>>() {
        }.getType());
    }

    public static void writeMNC(ArrayList<MNC> doctorList) {
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        writeFile("src/database/mnc-enterprise.json", g.toJson(doctorList));
    }
    
    public static ArrayList<MNCReperesentative> readMNCR() {
        Gson g = new Gson();
        String json = FileUtils.readFile("src/database/mncr.json");
        return g.fromJson(json, new TypeToken<ArrayList<MNCReperesentative>>() {
        }.getType());
    }

    public static void writeMNCR(ArrayList<MNCReperesentative> doctorList) {
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        writeFile("src/database/mncr.json", g.toJson(doctorList));
    }
    
    public static ArrayList<Help> readHelp() {
        Gson g = new Gson();
        String json = FileUtils.readFile("src/database/help.json");
        return g.fromJson(json, new TypeToken<ArrayList<Help>>() {
        }.getType());
    }

    public static void writeHelp(ArrayList<Help> doctorList) {
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        writeFile("src/database/help.json", g.toJson(doctorList));
    }

    public static ArrayList<Volunteer> readVolunteer() {
        Gson g = new Gson();
        String json = FileUtils.readFile("src/database/volunteer.json");
        return g.fromJson(json, new TypeToken<ArrayList<Volunteer>>() {
        }.getType());
    }

    public static void writeVolunteer(ArrayList<Volunteer> doctorList) {
        Gson g = new GsonBuilder().setPrettyPrinting().create();
        writeFile("src/database/volunteer.json", g.toJson(doctorList));
    }
    
    public static void sendMail(String to, String subject, String email_body) {
        String username = "knowbourhood@gmail.com";
        String password = "aedpassword123";
        doSendMail(username, password, to, subject, email_body);
    }

    public static void doSendMail(final String username, final String password, String to, String subject, String email_body) {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(email_body);
            Transport.send(message);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
}
