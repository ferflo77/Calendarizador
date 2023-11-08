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
        this.size++;
        this.totalProcesses++;
        this.cola.add(p);
    }
    @Override
    public SimpleProcess next() {
        return this.cola.peek();
    }
    @Override
    public void remove() {
        this.size--;
        this.cola.remove();
    }
    public void attendProcesses() throws InterruptedException {
        if(!this.cola.isEmpty()){
            System.out.println("FCFS: Procesando Proceso con ID:" + this.next().getId());
            System.out.println("Procesando por: " + this.next().getTime() + "s");
            long milliseconds = (long) this.next().getTime() * 1000;
            Thread.sleep(milliseconds);
            System.out.println("FCFS: Fin Proceso con ID:" + this.next().getId());
            System.out.println("------------------------------------\n");
            System.out.println("No. Procesos en cola: " + this.size());
            System.out.println("Total procesos atendidos: " + this.totalProcesses());
            System.out.println("------------------------------------\n");
            this.remove();
        }
    }
}
