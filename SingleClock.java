package Clock;

import java.awt.*;

public class SingleClock extends Clock {

    private static SingleClock clock;

    private SingleClock(int size) {
        super(size);
    }

    private SingleClock(int size, Color color) {
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
