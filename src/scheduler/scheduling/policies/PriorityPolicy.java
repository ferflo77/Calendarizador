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
        return this.lista.peek();
    }
    @Override
    public void remove() {
        this.lista.remove();
    }

    public void attendProcesses() throws InterruptedException {
        if(!this.lista.isEmpty()){
            System.out.println("PP: Procesando Proceso con ID:" + this.next().getId());
            Thread.sleep((long)this.next().getTime());
            System.out.println("PP: Fin Proceso con ID:" + this.next().getId());
        }
    }
}
