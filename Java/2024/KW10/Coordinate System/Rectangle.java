public class Rectangle implements Formen {

    @Override
    public void createRectangle(CoordinateSystem cs) {
        cs.addLineSegment(new CSLineSegment(new CSPoint(50, 50), new CSPoint(50, -50)));
        cs.addLineSegment(new CSLineSegment(new CSPoint(50, 50), new CSPoint(-50, 50)));
        cs.addLineSegment(new CSLineSegment(new CSPoint(50, -50), new CSPoint(-50, -50)));
        cs.addLineSegment(new CSLineSegment(new CSPoint(-50, 50), new CSPoint(-50, -50)));
    }
}

