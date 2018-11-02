package cvr.job.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Company {
    private static Company instance;
    private Map<String, Worker> workers;

    public Worker getWorker(String name) {
        return workers.get(name);
    }

    public void addWorker(Worker worker) {
        workers.put(worker.getName(), worker);
    }

    public void removeWorker(Worker worker) {
        workers.remove(worker.getName());
    }

    public int amountOfWorkers() {
        return workers.size();
    }

    public double getPrise(LocalDate date) {
        double sum = workers.values().parallelStream().mapToDouble(e -> e.getPrise(date)).sum();
        return sum;
    }

    public void removeAll() {
        workers.clear();
        workers = null;
    }

    private Company() {
        workers = new HashMap<>();
    }

    public static Company getInstance() {
        if (instance == null)
            instance = new Company();
        return instance;
    }
}
