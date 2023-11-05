package scheduler.scheduling.policies;

import scheduler.processing.SimpleProcess;

public interface Enqueable {
    public void add(SimpleProcess p);
    public SimpleProcess next();
    public void remove();
}
