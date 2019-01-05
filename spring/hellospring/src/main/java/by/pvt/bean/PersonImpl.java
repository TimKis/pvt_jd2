package by.pvt.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 *
 */
public class PersonImpl implements InitializingBean, BeanNameAware, DisposableBean {

    private long id;
    private String name;
    private String secondName;
    private Address address;
    private String fullAddress;

    public PersonImpl(String name, String secondName, Address address) {
        this.name = name;
        this.secondName = secondName;
        this.address = address;
    }

    public PersonImpl() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        System.out.println("Call getName()");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    void init() {
        System.out.println("Init bean " + getClass().getName());
    }

    public void destroy() {
        System.out.println("Destroy bean " + getClass().getName());
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Call afterPropertiesSet()");
    }

    public void setBeanName(String s) {
        System.out.println("Call setBeanName() name=" + s);
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    @Override
    public String toString() {
        return "Person name="+ "[" +getName() + "]" + super.toString();
    }
}
