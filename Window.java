package Clock;

import javax.swing.*;

public class Window extends JFrame {

    public Window(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(new Clock(600));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
