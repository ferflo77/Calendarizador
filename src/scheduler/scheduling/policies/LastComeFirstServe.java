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
        return this.pila.peek();
    }
    @Override
    public void remove() {
        this.pila.removeLast();
    }

    public void attendProcesses() throws InterruptedException {
        if(!this.pila.isEmpty()){
            System.out.println("LCFS: Procesando Proceso con ID:" + this.next().getId());
            Thread.sleep((long)this.next().getTime());
            System.out.println("LCFS: Fin Proceso con ID:" + this.next().getId());
        }
    }
}
