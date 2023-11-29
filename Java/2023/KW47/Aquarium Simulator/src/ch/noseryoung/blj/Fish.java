package ch.noseryoung.blj;

public class Fish {
    private String name;
    private String gender;
    private String color;
    private String type;
    private int size;
    private boolean isSaltWater;
    private int xPos;
    private int yPos;

    public Fish() {

    }

    public Fish(String name, String gender, String color, String type, int size, boolean isSaltWater, int xPos, int yPos) {
        this.name = name;
        this.gender = gender;
        this.color = color;
        this.type = type;
        this.size = size;
        this.isSaltWater = isSaltWater;
        this.xPos = xPos;
        this.yPos = yPos;
    }


    // getters und setters generiert
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isSaltWater() {
        return isSaltWater;
    }

    public void setSaltWater(boolean saltWater) {
        isSaltWater = saltWater;
    }


    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    // vorlage für den output
    public String toString() {
        return this.name + " , " + this.gender + " , " + this.color + " , " + this.type + " , " +
                this.size + " , " + this.isSaltWater ;
    }
}
