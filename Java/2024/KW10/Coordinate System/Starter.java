public class Starter {
    public static void main(String[] args) throws IllegalAccessException {
        CoordinateSystem cs = new CoordinateSystem(500);

        CSPoint p1 = new CSPoint(-30, 60, 60, -30);
        CSPoint p2 = new CSPoint(40, 70, 40, 70);

        cs.addPoints(p1);
        cs.addPoints(p2);

        new CSRenderer(cs, 1, 3);
        CSLineSegment lineSegment = new CSLineSegment();

    }
}