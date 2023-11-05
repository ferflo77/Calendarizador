package scheduler.processing;

public abstract class SimpleProcess {
    protected int id;
    public SimpleProcess(int id) {
        this.id = id;
    }
    public final int getId(){
        return this.id;
    }
    @Override
    public String toString() {
        return "SimpleProcess{" + "id=" + id + '}';
    }
}
