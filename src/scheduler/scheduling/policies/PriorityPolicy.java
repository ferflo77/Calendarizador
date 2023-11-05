package scheduler.scheduling.policies;

import scheduler.processing.SimpleProcess;

import java.util.LinkedList;

public class PriorityPolicy extends Policy implements Enqueable{
    private LinkedList<SimpleProcess> lista;
    public PriorityPolicy() {
        this.lista = new LinkedList<>();
    }
    @Override
    public void add(SimpleProcess p) {
        this.lista.add(p);
    }
    @Override
    public SimpleProcess next() {
        return null;
    }
    @Override
    public void remove() {

    }
}
