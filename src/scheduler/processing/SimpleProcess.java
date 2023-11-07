package scheduler.processing;

public abstract class SimpleProcess {
    protected int id;
    protected double time;
    public SimpleProcess(int id) {
        this.id = id;
    }
    public final int getId(){
        return this.id;
    }
    public double getTime(){
        return this.time;
    }
    @Override
    public String toString() {
        return "SimpleProcess{" + "id=" + id + '}';
    }
}
