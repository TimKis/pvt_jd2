package by.pvt.pojo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 */
@Entity
@DiscriminatorValue("w")
public class Worker extends Person {

    @Column
    private String companyName;

    @Column
    private String position;

    @Column
    private BigDecimal salary;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + " salary=" + salary;
    }
}
