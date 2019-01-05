package by.pvt.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.pvt.bean.AddressImpl;
import by.pvt.bean.FilterPerson;
import by.pvt.bean.Inhabitant;
import by.pvt.bean.Manager;
import by.pvt.bean.PersonImpl;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-config.xml");

        PersonImpl person = (PersonImpl) applicationContext.getBean("person");

        AddressImpl address = (AddressImpl) applicationContext.getBean("address");

        System.out.println(person.getAddress().getCity()
                + " " + person.getAddress().getStreet());

        String name = person.getName();

        System.out.println(name + " " + person.getSecondName());

        //System.out.println("Flats:" + ((AddressImpl)person.getAddress()).getFlats());
        //System.out.println("Flats type:" + ((AddressImpl)person.getAddress()).getFlats().get(0).getClass().getName());

        //System.out.println("Map: " + ((AddressImpl)person.getAddress()).getCoordinates());

        System.out.println("Home: " + ((AddressImpl) person.getAddress()).getHome());

        System.out.println("Street: " + ((AddressImpl) person.getAddress()).getStreet());

        System.out.println("Person full address: " + person.getFullAddress() + " " +
                ((AddressImpl) person.getAddress()).getZipCode());

        System.out.println("Address isEndOfStreet=" + address.isEndOfStreet());

        System.out.println("Street=" + address.getStreet()
                + " The same street=" + address.isTheSameStreet());

        Inhabitant inhabitant = (Inhabitant) applicationContext.getBean("inhabitant");
        for (PersonImpl p:inhabitant.getPersons()) {
            System.out.println("Name=" + p.getName() + " " + p.getSecondName());
        }

        System.out.println("Inhabitants: " + address.getIhabitants());

        Manager manager = (Manager)applicationContext.getBean("manager");
        System.out.println("Manager: " + manager.getName() + " "
                + manager.getSecondName() + " "
        + manager.getPerson().getFullAddress());

        FilterPerson filterPerson = (FilterPerson) applicationContext.getBean("filter");
        System.out.println("Filter: person=" + filterPerson.getPerson() +
                " persons=" + filterPerson.getPersons() +
                " property=" + filterPerson.getProperty());

        applicationContext.close();

    }
}
