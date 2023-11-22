package CatClass;

public class Main {

    public static void main(String[] args) {

        String name = "Cookie";
        String breed = "Persian Cat";
        String color = "Grey";
        String height = "9 Inches";
        int birthyear = 2016;

        System.out.println("------------------------------------------------------------------------------------------------------------");

        System.out.println(name);
        System.out.println(breed);
        System.out.println(color);
        System.out.println(height);
        System.out.println(birthyear);

        System.out.println("------------------------------------------------------------------------------------------------------------");
        Cat cookie = new Cat("Cookie", "Persian Cat", "Grey", 2016, "9 Inches");
        Cat bob = new Cat("Bob", "Ragdoll", "Black", 2014, "8 Inches");
        Cat milo = new Cat("Milo", "American Shorthair", "Orange", 2012, "11 Inches");

        System.out.println(cookie.toString());
        System.out.println(bob.toString());
        System.out.println(milo.toString());

    }
}
