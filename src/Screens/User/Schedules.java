/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "schedules", catalog = "gymfit", schema = "")
@NamedQueries({
    @NamedQuery(name = "Schedules.findAll", query = "SELECT s FROM Schedules s")
    , @NamedQuery(name = "Schedules.findById", query = "SELECT s FROM Schedules s WHERE s.id = :id")
    , @NamedQuery(name = "Schedules.findByDateTime", query = "SELECT s FROM Schedules s WHERE s.dateTime = :dateTime")
    , @NamedQuery(name = "Schedules.findByTrainerId", query = "SELECT s FROM Schedules s WHERE s.trainerId = :trainerId")
    , @NamedQuery(name = "Schedules.findByDayOfTheWeek", query = "SELECT s FROM Schedules s WHERE s.dayOfTheWeek = :dayOfTheWeek")
    , @NamedQuery(name = "Schedules.findByProgramId", query = "SELECT s FROM Schedules s WHERE s.programId = :programId")})
public class Schedules implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @Basic(optional = false)
    @Column(name = "TrainerId")
    private int trainerId;
    @Basic(optional = false)
    @Column(name = "DayOfTheWeek")
    private String dayOfTheWeek;
    @Basic(optional = false)
    @Column(name = "ProgramId")
    private int programId;

    public Schedules() {
    }

    public Schedules(Integer id) {
        this.id = id;
    }

    public Schedules(Integer id, Date dateTime, int trainerId, String dayOfTheWeek, int programId) {
        this.id = id;
        this.dateTime = dateTime;
        this.trainerId = trainerId;
        this.dayOfTheWeek = dayOfTheWeek;
        this.programId = programId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        Date oldDateTime = this.dateTime;
        this.dateTime = dateTime;
        changeSupport.firePropertyChange("dateTime", oldDateTime, dateTime);
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        int oldTrainerId = this.trainerId;
        this.trainerId = trainerId;
        changeSupport.firePropertyChange("trainerId", oldTrainerId, trainerId);
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        String oldDayOfTheWeek = this.dayOfTheWeek;
        this.dayOfTheWeek = dayOfTheWeek;
        changeSupport.firePropertyChange("dayOfTheWeek", oldDayOfTheWeek, dayOfTheWeek);
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        int oldProgramId = this.programId;
        this.programId = programId;
        changeSupport.firePropertyChange("programId", oldProgramId, programId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedules)) {
            return false;
        }
        Schedules other = (Schedules) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Screens.User.Schedules[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
