package cvr.job.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static cvr.job.data.Const.DELTA;
import static org.junit.Assert.*;

public class CompanyTest {
    private Company company = null;//Company.getInstance();

    @Before
    public void setUp() throws Exception {
        company = Company.getInstance();
        new DummyData();

    }

    @Test
    public void addWorker() {
        int size = company.amountOfWorkers();
        company.addWorker(new Seller("newSeller", LocalDate.now(), null));
        company.addWorker(new Employee("newEmployee", LocalDate.now(), null));
        company.addWorker(new Manager("newManager", LocalDate.now(), null));
        assertEquals(size + 3, company.amountOfWorkers());
    }

    @Test
    public void removeWorker() {
        int size = company.amountOfWorkers();
        company.removeWorker(company.getWorker("man1"));
        assertEquals(size - 1, company.amountOfWorkers());
    }

    @Test
    public void amountOfWorkers() {
        assertEquals(15,company.amountOfWorkers());
    }

    @Test
    public void getPrise() {
        double ex = 15605.983;
        double prise = company.getPrise(LocalDate.of(2016, Month.JANUARY, 1));
        assertEquals(ex,prise,DELTA);
    }
}