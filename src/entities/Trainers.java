/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author User
 */
public class Trainers {
    private int Id;
    private String Name;
    private String Surname;
    private String PhoneNumber;
    
    @Id
    @Column(name = "TrainerId")
    public int getId() {
        return Id;
    }
    public String getName() {
        return Name;
    }
    public String getSurname() {
        return Surname;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    
    public void setId(int id) {
        this.Id = id;
    }
    public void setName(String name) {
        this.Name = name;
    }
    public void setSurname(String surname) {
        this.Surname = surname;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }
}
