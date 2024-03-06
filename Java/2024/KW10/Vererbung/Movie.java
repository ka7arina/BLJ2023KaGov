import java.util.List;

public class Movie extends Medium {
    private String director;
    private double length;

    @Override
    public void printInfo() {
        super.printInfo();
        String moreInfo = "Director: " + director
                + "\nLength: " + length;
        System.out.println(moreInfo);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
