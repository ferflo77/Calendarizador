package scheduler;

import java.util.Random;

public class Generator {
    public int generateRandomProcess(){
        return new Random().nextInt(3);
    }
    public double generateRandomTime(double init, double end){
        return new Random().nextDouble(init,end);
    }
}
