package ch.noseryoung.blj;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

// "C:/Users/katig/Downloads/dedd157bf4f12c42966ed0f4e78dd1af 1.jpg"


public class Panels {

    public void writeImage() {

        BufferedImage image = null;
        try {
            File initialImage = new File("C:/Users/katig/Downloads/dedd157bf4f12c42966ed0f4e78dd1af 1.jpg");
            image = ImageIO.read(initialImage);

            Noiser noiser = new Noiser();
            noiser.createNoise(image);

            ImageIO.write(image, "jpg", new File("C:/Users/katig/Downloads/noised.jpg"));

        } catch (IOException e) {
            System.out.println("Exception occured :" + e.getMessage());
        }
        System.out.println("Images were written succesfully.");

    }
}
