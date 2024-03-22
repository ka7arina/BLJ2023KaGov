public class RectangleShape implements Formen {

    @Override
    public void create(CoordinateSystem cs) {
        cs.addLineSegment(new CSLineSegment(new CSPoint(-60, 40), new CSPoint(60, 40)));
        cs.addLineSegment(new CSLineSegment(new CSPoint(60, 40), new CSPoint(60, -40)));
        cs.addLineSegment(new CSLineSegment(new CSPoint(60, -40), new CSPoint(-60, -40)));
        cs.addLineSegment(new CSLineSegment(new CSPoint(-60, -40), new CSPoint(-60, 40)));
    }
}

