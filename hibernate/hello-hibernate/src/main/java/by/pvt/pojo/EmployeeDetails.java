package by.pvt.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 */
@Entity
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;

    @Column
    private String position;

    @Column
    private String privateNr;

    @OneToOne
    private Employee employee;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPrivateNr() {
        return privateNr;
    }

    public void setPrivateNr(String privateNr) {
        this.privateNr = privateNr;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
