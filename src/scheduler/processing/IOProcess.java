package scheduler.processing;

public class IOProcess extends SimpleProcess{
    private int id;
    private double time;
    public IOProcess(int id, double time) {
        super(id);
        this.time = time;
    }
    public double getTime() {
        return time;
    }
}
