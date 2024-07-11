package ch.noseryoung.logic;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.List;
import java.util.Map;

public class GameIO extends JFrame {
    private Game game;
    private BufferedImage displayArea;
    private BufferedImage blueBoxImage;
    private BufferedImage blackBoxImage;
    private BufferedImage turqouiseBoxImage;
    private BufferedImage groundImage;
    private BufferedImage greenBoxImage;
    private BufferedImage playerImage;
    private int scale;
    private double cellMargin;

    private final Map<Integer, Runnable> inputMap;
    private final List<Color> colorList;

    private JPanel topPanel;
    private JLabel displayLabel;

    public GameIO(Game game, int scale, double cellMargin) {
        this.game = game;
        this.scale = scale;
        this.cellMargin = cellMargin;

        inputMap = Map.of(KeyEvent.VK_UP, game::moveUp, KeyEvent.VK_DOWN, game::moveDown,
                KeyEvent.VK_LEFT, game::moveLeft, KeyEvent.VK_RIGHT, game::moveRight, KeyEvent.VK_ESCAPE,
                game::resetField);
        colorList = List.of(Color.LIGHT_GRAY, Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.CYAN);

        loadImages();
        initInput();
        initOutput();
        updateOutput();
    }

    private void loadImages() {
        try {
            blueBoxImage = ImageIO.read(new File("C:/Projects/BLJ2023KaGov/Java/2024/KW23/Sokoban/ch/noseryoung/images/pop.png"));
            blackBoxImage = ImageIO.read(new File("C:/Projects/BLJ2023KaGov/Java/2024/KW23/Sokoban/ch/noseryoung/images/bricks.png"));
            greenBoxImage = ImageIO.read(new File("C:/Projects/BLJ2023KaGov/Java/2024/KW23/Sokoban/ch/noseryoung/images/zari.png"));
            groundImage = ImageIO.read(new File("C:/Projects/BLJ2023KaGov/Java/2024/KW23/Sokoban/ch/noseryoung/images/ground.png"));
            turqouiseBoxImage = ImageIO.read(new File("C:/Projects/BLJ2023KaGov/Java/2024/KW23/Sokoban/ch/noseryoung/images/ma-ri-na.png"));
            playerImage = ImageIO.read(new File("C:/Projects/BLJ2023KaGov/Java/2024/KW23/Sokoban/ch/noseryoung/images/doitmyway.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initOutput() {
        displayArea = new BufferedImage(game.getRowCount() * scale, game.getColCount() * scale,
                BufferedImage.TYPE_INT_ARGB);

        // Create a panel to hold the button and display area
        topPanel = new JPanel(new BorderLayout());

        // Create a button
        JButton button = new JButton("Next Level");

        // Add an ActionListener to the button to switch levels
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchLevel();
                // Request focus on the JFrame after switching levels
                GameIO.this.requestFocusInWindow();
            }
        });

        // Add the button to the top of the panel
        topPanel.add(button, BorderLayout.NORTH);

        // Add the display area to the center of the panel
        displayLabel = new JLabel(new ImageIcon(displayArea));
        topPanel.add(displayLabel, BorderLayout.CENTER);

        this.getContentPane().add(topPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Marina Satti Sokoban \uD83C\uDDEC\uD83C\uDDF7");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // Ensure focus on the JFrame
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    private void initInput() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (inputMap.containsKey(e.getKeyCode())) {
                    inputMap.get(e.getKeyCode()).run();
                    updateOutput();
                }
            }
        });

        // Ensure focus on the component that should capture key events
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    private void updateOutput() {
        Graphics2D g2d = (Graphics2D) displayArea.getGraphics();
        g2d.setStroke(new BasicStroke((float) (scale * cellMargin)));
        for (int x = 0; x < game.getRowCount(); x++) {
            for (int y = 0; y < game.getColCount(); y++) {
                int scaledX = x * scale;
                int scaledY = y * scale;
                int cellValue = game.getField()[y][x];

                if (cellValue == 3) {
                    // Draw the blue box image
                    g2d.drawImage(blueBoxImage, scaledX, scaledY, scale, scale, null);
                } else if (cellValue == 1) {
                    // Draw the black box image
                    g2d.drawImage(blackBoxImage, scaledX, scaledY, scale, scale, null);
                } else if (cellValue == 5) {
                    g2d.drawImage(turqouiseBoxImage, scaledX, scaledY, scale, scale, null);
                } else if (cellValue == 4) {
                    g2d.drawImage(greenBoxImage, scaledX, scaledY, scale, scale, null);
                } else if (cellValue == 0) {
                    g2d.drawImage(groundImage, scaledX, scaledY, scale, scale, null);
                } else if (cellValue == 2) {
                    g2d.drawImage(playerImage, scaledX, scaledY, scale, scale, null);
                } else {
                    // Draw the color for other cells
                    g2d.setColor(colorList.get(cellValue));
                    g2d.fillRect(scaledX, scaledY, scale, scale);
                }
            }
        }
        repaint();
    }

    // Method to switch to the next level

    private void switchLevel() {
        // Define a new game field for the next level
        int[][] newGameField = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 1, 4, 4, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {0, 1, 4, 4, 0, 0, 1, 0, 3, 0, 0, 3, 0, 0, 1, 0},
                {0, 1, 4, 4, 0, 0, 1, 3, 1, 1, 1, 1, 0, 0, 1, 0},
                {0, 1, 4, 4, 0, 0, 0, 0, 2, 0, 1, 1, 0, 0, 1, 0},
                {0, 1, 4, 4, 0, 0, 1, 0, 1, 0, 0, 3, 0, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 3, 0, 3, 0, 1, 0},
                {0, 0, 0, 1, 0, 3, 0, 0, 3, 0, 3, 0, 3, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        // Update the game field and reset the player's position
        game = new Game(newGameField);
        displayArea = new BufferedImage(game.getRowCount() * scale, game.getColCount() * scale,
                BufferedImage.TYPE_INT_ARGB);
        displayLabel.setIcon(new ImageIcon(displayArea));
        updateOutput();

        // Request focus on the JFrame after switching levels
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
}
