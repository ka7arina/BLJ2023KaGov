package logic;
import java.time.LocalDate;
import java.util.ArrayList;

public class VehicleRentalManager {

    public ArrayList<Person> customerList = new ArrayList<>();
    public ArrayList<Person> denyList = new ArrayList<>();
    public ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void customerList() {

        // Create birthyear and customers
        LocalDate birth1 = LocalDate.of(2000, 11, 27);
        Person customer1 = new Person("John", "Miller", birth1, "Heckengasse 2, 7035 Oerlikon", "+41 65 765 283");

        LocalDate birth2 = LocalDate.of(2018, 8, 14);
        Person customer2 = new Person("Maria", "Smith", birth2, "Rosengartenstrasse 8, 8037 Zürich", "+41 76 897 65 23");

        // Create Arraylist for customers
        customerList.add(customer1);
        customerList.add(customer2);

        System.out.println(customerList);

    }

    public void addPersonToDenyList(Person person) {
        denyList.add(person);
        System.out.println(denyList);

    }

    public void addVehicle(Vehicle vehicle) {
    vehicles.add(vehicle);
    }

}
