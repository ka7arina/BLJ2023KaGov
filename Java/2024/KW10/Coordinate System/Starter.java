public class Starter {
    public static void main(String[] args) throws IllegalAccessException {
        CoordinateSystem cs = new CoordinateSystem(500);
        cs.addPoints(new CSPoint(-30, 60));
        new CSRenderer(cs, 1, 3);
    }
}