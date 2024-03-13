import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class CSLineSegment extends JPanel {

    public void drawLine(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawLine(120, 50, 360, 50);

        super.paint(g);
        drawLine(g);
    }
}
