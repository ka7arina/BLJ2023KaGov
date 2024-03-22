public class LineShape implements Formen {

    @Override
    public void create(CoordinateSystem cs) {
        cs.addLineSegment(new CSLineSegment(new CSPoint(0, 0), new CSPoint(-70, 60)));
    }
}
