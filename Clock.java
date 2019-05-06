package Clock;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Date;

public class Clock extends JPanel {

    private final int SIZE;
    private Color background;
    private final int INDENT;
    private final double CENTER;
    private final double SECONDSIZE;
    private final double MINUTESIZE;
    private final double HOURSIZE;
    private final double RADIUS;
    private final Thread updater = new Thread(() -> {
        while (true){
            repaint();
            revalidate();
            synchronized (this) {
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    public Clock(int size){
        this.SIZE = size;
        INDENT = 5;
        CENTER = size/2.0;
        SECONDSIZE = 1;
        MINUTESIZE = 0.75;
        HOURSIZE = 0.5;
        background = Color.white;
        RADIUS = (CENTER-INDENT*2);
        setPreferredSize(new Dimension(size, size));
        setMaximumSize(new Dimension(size, size));
        setMinimumSize(new Dimension(size, size));
        updater.start();
    }

    public Clock(int size, Color background){
        this(size);
        this.background = background;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.translate((int)CENTER, (int)CENTER);
        Graphics2D graphics2D = (Graphics2D) g;
        Rectangle2D.Double backG = new Rectangle2D.Double(-CENTER, -CENTER, SIZE, SIZE);
        graphics2D.setColor(background);
        graphics2D.fill(backG);

        Ellipse2D.Double ellipse2D = new Ellipse2D.Double(INDENT - CENTER, INDENT - CENTER, SIZE - INDENT*2, SIZE - INDENT*2);
        graphics2D.setColor(Color.black);
        graphics2D.draw(ellipse2D);

        for(int i = 1; i <= 12; i++){
            double alpha = (2*Math.PI/12.0)*i - Math.PI/2;
            graphics2D.drawString(Integer.toString(i), (float)(SECONDSIZE*(RADIUS-5)*Math.cos(alpha))-INDENT, (float)(SECONDSIZE*(RADIUS-5)*Math.sin(alpha))+INDENT);
        }

        Date date = new Date();
        double alphaSecond = (2*Math.PI/60)*date.getSeconds() - Math.PI/2;
        Line2D.Double second = new Line2D.Double(0, 0, SECONDSIZE*RADIUS*Math.cos(alphaSecond), SECONDSIZE*RADIUS*Math.sin(alphaSecond));
        graphics2D.setColor(Color.BLUE);
        graphics2D.draw(second);

        double alphaMinute = (2*Math.PI/60)*date.getMinutes() - Math.PI/2;
        Line2D.Double minute = new Line2D.Double(0, 0, MINUTESIZE*RADIUS*Math.cos(alphaMinute), MINUTESIZE*RADIUS*Math.sin(alphaMinute));
        graphics2D.setColor(Color.RED);
        graphics2D.draw(minute);

        double alphaHour;
        if(date.getHours() > 12)
            alphaHour = (2*Math.PI/12.0)*(date.getHours() - 12) - Math.PI/2;
        else
            alphaHour = (2*Math.PI/12.0)*date.getHours() - Math.PI/2;
        Line2D.Double hour = new Line2D.Double(0, 0, HOURSIZE*RADIUS*Math.cos(alphaHour), HOURSIZE*RADIUS*Math.sin(alphaHour));
        graphics2D.setColor(Color.GREEN);
        graphics2D.draw(hour);
    }
}