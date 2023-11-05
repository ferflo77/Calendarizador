package scheduler.processing;

public class ConditionalProcess extends SimpleProcess{
    private int id;
    private double time;
    public ConditionalProcess(int id, double time) {
        super(id);
        this.time = time;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
}
