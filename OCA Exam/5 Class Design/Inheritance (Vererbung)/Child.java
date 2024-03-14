// class that extends the parent (child class)
public class Child extends Parent {


    // overrides the meow function in parent
    @Override
    public void meow() {
        System.out.println("I am " +getAge()+ " years old and say MEOW!");
    }
}
