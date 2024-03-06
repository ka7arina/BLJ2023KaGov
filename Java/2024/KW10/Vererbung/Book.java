public class Book extends Medium {
    private String author;
    private double numberOfPages;
@Override
    public void printInfo() {
        super.printInfo();
        String moreInfo = "Author: " + author
                + "\nNumber of Pages: " + numberOfPages;
        System.out.println(moreInfo);
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(double numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
