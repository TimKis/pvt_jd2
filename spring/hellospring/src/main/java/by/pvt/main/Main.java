package by.pvt.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.pvt.bean.PersonImpl;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-config.xml");

        PersonImpl person = (PersonImpl) applicationContext.getBean("person");

        System.out.println(person.getAddress().getCity()
                + " " + person.getAddress().getStreet());

        String name = person.getName();

        System.out.println(name + " " + person.getSecondName());

    }
}
