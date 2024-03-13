
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class CoordinateSystem {
    private int coordinateSystemSize;
    private List<CSPoint> points;
    private List<CSLineSegment> lineSegments;

    public CoordinateSystem(int coordinateSystemSize) throws IllegalAccessException {
        if(coordinateSystemSize <= 0 || coordinateSystemSize % 20 != 0){
            throw new IllegalAccessException();
        }
        this.coordinateSystemSize = coordinateSystemSize;
        this.points = new ArrayList<>();
        this.lineSegments = new ArrayList<>();
    }

    public void addPoints(CSPoint csPoint){
        points.add(csPoint);
    }

    public void addLineSegment(CSLineSegment lineSegment){
        lineSegments.add(lineSegment);
    }

    public List<CSPoint> getPoints() {
        return points;
    }

    public CSPoint[] getAllPoints(){
        return points.toArray(new CSPoint[0]);
    }

    public List<CSLineSegment> getLineSegments(){
        return lineSegments;
    }

    public int getCoordinateSystemSize() {
        return coordinateSystemSize;
    }

    public void setCoordinateSystemSize(int coordinateSystemSize) {
        this.coordinateSystemSize = coordinateSystemSize;
    }
}