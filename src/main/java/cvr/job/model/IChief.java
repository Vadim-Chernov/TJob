package cvr.job.model;

import java.util.ArrayList;
import java.util.List;

interface IChief extends INamed {
    List<Worker> getWorkers();

    default void addWorker(Worker worker) {
        getWorkers().add(worker);
    }

    default void removeWorker(Worker worker) {
        getWorkers().remove(worker);
    }
}
