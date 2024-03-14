public class Starter {
    public static void main(String[] args) throws IllegalAccessException {
        CoordinateSystem cs = new CoordinateSystem(500);

        // creates the points (coordinates) and the lines connecting them
        cs.addLineSegment(new CSLineSegment(new CSPoint(250, -250),new CSPoint(-250, 250)));
        cs.addLineSegment(new CSLineSegment (new CSPoint(68, -80),new CSPoint (-250, 68)));

        // calls CSRenderer and renders the window with the points size being 3
        new CSRenderer(cs, 1, 3);

    }
}