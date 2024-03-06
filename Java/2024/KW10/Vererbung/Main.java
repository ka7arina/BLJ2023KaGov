public class Main {
    public static void main(String[] args) {
        Book b1 = new Book();
        b1.setTitle("The Hunger Games");
        b1.setYearOfPublication("2008");
        b1.setLanguage("English");
        b1.setAuthor("Suzanne Collins");
        b1.setNumberOfPages(374);

        Movie m1 = new Movie();
        m1.setTitle("Guardians of the Galaxy");
        m1.setYearOfPublication("2014");
        m1.setLanguage("English");
        m1.setDirector("Suzanne Collins");
        m1.setLength(122);

        b1.printInfo();

    }

}
