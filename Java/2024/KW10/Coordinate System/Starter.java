import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Starter {
    public static void main(String[] args) throws IllegalAccessException {
        // color selection
        String[] colors = {"Black", "Blue", "Green", "Yellow", "Orange"};
        String selectedColor = (String) JOptionPane.showInputDialog(null, "Choose the line color:",
                "Color Selection", JOptionPane.QUESTION_MESSAGE, null, colors, colors[0]);
        Color lineColor = convertStringToColor(selectedColor);

        // shape selection
        String[] shapes = {"Rectangle", "Square", "Triangle", "Circle", "Star"};
        String selectedShape = (String) JOptionPane.showInputDialog(null, "Choose the shape:",
                "Shape Selection", JOptionPane.QUESTION_MESSAGE, null, shapes, shapes[0]);
        Shape shape = convertStringToShape(selectedShape);

        // Proceed with application launch using the selected color
        CoordinateSystem cs = new CoordinateSystem(500);
        cs.addLineSegment(new CSLineSegment(new CSPoint(0, 0), new CSPoint(-60, 70)));

        // Pass the selected line color to your renderer
        new CSRenderer(cs, 1, 3, lineColor);
    }

    // chooses the color for the shape
    private static Color convertStringToColor(String colorName) {
        Map<String, Color> colorMap = new HashMap<>();
        colorMap.put("Black", Color.BLACK);
        colorMap.put("Blue", Color.BLUE);
        colorMap.put("Green", Color.GREEN);
        colorMap.put("Orange", Color.ORANGE);
        colorMap.put("Pink", Color.PINK);
        colorMap.put("Red", Color.RED);
        colorMap.put("White", Color.WHITE);
        colorMap.put("Yellow", Color.YELLOW);

        // Use the HashMap to return the Color object based on the input string
        return colorMap.getOrDefault(colorName, Color.BLACK); // Default to BLACK if the color is not found
    }
}


