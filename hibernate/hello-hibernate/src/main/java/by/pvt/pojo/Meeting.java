package by.pvt.pojo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 *
 */
@Entity
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String subject;

    @OneToOne
    private Employee organizer;

    @ManyToMany(mappedBy = "meetings")
    private Set<Employee> attendees;

    @Column
    private Date dateTime;

    @Column
    private Status status;

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Employee getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Employee organizer) {
        this.organizer = organizer;
    }

    public Set getAttendees() {
        return attendees;
    }

    public void setAttendees(Set attendees) {
        this.attendees = attendees;
    }
}
