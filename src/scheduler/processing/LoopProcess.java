package scheduler.processing;

public class LoopProcess extends SimpleProcess{
    private int id;
    private double time;
    public LoopProcess(int id, double time) {
        super(id);
        this.time = time;
    }
    public double getTime() {
        return time;
    }
}
