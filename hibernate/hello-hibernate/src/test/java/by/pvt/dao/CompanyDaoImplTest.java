package by.pvt.dao;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runners.*;

import by.pvt.pojo.Address;
import by.pvt.pojo.Company;

/**
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompanyDaoImplTest {

    DaoImpl<Company> companyDao;

    @Before
    public void setUp() {
        companyDao = new DaoImpl<>(Company.class);
        DaoImpl.isTestInstance = true;
    }

    @Test
    public void step1_saveOrUpdate() {
        Company company = new Company();
        company.setCompanyName("Romashka");
        company.setSiteUrl("www.romashka.by");

        company.setHomeAddress(
                new Address("Minsk", "Kamennaya Gorka", "2B", 101)
        );

        company.setLegalAddress(
                new Address("Minsk", "Ploscha Svabody", "1", 10)
        );

        Company company2 = companyDao.saveOrUpdate(company);
        assertNotNull(company2);
        assertEquals(company2, company);
        assertEquals(company2.getLegalAddress(), company.getLegalAddress());

        System.out.printf("Company ID: " + company2.getId());
    }

    @Test
    public void step2_updateAddress() {
        Company company = companyDao.load(1L);
        company.getHomeAddress().setCity("Vitebsk");
        companyDao.saveOrUpdate(company);

        assertEquals("Vitebsk", company.getHomeAddress().getCity());
    }

    @Test
    public void step3_delete() {
        companyDao.delete(companyDao.load(1L).getId());
        assertNull(companyDao.find(1L));
    }


    public void tearDown() {
        DaoImpl.isTestInstance = false;
        companyDao = null;
    }

}
