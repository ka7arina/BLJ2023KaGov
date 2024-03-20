import java.awt.Point;

public class CSPoint extends Point {

    private static int IDcounter = 0;
    private int id;

    // constructors
    public CSPoint() {
        this(0,0);
    }

    public CSPoint(int x, int y) {
        super(x, y);
        this.id = IDcounter++;
    }


    // getters
    public int getId() {
        return id;
    }

    // change output of toString
    @Override
    public String toString() {
        return "CSPoint{" +
                "ID=" + id +
                ", X=" + x +
                ", Y=" + y +
                '}';
    }
}