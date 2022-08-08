/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author User
 */
public class Schedules {
    private int Id;
    private String DateTime;
    private int TrainerId;
    private Trainers Trainer;
    private String DayOfTheWeek;
    private int ProgramId;
    
    @Id
    @Column(name = "SchedulesId")
    public int getId() {
        return Id;
    }
    public String getDateTime() {
        return DateTime;
    }
    public int getTrainerId() {
        return TrainerId;
    }
    public String getDayOfTheWeek() {
        return DayOfTheWeek;
    }
    public int getProgramId() {
        return ProgramId;
    }
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TrainerId")
    public Trainers getTrainer() {
        return Trainer;
    }    
    
    public void setId(int id) {
        this.Id = id;
    }
    public void setDateTime(String dateTime) {
        this.DateTime = dateTime;
    }
    public void setTrainerId(int trainerId) {
        this.TrainerId = trainerId;
    }
    
    public void setDayOfTheWeekId(String dayOfTheWeek) {
        this.DayOfTheWeek = dayOfTheWeek;
    }
    
    public void setProgramId(int programId) {
        this.ProgramId = programId;
    }
    public void setTrainer(Trainers trainer) {
        this.Trainer = trainer;
    }
}
