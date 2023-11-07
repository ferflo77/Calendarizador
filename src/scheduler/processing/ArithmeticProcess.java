package scheduler.processing;

public class ArithmeticProcess extends SimpleProcess{
    private int id;
    private double time;
    public ArithmeticProcess(int id, double time) {
        super(id);
        this.time = time;
    }
    public double getTime() {
        return time;
    }
}
