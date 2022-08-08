/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_queries;

import entities.Reservations;
import entities.Schedules;
import entities.Trainers;
import gymfit.DbConnection;
import gymfit.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;


/**
 *
 * @author User
 */
public class GetSchedules {
    public static List<Schedules> getSchedules(int programIdFromGui) {
        // Prvo kreiramo query koji cemo poslati ka bazi sa parametrima (parametri su predstavljeni upitnikom i setuju se naknadno)
        String query = "SELECT SCHEDULES.*, TRAINERS.* FROM `schedules` INNER JOIN `trainers` on schedules.TrainerId = trainers.Id WHERE `ProgramId` = ?";
        PreparedStatement st;
        ResultSet rs;
        
        // Kreiramo praznu listu rasporeda koju cemo naknadno popunjavati objektima tipa Schedules i na kraju cemo vratiti ovu listu kao rezultat
        List<Schedules> schedules = new ArrayList<Schedules>();
        
        try {
            // Naredba ispod kreira konekciju prema bazi koristeci klasu DbConnection i metodu unutar te klase .getConnection()
            // te priprema query naredbu koja ce se izvrsiti na bazi
            st = DbConnection.getConnection().prepareStatement(query);
            // Naredba ispod setuje parametar ProgramId u query-ju na programIdFromGui koji se proslijedi iz poziva getSchedules() (sa GUI-ja)
            st.setInt(1, programIdFromGui);
            // Naredba ispod izvrsava dati query na bazi
            rs = st.executeQuery();
            
            // ResultSet rs ce biti setovan na redove koji se vrate iz baze i dokle god ima redova prilikom provjere sa rs.next(), while petlja ce se izvrsavati
            // rs ce sadrzavati onoliko redova koliko ih ima u bazi za dati query
            while (rs.next()) {
                // naredbe ispod dohvacaju iz result set-a podatke koristeci nazive kolona u tabeli i odgovarajuce tipove podataka
                int Id = rs.getInt("Id");
                String dateTime = rs.getString("DateTime");
                int trainerId = rs.getInt("TrainerId");
                String dayOfTheWeek = rs.getString("DayOfTheWeek");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String phoneNumber = rs.getString("PhoneNumber");
                
                // Koristeci dohvacene podatke iz baze, za svaki red u bazi iz tabele "schedules" kreiramo jedan objekat tipa Schedules i dodijelimo ga listi schedules
                Schedules s = new Schedules();
                s.setId(Id);
                s.setDateTime(dateTime);
                s.setDayOfTheWeekId(dayOfTheWeek);
                s.setTrainerId(trainerId);
                s.setProgramId(programIdFromGui);
                
                // Kao i za schedules iznad, isto radimo i za trainers
                Trainers trainer = new Trainers();
                trainer.setName(name);
                trainer.setSurname(surname);
                trainer.setPhoneNumber(phoneNumber);
                s.setTrainer(trainer);
                
                // na kraju dodajemo objekat schedules u listu objekata schedules
                schedules.add(s);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Ukoliko je sve iznad proslo bez problema, vracamo listu schedules kao rezultat ove metode
        return schedules;
    }

    public static List<Reservations> getReservationsCountForTrainer(int programId, int trainerId) {
        String query = "SELECT * FROM `reservations` WHERE `ProgramId` = ? AND `TrainerId` = ?";
        PreparedStatement st;
        ResultSet rs;
        
        // Kreiramo praznu listu rasporeda koju cemo naknadno popunjavati objektima tipa Schedules i na kraju cemo vratiti ovu listu kao rezultat
        List<Reservations> reservations = new ArrayList<Reservations>();
        try {
            // Naredba ispod kreira konekciju prema bazi koristeci klasu DbConnection i metodu unutar te klase .getConnection()
            // te priprema query naredbu koja ce se izvrsiti na bazi
            st = DbConnection.getConnection().prepareStatement(query);
            // Naredba ispod setuje parametar ProgramId u query-ju na programIdFromGui koji se proslijedi iz poziva getSchedules() (sa GUI-ja)
            st.setInt(1, programId);
            st.setInt(2, trainerId);
            // Naredba ispod izvrsava dati query na bazi
            rs = st.executeQuery();
            
            // ResultSet rs ce biti setovan na redove koji se vrate iz baze i dokle god ima redova prilikom provjere sa rs.next(), while petlja ce se izvrsavati
            // rs ce sadrzavati onoliko redova koliko ih ima u bazi za dati query
            while (rs.next()) {
                // naredbe ispod dohvacaju iz result set-a podatke koristeci nazive kolona u tabeli i odgovarajuce tipove podataka
                int Id = rs.getInt("Id");
                String dateTime = rs.getString("DateTime");
                String dayOfTheWeek = rs.getString("DayOfTheWeek");
                
                // Koristeci dohvacene podatke iz baze, za svaki red u bazi iz tabele "schedules" kreiramo jedan objekat tipa Schedules i dodijelimo ga listi schedules
                Reservations res = new Reservations();
                res.setId(Id);
                res.setDateTime(dateTime);
                res.setDayOfTheWeek(dayOfTheWeek);
                res.setTrainerId(trainerId);
                res.setProgramId(programId);
                
                // na kraju dodajemo objekat schedules u listu objekata schedules
                reservations.add(res);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reservations;
    }
}
