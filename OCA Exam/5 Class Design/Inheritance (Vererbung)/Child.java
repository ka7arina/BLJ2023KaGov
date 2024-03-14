// class that extends the parent (child class)
public class Child extends Parent {


    // overrides the meow function in parent
    @Override
    public void meow() {

        /* the super keyword accesses the superclass (which is parent) and then prints out both
        * that and this print statement
        */

        super.meow();
        System.out.println("I am " +getAge()+ " years old and say MEOW!");
    }
}
