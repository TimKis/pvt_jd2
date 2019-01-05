package by.pvt.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 */
public class FilterPerson {

    private PersonImpl person;
    private List<PersonImpl> persons;
    private String property;

    public PersonImpl getPerson() {
        return person;
    }

    public void setPerson(PersonImpl person) {
        this.person = person;
    }

    public List<PersonImpl> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonImpl> persons) {
        this.persons = persons;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
