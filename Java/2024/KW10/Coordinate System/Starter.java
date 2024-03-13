public class Starter {
    public static void main(String[] args) throws IllegalAccessException {
        CoordinateSystem cs = new CoordinateSystem(500);

        // creates points (coordinates) the first CSPoint defines from where the line goes
        cs.addLineSegment(new CSLineSegment(new CSPoint(250, -250),new CSPoint(-250, 250)));
        cs.addLineSegment(new CSLineSegment (new CSPoint(68, -80),new CSPoint (-80, 68)));

        // renders everything
        new CSRenderer(cs, 1, 3);

    }
}