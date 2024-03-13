import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class CSLineSegment extends JPanel {

    public void drawLine(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawLine(-20, 30, -30, 15);

        super.paint(g);
        drawLine(g);
    }
}
