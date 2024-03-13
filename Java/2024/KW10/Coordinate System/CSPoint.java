import java.awt.Point;

public class CSPoint extends Point {

    private static int IDcounter = 0;
    private int id;
    public CSPoint() {
        this(0,0,0, 0);
    }

    public CSPoint(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
        this.id = IDcounter++;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "CSPoint{" +
                "ID=" + id +
                ", X=" + x +
                ", Y=" + y +
                '}';
    }
}