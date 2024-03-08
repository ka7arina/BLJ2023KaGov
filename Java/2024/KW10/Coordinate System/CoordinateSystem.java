import java.util.ArrayList;
import java.util.List;

public class CoordinateSystem {

    private int coordinateSystemSize;
    private List<CSPoint> points;

    public CoordinateSystem(int coordinateSystemSize) throws IllegalAccessException {
        if(coordinateSystemSize <= 0 || coordinateSystemSize % 20 != 0){
            throw new IllegalAccessException();
        }
        this.coordinateSystemSize = coordinateSystemSize;
        this.points = new ArrayList<>();
    }

    public CSPoint[] getAllPoints(){
        return points.toArray(new CSPoint[0]);
    }



}