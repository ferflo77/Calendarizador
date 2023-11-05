import scheduler.Processor;
import java.util.Scanner;

public class ProcessScheduler {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Ingrese politica");
        String politica = new Scanner(System.in).next();
        System.out.println("Ingrese rango tiempo separado por comas");
        String [] r = new Scanner(System.in).next().split(",");
        double init = Double.parseDouble(r[0]);
        double end = Double.parseDouble(r[1]);
        System.out.println("Ingrese tiempos de procesos separados por comas");
        String [] tiempos = new Scanner(System.in).next().split(",");;
        double arit = Double.parseDouble(tiempos[0]);
        double io = Double.parseDouble(tiempos[1]);
        double cond = Double.parseDouble(tiempos[2]);
        double loop = Double.parseDouble(tiempos[3]);
        double[] times = new double[4];
        times[0] = arit; times[1] = io; times[2] = cond; times[3] = loop;

        // Empezar la simulacion
        new Processor().startProcessing(politica,times,init,end);
    }
}