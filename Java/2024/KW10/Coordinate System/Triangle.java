public class Triangle {

    public void createTriangle() throws IllegalAccessException {

        CoordinateSystem cs = new CoordinateSystem(500);

        cs.addLineSegment(new CSLineSegment(new CSPoint(0, (int) (50*Math.sqrt(3)/2)), new CSPoint(-50, (int) (-50*Math.sqrt(3)/6))));
        cs.addLineSegment(new CSLineSegment(new CSPoint(-50, (int) (-50*Math.sqrt(3)/6)), new CSPoint(50, (int) (-50*Math.sqrt(3)/6))));
        cs.addLineSegment(new CSLineSegment(new CSPoint(50, (int) (-50*Math.sqrt(3)/6)), new CSPoint(0, (int) (50*Math.sqrt(3)/2))));

    }
}
