package logic;
import exceptions.MinorAgeException;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class VehicleRentalManager {

    // Array Lists
    public ArrayList<Person> customerList = new ArrayList<>();
    public ArrayList<Person> denyList = new ArrayList<>();
    public ArrayList<Vehicle> vehicles = new ArrayList<>();
    public ArrayList<Contract> contracts = new ArrayList<>();

    public void addCustomerList(Person onCustomerList) {

        // Create Arraylist for customer
            customerList.add(onCustomerList);
        System.out.println("Customer List" + customerList);
    }

    public boolean checkIsMinor(LocalDate date) throws MinorAgeException {
        if (Period.between(date, LocalDate.now()).getYears() < 18) {
            throw new MinorAgeException("You must be at least 18 years old.");
        }
        return false;
    }

    public void addPersonToDenyList(Person denylisted) {
        denyList.add(denylisted);
        System.out.println("Deny List: " + denyList);
    }

    public void addVehicle(Vehicle vehicle) {
    vehicles.add(vehicle);
        System.out.println("Vehicles: " + vehicles.toString());
    }

    public void createContract(Contract newContract) throws MinorAgeException {
        newContract.getPerson().getBirthYear();

        if(!checkIsMinor(newContract.getPerson().getBirthYear())) {
            contracts.add(newContract);
            System.out.println("Contracts: " + contracts.toString());
        } else {
            throw new MinorAgeException("You must be 18 years or older!");
        }

    }
}
