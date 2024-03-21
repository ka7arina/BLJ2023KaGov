package logic;
import java.time.LocalDate;
import java.util.ArrayList;

public class VehicleRentalManager {


    // Array Lists
    public ArrayList<Person> customerList = new ArrayList<>();
    public ArrayList<Person> denyList = new ArrayList<>();
    public ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void addCustomerList(Person onCustomerList) {

        // Create Arraylist for customer
            customerList.add(onCustomerList);
        System.out.println("Customer List" + customerList);

    }

    public void addPersonToDenyList(Person denylisted) {
        denyList.add(denylisted);
        System.out.println("Deny List: " + denyList);

    }

    public void addVehicle(Vehicle vehicle) {
    vehicles.add(vehicle);
        System.out.println("Vehicles" + vehicles);
    }

    public void createContract() {

    }
}
