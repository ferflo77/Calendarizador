package scheduler.scheduling.policies;

import scheduler.processing.SimpleProcess;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class PriorityPolicy extends Policy implements Enqueable{
    private List<SimpleProcess> lista;
    public PriorityPolicy() {
        this.lista = Collections.synchronizedList(new LinkedList<>());
    }
    @Override
    public void add(SimpleProcess p) {
        this.size++;
        this.totalProcesses++;
        this.lista.add(p);
    }
    @Override
    public SimpleProcess next() {
        return this.lista.getFirst();
    }
    @Override
    public void remove() {
        this.size--;
        this.lista.removeFirst();
    }
    public void attendProcesses() throws InterruptedException {
        if(!this.lista.isEmpty()){
            System.out.println("PP: Procesando Proceso con ID:" + this.next().getId());
            System.out.println("Procesando por: " + this.next().getTime() + "s");
            long milliseconds = (long) this.next().getTime() * 1000;
            Thread.sleep(milliseconds);
            System.out.println("PP: Fin Proceso con ID:" + this.next().getId());
            System.out.println("------------------------------------\n");
            System.out.println("No. Procesos en cola: " + this.size());
            System.out.println("Total procesos atendidos: " + this.totalProcesses());
            System.out.println("------------------------------------\n");
            this.remove();
        }
    }
}
