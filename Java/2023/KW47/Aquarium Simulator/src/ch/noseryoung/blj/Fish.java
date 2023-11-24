package ch.noseryoung.blj;

public class Fish {
    private String name;
    private String gender;
    private String color;
    private String type;
    private int size;
    boolean isSaltWater;
    boolean isFreshWater;
    int xPos;
    int yPos;

    public Fish() {

    }

    public Fish(String name, String gender, String color, String type, int size, boolean isSaltWater, boolean isFreshWater) {
        this.name = name;
        this.gender = gender;
        this.color = color;
        this.type = type;
        this.size = size;
        this.isSaltWater = isSaltWater;
        this.isFreshWater = isFreshWater;
    }

    public String toString() {
        return "" + this.name + " , " + this.gender + " , " + this.color + " , " + this.type + " , " +
                this.size + " , " + this.isSaltWater + " , " + this.isFreshWater + "";
    }
}
