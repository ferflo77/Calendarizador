package scheduler.scheduling.policies;

import scheduler.processing.SimpleProcess;

public abstract class Policy {
    protected int size;
    protected int totalProcesses;
    public Policy() {
        this.size = 0;
        this.totalProcesses = 0;
    }
    public void add(SimpleProcess p) {}
    //Devuelve la cantidad de procesos activos en la cola de la politica
    public final int size(){
        return size;
    }
    //Devuelve el total de procesos ingresados a la cola de la politica
    public final int totalProcesses(){
        return totalProcesses;
    }
    public void attendProcesses() throws InterruptedException{}
}
