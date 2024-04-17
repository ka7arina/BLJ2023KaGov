package ch.noseryoung.blj;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Noiser {

    public void createNoise(BufferedImage image) {

        Random random = new Random();

        int noise = 40 / 15;

        int width = image.getWidth ();
        int height = image.getHeight ();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(image.getRGB(x, y));
                int redVal = color.getRed();
                int greenVal = color.getGreen();
                int blueVal = color.getBlue();

                // Generate a single noise value for all three color channels
                int noiseValue = (int) ((random.nextInt(511) - 255) * noise);

                // Apply the same noise value to all three channels
                int newRed = Math.max(0, Math.min(255, redVal + noiseValue));
                int newGreen = Math.max(0, Math.min(255, greenVal + noiseValue));
                int newBlue = Math.max(0, Math.min(255, blueVal + noiseValue));

                Color newColor = new Color(newRed, newGreen, newBlue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }

    }
}
