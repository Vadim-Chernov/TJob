package cvr.job.model;


import static cvr.job.data.Const.*;

import java.time.LocalDate;


public class Employee extends Worker {

    public Employee(String name, LocalDate enrollDate, IChief chief) {
        super(name, enrollDate, chief);
    }

    @Override
    double getPrise(LocalDate date) {
        if(date.isBefore(this.getEnrollDate()))
            return 0;

        int years = date.getYear() - this.getEnrollDate().getYear();
        double percent = years * EMPL_PERCENT;
        if (percent > EMPL_MAX)
            percent = EMPL_MAX;
        return (1 + percent) * BASE_PRISE;
    }
}