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

    // adds the points to the list
    public void addPoints(CSPoint csPoint){
        points.add(csPoint);
    }

    // returns the list with the points
    public List<CSPoint> getPoints() {
        return points;
    }

    public CSPoint[] getAllPoints(){
        return points.toArray(new CSPoint[0]);
    }

    // gets the size of the coordinate system
    public int getCoordinateSystemSize() {
        return coordinateSystemSize;
    }

    public void setCoordinateSystemSize(int coordinateSystemSize) {
        this.coordinateSystemSize = coordinateSystemSize;
    }

}