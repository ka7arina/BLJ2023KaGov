package CatClass;

public class Cat {
    private String name;
    private String breed;
    private String color;
    private String height;
    private int birthyear;

    public Cat() {
    }

    public Cat(String name, String breed, String color, int birthyear, String height) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.birthyear = birthyear;
        this.height = height;
    }

    public void meowing() {
        System.out.println(name +"Meow! Meow!");
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


    // Output
    @Override
    public String toString() {
        return "Cat " +
                "Name = '" + name + '\'' +
                ", Breed = '" + breed + '\'' +
                ", Color = '" + color + '\'' +
                ", Height = '" + height + '\'' +
                ", Birthyear = " + birthyear +
                ' ';
    }
}


