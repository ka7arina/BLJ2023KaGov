package ch.noseryoung;

public class CSPoint extends java.awt.Point {

private int id;
private int x;
private int y;
private static int idCounter = 0;

    // initializes a CSPoint object with x and y coordinates. increments the idCounter
    public CSPoint(int x, int y) {
        super(x, y);
        this.id = idCounter++;
    }

    public CSPoint() {
       super(0, 0);
    }

    // returns identifier of the CSPoint object
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("id: " + id + "x: " + x + "y: " + y);
    }

}
