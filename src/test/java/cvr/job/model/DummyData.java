package cvr.job.model;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class DummyData {
    private Manager man1, man2, man3;
    private Seller sel1, sel2, sel3, sel4, sel5, sel6;
    private Employee emp1, emp2, emp3, emp4, emp5, emp6;


    //    @Before
    public DummyData() {
        /* Дерево подчинения
            man1
                man2
                    sel1
                        sel4
                        emp2
                        emp3
                    sel2
                    emp4
                sel3
                man3
                    sel5
                    sel6
                emp1
                emp5
                emp6
         */
        man1 = new Manager("man1", LocalDate.of(2013, Month.JANUARY, 1), null);
        man2 = new Manager("man2", LocalDate.of(2014, Month.APRIL, 1), man1);
        man3 = new Manager("man3", LocalDate.of(2015, Month.DECEMBER, 1), man1);

        sel1 = new Seller("sel1", LocalDate.of(2015, Month.JANUARY, 1), man2);
        sel2 = new Seller("sel2", LocalDate.of(2015, Month.JANUARY, 1), man2);
        sel3 = new Seller("sel3", LocalDate.of(2015, Month.JANUARY, 1), man1);
        sel4 = new Seller("sel4", LocalDate.of(2015, Month.JANUARY, 1), sel1);
        sel5 = new Seller("sel5", LocalDate.of(2015, Month.JANUARY, 1), man3);
        sel6 = new Seller("sel6", LocalDate.of(2015, Month.JANUARY, 1), man3);


        emp1 = new Employee("emp1", LocalDate.of(2015, Month.JANUARY, 1), man1);
        emp2 = new Employee("emp2", LocalDate.of(2015, Month.JANUARY, 1), sel1);
        emp3 = new Employee("emp3", LocalDate.of(2015, Month.JANUARY, 1), sel1);
        emp4 = new Employee("emp4", LocalDate.of(2015, Month.JANUARY, 1), man2);
        emp5 = new Employee("emp5", LocalDate.of(2015, Month.JANUARY, 1), man1);
        emp6 = new Employee("emp6", LocalDate.of(2015, Month.JANUARY, 1), man1);

    }

    @Test
    public void structureTest() {
//        assertEquals(6, Repo.size());
        assertEquals("sel6", sel6.getName());
        assertEquals("man3", sel5.getChief().getName());
        String name1 = man1.getName();
        String name2 = man2.getName();
        int size1 = man1.getWorkers().size();
        int size2 = man2.getWorkers().size();
        assertEquals(6, size1);
        assertEquals(3, size2);
    }
}