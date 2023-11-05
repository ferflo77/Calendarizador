package scheduler;

import scheduler.processing.*;
import scheduler.scheduling.policies.FirstComeFirstServe;
import scheduler.scheduling.policies.LastComeFirstServe;
import scheduler.scheduling.policies.Policy;
import scheduler.scheduling.policies.PriorityPolicy;

public class Processor {
    int id = 0;
    double timeArit;
    double timeIO;
    double timeCond;
    double timeLoop;
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

        while(true){
            double tEntradaProcesos = generator.generateRandomTime(init,end);
            System.out.println("Tiempo entrada procesos: " + tEntradaProcesos);
            long miliseconds = (long)tEntradaProcesos*1000;
            process(miliseconds);
            SimpleProcess process = generateProcess();
            policy.add(process);
        }
    }
    public SimpleProcess generateProcess(){
        int numProcess = generator.generateRandomProcess();
        System.out.println(numProcess);
        SimpleProcess sp;
        switch(numProcess){
            case 0:
                System.out.print("arithmetic");
                sp = new ArithmeticProcess(this.id, timeArit);
                break;
            case 1:
                System.out.print("io");
                sp = new IOProcess(this.id,timeIO);
                break;
            case 2:
                System.out.print("cond");
                sp = new ConditionalProcess(this.id, timeCond);
                break;
            case 3:
                System.out.print("loop");
                sp = new LoopProcess(this.id, timeLoop);
                break;
            default:
                sp = null;
        }
        ++this.id;
        return sp;
    }
}
