package logic;
import exceptions.DenylistedPersonException;
import exceptions.LeaseLengthCollisionException;
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

    public boolean checkIsDenied(Person person) throws DenylistedPersonException {
        if (denyList.contains(person)) {
            throw new DenylistedPersonException("go away omg don't rent vehicles here again");
        }
        return false;
    }

    public boolean checkIsCollision(Contract contract) throws LeaseLengthCollisionException {
        for (Contract existingContract : contracts) { // Assuming `contracts` is a collection of existing contracts
            if (!contract.getStartDate().isAfter(existingContract.getEndDate()) &&
                    !contract.getEndDate().isBefore(existingContract.getStartDate())) {
                throw new LeaseLengthCollisionException("You cannot lease at the same time as someone else");
            }
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

    public boolean createContract(Contract newContract) throws MinorAgeException, DenylistedPersonException, LeaseLengthCollisionException {
        // checks if minor
        if (checkIsMinor(newContract.getPerson().getBirthYear())) {
            throw new MinorAgeException("You must be 18 years or older!");
        }

        // checks if on denylist
        if (checkIsDenied(newContract.getPerson().getDenied())) {
            throw new DenylistedPersonException("Go away OMG, don't rent vehicles here again.");
        }

        checkIsCollision(newContract);

        contracts.add(newContract);
        System.out.println("Contracts: " + contracts.toString());

        return true;
    }


}
