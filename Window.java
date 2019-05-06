package Clock;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(SingleClock.getInstance(300), BorderLayout.EAST);
        getContentPane().add(SingleClock.getInstance(300), BorderLayout.WEST);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
