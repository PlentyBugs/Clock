package Clock;

import java.awt.*;

public class SingleClock extends Clock {

    private static SingleClock clock;

    public SingleClock(int size) {
        super(size);
    }

    public SingleClock(int size, Color color) {
        super(size, color);
    }

    public static SingleClock getInstance(int size){
        if (clock == null)
            clock = new SingleClock(size);
        return clock;
    }


    public static SingleClock getInstance(int size, Color color){
        if (clock == null)
            clock = new SingleClock(size, color);
        return clock;
    }
}
