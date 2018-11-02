package cvr.job.model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void getPrise() {
        Employee emp = new Employee("Ivanov", LocalDate.of(2000, 1, 1), null);
        assertEquals(1000,emp.getPrise(LocalDate.of(2000, 6, 4)),0.0001);
        assertEquals(1030,emp.getPrise(LocalDate.of(2001, 6, 4)),0.0001);
        assertEquals(1210,emp.getPrise(LocalDate.of(2007, 6, 4)),0.0001);
        assertEquals(1300,emp.getPrise(LocalDate.of(2010, 6, 4)),0.0001);
        assertEquals(1300,emp.getPrise(LocalDate.of(2015, 6, 4)),0.0001);

    }
}