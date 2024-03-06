public class CD extends Medium {
    private String artist;
    private double length;

    @Override
    public void printInfo() {
        super.printInfo();
        String moreInfo = "\nArtist: " + artist
                + "Length:" + length;
        System.out.println(moreInfo);
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
