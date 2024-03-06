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
        m1.setDirector("James Gunn");
        m1.setLength(122);

        CD c1 = new CD();
        c1.setTitle("Lover");
        c1.setYearOfPublication("2019");
        c1.setLanguage("English");
        c1.setArtist("Taylor Swift");
        c1.setLength(61);

        CD c2 = new CD();
        c2.setTitle("Good Riddance");
        c2.setYearOfPublication("2023");
        c2.setLanguage("English");
        c2.setArtist("Gracie Abrams");
        c2.setLength(52.24);

        VideoGame v1 = new VideoGame();
        v1.setTitle("Minecraft");
        v1.setYearOfPublication("2009");
        v1.setLanguage("English");
        v1.setCreator("Mojang Studios");

        VideoGame v2 = new VideoGame();
        v2.setTitle("Splatoon 2");
        v2.setYearOfPublication("2017");
        v2.setLanguage("English");
        v2.setCreator("Nintendo");

        b1.printInfo();
        m1.printInfo();
        c1.printInfo();
        c2.printInfo();
        v1.printInfo();
        v2.printInfo();

    }

}
