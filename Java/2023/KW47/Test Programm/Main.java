public class Main {

    private String name;
    private String breed;
    private String color;
    private int birthyear;


    public Main() {

    }

    public Main(String name) {
        this.name = name;
    }

    public Main(String name, String breed, String color, int birthyear) {
        this.name = name;
        this.breed = breed;
        this.color = color;
    }

    public void barking() {
        System.out.println(name +"Woof! Woof!");
    }

    public void sleeping() {
        System.out.println(name +" is sleeping ZZZZzzzzzzzzz");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", color='" + color + '\'' +
                ", birthyear=" + birthyear +
                '}';
    }
}