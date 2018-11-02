package cvr.job.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static cvr.job.data.Const.*;

class Seller extends Worker implements IChief {

    public Seller(String name, LocalDate enrollDate, IChief chief) {
        super(name, enrollDate, chief);
    }

    @Override
    double getPrise(LocalDate date) {
        if(date.isBefore(this.getEnrollDate()))
            return 0;

        int years = date.getYear() - this.getEnrollDate().getYear();
        double percent = years * SAL_PERCENT;
        if (percent > SAL_MAX)
            percent = SAL_MAX;
        double premium = (1 + percent) * BASE_PRISE;

        double sum = getAllWorkers().stream().mapToDouble(e -> e.getPrise(date)).sum();
        return premium + sum * SAL_NESTED;
    }

    @Override
    public List<Worker> getWorkers() {
        return workers;
    }

    private boolean hasChildren(Worker worker) {
        if (worker instanceof Employee)
            return false;
        return ((IChief) worker).getWorkers().size() > 0;
    }

    private List<Worker> getChildren(List<Worker> workers) {
        List<Worker> ret = new ArrayList<>();
        for (Worker worker : workers) {
            if (hasChildren(worker))
                ret.addAll(getChildren(((IChief) worker).getWorkers()));
            ret.add(worker);
        }
        return ret;
    }

    public List<Worker> getAllWorkers() {
        return getChildren(((IChief) this).getWorkers());
    }

}
