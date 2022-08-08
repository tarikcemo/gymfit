/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_queries;

import entities.Reservations;
import gymfit.DbConnection;
import gymfit.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SetReservations {
    public static void setReservation(Reservations reservation) {
        String query = "INSERT INTO `reservations` (ProgramId, TrainerId, User, DayOfTheWeek, DateTime) VALUES (?,?,?,?,?)";
        PreparedStatement st;
        ResultSet rs;
        
        try {
            st = DbConnection.getConnection().prepareStatement(query);
            st.setInt(1, reservation.getProgramId());
            st.setInt(2, reservation.getTrainerId());
            st.setString(3, reservation.getUser());
            st.setString(4, reservation.getDayOfTheWeek());
            st.setString(5, reservation.getDateTime());
            
            st.execute();
        }
        catch(SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
