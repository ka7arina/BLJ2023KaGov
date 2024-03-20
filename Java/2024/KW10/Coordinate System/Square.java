public class Square {

    public void createSquare() throws IllegalAccessException {

        CoordinateSystem cs = new CoordinateSystem(500);

        cs.addLineSegment(new CSLineSegment(new CSPoint(-50, -50), new CSPoint(-50, 50))); // Links
        cs.addLineSegment(new CSLineSegment(new CSPoint(-50, 50), new CSPoint(50, 50))); // Oben
        cs.addLineSegment(new CSLineSegment(new CSPoint(50, 50), new CSPoint(50, -50))); // Rechts
        cs.addLineSegment(new CSLineSegment(new CSPoint(50, -50), new CSPoint(-50, -50))); // Unten
    }
}
