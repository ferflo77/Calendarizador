package scheduler.scheduling.policies;

import scheduler.processing.SimpleProcess;

import java.util.Stack;

public class LastComeFirstServe extends Policy implements Enqueable{
    private Stack<SimpleProcess> pila;
    public LastComeFirstServe() {
        this.pila = new Stack<>();
    }
    @Override
    public void add(SimpleProcess p) {
        this.pila.add(p);
    }
    @Override
    public SimpleProcess next() {
        return null;
    }
    @Override
    public void remove() {

    }
}
