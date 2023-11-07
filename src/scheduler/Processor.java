package scheduler;

import scheduler.processing.*;
import scheduler.scheduling.policies.FirstComeFirstServe;
import scheduler.scheduling.policies.LastComeFirstServe;
import scheduler.scheduling.policies.Policy;
import scheduler.scheduling.policies.PriorityPolicy;
public class Processor {
    int id = 0;
    double timeArit; double timeIO; double timeCond; double timeLoop;
    Generator generator;
    Policy policy;
    public Processor() {
        this.generator = new Generator();
    }
    public void process(long time) throws InterruptedException {
        Thread.sleep(time);
    }
    public void startProcessing(String politica, double [] times, double init, double end) throws InterruptedException {
        this.timeArit = times[0];
        this.timeIO = times[1];
        this.timeCond= times[2];
        this.timeLoop = times[3];

        switch (politica) {
            case "fcfs":
                System.out.println("Usando politica FCFS");
                policy = new FirstComeFirstServe();
                break;
            case "lcfs":
                System.out.println("Usando politica LCFS");
                policy = new LastComeFirstServe();
                break;
            case "pp":
                System.out.println("Usando politica PP");
                policy = new PriorityPolicy();
                break;
            default:
                System.out.println("Ingrese una politica correcta: fcfs,lcfs,pp");
        }
            Thread thread1 = new Thread() {
                public void run() {
                    // Thread 1
                    while(true) {
                        double tEntradaProcesos = generator.generateRandomTime(init, end);
                        System.out.println("Tiempo entrada procesos: " + tEntradaProcesos + "s");
                        long milliseconds = (long) tEntradaProcesos * 1000;
                        try {
                            process(milliseconds);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        SimpleProcess process = generateProcess();
                        policy.add(process);
                    }
                }
            };
            Thread thread2 = new Thread() {
                public void run() {
                    // Thread 2
                    while(true) {
                        try {
                            policy.attendProcesses();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            };
            thread1.start();
            thread2.start();
    }
    public SimpleProcess generateProcess(){
        int numProcess = generator.generateRandomProcess();
        SimpleProcess sp;
        switch(numProcess){
            case 0:
                System.out.print("Tipo proceso: A\n");
                sp = new ArithmeticProcess(this.id, timeArit);
                break;
            case 1:
                System.out.print("Tipo Proceso: IO\n");
                sp = new IOProcess(this.id,timeIO);
                break;
            case 2:
                System.out.print("Tipo proceso C:\n");
                sp = new ConditionalProcess(this.id, timeCond);
                break;
            case 3:
                System.out.print("Tipo proceso L:\n");
                sp = new LoopProcess(this.id, timeLoop);
                break;
            default:
                sp = null;
        }
        ++this.id;
        return sp;
    }
}