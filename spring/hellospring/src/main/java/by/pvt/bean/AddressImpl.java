package by.pvt.bean;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

/**
 *
 */
public class AddressImpl implements Address {

    private List flats;

    private Map coordinates;

    private Float home;

    private String street;

    private String zipCode;

    private boolean endOfStreet;

    private boolean theSameStreet;

    private Collection<String> ihabitants;

    public AddressImpl(Float home) {
        this.home = home;
    }

    public String getStreet() {
        return street != null ? street : "Строителей";
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return "Stambul";
    }

    public List getFlats() {
        return flats;
    }

    public void setFlats(List flats) {
        this.flats = flats;
    }

    public Map getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Map coordinates) {
        this.coordinates = coordinates;
    }

    public Float getHome() {
        return home != null ? home : 25;
    }

    public void setHome(Float home) {
        this.home = home;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isEndOfStreet() {
        return endOfStreet;
    }

    public void setEndOfStreet(boolean endOfStreet) {
        this.endOfStreet = endOfStreet;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Call post construct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Call pre destroy");
    }

    public boolean isTheSameStreet() {
        return theSameStreet;
    }

    public void setTheSameStreet(boolean theSameStreet) {
        this.theSameStreet = theSameStreet;
    }

    public Collection<String> getIhabitants() {
        return ihabitants;
    }

    public void setIhabitants(Collection<String> ihabitants) {
        this.ihabitants = ihabitants;
    }
}
