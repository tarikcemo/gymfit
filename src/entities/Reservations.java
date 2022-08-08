/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author User
 */
public class Reservations {
    private int Id;
    private int ProgramId;
    private int TrainerId;
    private String DateTime;
    private String DayOfTheWeek;
    private String User;
    
    public int getId() {
        return Id;
    }
    public int getProgramId() {
        return ProgramId;
    }
    public int getTrainerId() {
        return TrainerId;
    }
    public String getDateTime() {
        return DateTime;
    }
    public String getDayOfTheWeek() {
        return DayOfTheWeek;
    }
    public String getUser() {
        return User;
    }
    
    public void setId(int id) {
        this.Id = id;
    }
    public void setProgramId(int programId) {
        this.ProgramId = programId;
    }
    public void setTrainerId(int trainerId) {
        this.TrainerId = trainerId;
    }
    public void setDateTime(String dateTime) {
        this.DateTime = dateTime;
    }
    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.DayOfTheWeek = dayOfTheWeek;
    }
    public void setUser (String user) {
        this.User = user;
    }
}
