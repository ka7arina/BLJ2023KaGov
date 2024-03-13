import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class CSLineSegment extends JPanel {

    public void drawLine(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawLine(40, 70, 40, 70);

        super.paintComponent(g);
        drawLine(g);
    }
}
