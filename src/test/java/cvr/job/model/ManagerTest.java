package cvr.job.model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static cvr.job.data.Const.DELTA;
import static org.junit.Assert.assertEquals;

public class ManagerTest {
    DummyData data = new DummyData();
    Company company = Company.getInstance();
    private Manager man1, man2, man3;
    private Seller sel1, sel2, sel3, sel4, sel5, sel6;
    private Employee emp1, emp2, emp3, emp4, emp5, emp6;

    @Before
    public void init() {
        man1 = (Manager) company.getWorker("man1");
        man2 = (Manager) company.getWorker("man2");
        man3 = (Manager) company.getWorker("man3");

        sel1 = (Seller) company.getWorker("sel1");
        sel2 = (Seller) company.getWorker("sel2");
        sel3 = (Seller) company.getWorker("sel3");
        sel4 = (Seller) company.getWorker("sel4");
        sel5 = (Seller) company.getWorker("sel5");
        sel6 = (Seller) company.getWorker("sel6");

        emp1 = (Employee) company.getWorker("emp1");
        emp2 = (Employee) company.getWorker("emp2");
        emp3 = (Employee) company.getWorker("emp3");
        emp4 = (Employee) company.getWorker("emp4");
        emp5 = (Employee) company.getWorker("emp5");
        emp6 = (Employee) company.getWorker("emp6");
    }


    @Test
    public void getPrise() {
        double ex1 = 1181.37698;
        double prise1 = man1.getPrise(LocalDate.of(2016, 1, 1));
        assertEquals(ex1, prise1, DELTA);

        double ex2 = 1115.29605;
        double prise2 = man2.getPrise(LocalDate.of(2016, 1, 1));
        assertEquals(ex2, prise2, DELTA);

        double ex3 = 1060.1;
        double prise3 = man3.getPrise(LocalDate.of(2016, 1, 1));
        assertEquals(ex3, prise3, DELTA);

    }

    @Test
    public void getWorkers() {
        assertEquals(6, man1.getWorkers().size());
        assertEquals(3, man2.getWorkers().size());
        assertEquals(2, man3.getWorkers().size());

    }
}