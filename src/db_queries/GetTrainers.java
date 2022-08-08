/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_queries;

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
public class GetTrainers {
    public static int getTrainerId
        (String name, String surname) {
        String query = "SELECT * FROM `trainers` WHERE Name = ? AND Surname = ?";
        PreparedStatement st;
        ResultSet rs;
        int trainerId = 0;
        try {
            st = DbConnection.getConnection().prepareStatement(query);
            st.setString(1, name);
            st.setString(2, surname);
            rs = st.executeQuery();
            while (rs.next()) {
                trainerId = rs.getInt("Id");
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return trainerId;
    }
}
