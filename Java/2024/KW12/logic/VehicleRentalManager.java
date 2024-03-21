package logic;
import java.time.LocalDate;
import java.util.ArrayList;

public class VehicleRentalManager {

    public void customerList() {

        // Create birthyear and customers
        LocalDate birth1 = LocalDate.of(2000, 11, 27);
        birth1.getYear();
        Person person1 = new Person("John", "Miller", birth1, "Heckengasse 2, 7035 Oerlikon", "+41 65 765 283");

        LocalDate birth2 = LocalDate.of(2018, 8, 27);
        birth2.getYear();

        // Create Arraylist for customers
        ArrayList<Person> customers = new ArrayList<Person>();
        customers.add(person1);

        System.out.println(customers);
    }

    public void denyList() {

    }

    public void vehicles() {
    }


}
