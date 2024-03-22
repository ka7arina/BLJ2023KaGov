import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;


public class Starter {
    public static void main(String[] args) throws IllegalAccessException {
        // color selection with jpane
        String[] colors = {"black", "blue", "cyan", "gray", "green", "magenta", "orange", "pink", "red", "white", "yellow"};
        String selectedColor = (String) JOptionPane.showInputDialog(null, "Choose the line color:",
                "Color Selection", JOptionPane.QUESTION_MESSAGE, null, colors, colors[0]);
        Color lineColor = convertStringToColor(selectedColor);


        // shape selection with jpane
        String[] shapes = {"Rectangle", "Line", "Square"};
        String selectedShape = (String) JOptionPane.showInputDialog(null, "Choose the shape:",
                "Shape Selection", JOptionPane.QUESTION_MESSAGE, null, shapes, shapes[0]);

        // launch program with selected color
        CoordinateSystem cs = new CoordinateSystem(500);

        // Pass the selected line color to your renderer
        new CSRenderer(cs, 1, 3, lineColor);

        if ("Rectangle".equals(selectedShape)) {
            RectangleShape rectangle = new RectangleShape();
            rectangle.create(cs);
        }

        if ("Line".equals(selectedShape)) {
            LineShape line = new LineShape();
            line.create(cs);
        }

        if ("Square".equals(selectedShape)) {
            SquareShape square = new SquareShape();
            square.create(cs);
        }

    }

    public static Color convertStringToColor(String colorName) {
        Map<String, Color> colorMap = new HashMap<>();
        colorMap.put("black", Color.BLACK);
        colorMap.put("blue", Color.BLUE);
        colorMap.put("cyan", Color.CYAN);
        colorMap.put("gray", Color.GRAY);
        colorMap.put("green", Color.GREEN);
        colorMap.put("magenta", Color.MAGENTA);
        colorMap.put("orange", Color.ORANGE);
        colorMap.put("pink", Color.PINK);
        colorMap.put("red", Color.RED);
        colorMap.put("white", Color.WHITE);
        colorMap.put("yellow", Color.YELLOW);
        return colorMap.getOrDefault(colorName, Color.BLACK);
    }



}


