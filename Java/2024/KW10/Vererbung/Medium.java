public class Medium {
    private String title;
    private String yearOfPublication;
    private String language;

    public void printInfo() {
        String info = "\nTitle: " + title +
                "\nYear of Publication: " + yearOfPublication +
                "\nLanguage: " + language;
        System.out.println(info);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}

