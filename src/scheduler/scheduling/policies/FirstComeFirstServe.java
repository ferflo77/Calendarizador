package scheduler.scheduling.policies;

import scheduler.processing.SimpleProcess;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FirstComeFirstServe extends Policy implements Enqueable{
    private ConcurrentLinkedQueue<SimpleProcess> cola;
    public FirstComeFirstServe() {
        this.cola = new ConcurrentLinkedQueue<>();
    }
    @Override
    public void add(SimpleProcess p) {
        this.cola.add(p);
    }
    @Override
    public SimpleProcess next() {
        return null;
    }
    @Override
    public void remove() {

    }
}
