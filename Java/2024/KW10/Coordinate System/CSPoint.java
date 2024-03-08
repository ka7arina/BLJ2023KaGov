import java.awt.Point;

public class CSPoint extends Point {

    private static int IDcounter = 0;
    private int id;
    public CSPoint() {
        this(0,0);
    }

    public CSPoint(int x, int y) {
        super(x, y);
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