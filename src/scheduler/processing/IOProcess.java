package scheduler.processing;

public class IOProcess extends SimpleProcess{
    private int id;
    private double time;
    public IOProcess(int id, double time) {
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
