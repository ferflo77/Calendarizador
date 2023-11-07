package scheduler;

import java.text.DecimalFormat;
import java.util.Random;
public class Generator {
    public int generateRandomProcess(){
        return new Random().nextInt(3);
    }
    public double generateRandomTime(double init, double end){
        return oneDecimalDouble(new Random().nextDouble(init,end));
    }
    public double oneDecimalDouble(double num){
        DecimalFormat df = new DecimalFormat("#.#");
        return Double.parseDouble(df.format(num));
    }
}
