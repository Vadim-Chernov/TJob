package cvr.job.model;

//import cvr.job.data.Repo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkerTest {
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
    public void setChief() {
        String name1 = man1.getName();
        String name2 = man2.getName();
        int size1 = man1.getWorkers().size();
        int size2 = man2.getWorkers().size();

        assertEquals("man1", emp1.getChief().getName());
        emp1.setChief(man2);
        assertEquals("man2", emp1.getChief().getName());

        assertEquals(size1 - 1, man1.getWorkers().size());
        assertEquals(size2 + 1, man2.getWorkers().size());

    }

    @Test
    public void getAllWorkersTest() {
        assertEquals(3, sel1.getAllWorkers().size());
        assertEquals(3, sel1.getAllWorkers().size());
        assertEquals(0, sel5.getAllWorkers().size());

    }

    @Test
    public void getWorkersTest() {
        assertEquals(6, man1.getWorkers().size());
        assertEquals(3, man2.getWorkers().size());
        assertEquals(2, man3.getWorkers().size());
        assertEquals(3, sel1.getWorkers().size());
        assertEquals(0, sel5.getWorkers().size());
    }
}