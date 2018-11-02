package cvr.job.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static cvr.job.data.Const.*;

public class Manager extends Worker implements IChief {

    public Manager(String name, LocalDate enrollDate, IChief chief) {
        super(name, enrollDate, chief);
    }


    @Override
    double getPrise(LocalDate date) {
        if(date.isBefore(this.getEnrollDate()))
            return 0;

        int years = date.getYear() - this.getEnrollDate().getYear();
        double percent = years * MAN_PERCENT;
        if (percent > MAN_MAX)
            percent = MAN_MAX;
        double premium = (1 + percent) * BASE_PRISE;

        double sum = getWorkers().stream().mapToDouble(e -> e.getPrise(date)).sum();
        return premium + sum * MAN_NESTED;
    }

    @Override
    public List<Worker> getWorkers() {
        return super.workers;
    }

}