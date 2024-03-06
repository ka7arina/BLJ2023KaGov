import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.awt.Image;

public class PicGetter {

    public static void getCatPic() {

        Image image = null;
        try {
            URL url = new URL("https://cataas.com/cat/says/:text?fontSize=:size&fontColor=:color");
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);
    }

    }

