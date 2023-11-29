package ch.noseryoung.blj;

public class Decor {

    private String type;
    private int size;
    private int xPos;
    private int yPos;

    public Decor() {

    }

    public Decor(String type, int size, int xPos, int yPos) {
        this.type = type;
        this.size = size;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public int getSize() { return size; }

    public void setSize(int size) { this.size = size; }

    public int getxPos() { return xPos; }

    public void setxPos(int xPos) { this.xPos = xPos; }

    public int getyPos() { return yPos; }

    public void setyPos(int yPos) { this.yPos = yPos; }
}



