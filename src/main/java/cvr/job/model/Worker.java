package cvr.job.model;

import javax.annotation.PreDestroy;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Worker implements INamed {

    protected List<Worker> workers = new ArrayList<>();
    private Company company = Company.getInstance();

    private String name;
    private LocalDate enrollDate;
    private IChief chief;


    public Worker(String name, LocalDate enrollDate, IChief chief) {
        this.name = name;
        this.enrollDate = enrollDate;
        setChief(chief);
        company.addWorker(this);
    }

    @PreDestroy
    public void autoClear() {
        company.removeWorker(this);
    }

    abstract double getPrise(LocalDate date);

    public String getName() {
        return name;
    }

    public LocalDate getEnrollDate() {
        return enrollDate;
    }

    public IChief getChief() {
        return chief;
    }

    public void setChief(IChief _chief) {
        if (chief != null)
            chief.removeWorker(this);
        chief = _chief;
        if (chief != null)
            chief.addWorker(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
