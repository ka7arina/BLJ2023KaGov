package ch.noseryoung.blj;

public class Personen {
    private String name;
    private int age;
    private String placeofbirth;
    private String nationality;
    private int ID;

    public Personen() {

    }

    public Personen(String name, int age, String placeofbirth, String nationality, int ID) {
        this.name = name;
        this.age = age;
        this.placeofbirth = placeofbirth;
        this.nationality = nationality;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return
                "Name = '" + name + '\'' +
                ", Age = '" + age + '\'' +
                ", Place of Birth = '" + placeofbirth + '\'' +
                ", Nationality = '" + nationality + '\'' +
                ", ID = " + ID + "\n";
    }
}
