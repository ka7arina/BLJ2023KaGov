public class Starter {
    public static void main(String[] args) throws IllegalAccessException {
        CoordinateSystem cs = new CoordinateSystem(500);

        // creates points (coordinates)
        cs.addLineSegment(new CSLineSegment(new CSPoint(-200, 60),new CSPoint(-30, 60)));
        cs.addLineSegment(new CSLineSegment(new CSPoint(-30, 60),new CSPoint(-30, 60)));


        new CSRenderer(cs, 1, 3);


    }
}