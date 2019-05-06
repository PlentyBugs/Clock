package Clock;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 0;
        constraints.gridy = 0;

        for(int i = 1; i <= 10; i++) {
            getContentPane().add(new Clock(i * 20), constraints);
            constraints.gridx = i%5;
            constraints.gridy = i/5;
        }
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
