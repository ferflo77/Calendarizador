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
        this.size++;
        this.totalProcesses++;
        this.pila.add(p);
    }
    @Override
    public SimpleProcess next() {
        return this.pila.peek();
    }
    @Override
    public void remove() {
        this.size--;
        this.pila.removeLast();
    }
    public void attendProcesses() throws InterruptedException {
        if(!this.pila.isEmpty()){
            System.out.println("LCFS: Procesando Proceso con ID:" + this.next().getId());
            System.out.println("Procesando por: " + this.next().getTime() + "s");
            long milliseconds = (long) this.next().getTime() * 1000;
            Thread.sleep(milliseconds);
            System.out.println("LCFS: Fin Proceso con ID:" + this.next().getId());
            System.out.println("------------------------------------\n");
            System.out.println("No. Procesos en cola: " + this.size());
            System.out.println("Total procesos atendidos: " + this.totalProcesses());
            System.out.println("------------------------------------\n");
            this.remove();
        }
    }
}
