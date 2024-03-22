package logic;
import vehicles.Camper;
import vehicles.Truck;

import java.time.LocalDate;

public class Starter {
    public static void main(String[] args) {

        VehicleRentalManager vehicleRentalManager = new VehicleRentalManager();

        Person customer1 = new Person("John", "Miller", LocalDate.of(2000, 11, 9), "Heckengasse 2, 7035 Oerlikon", "+41 65 765 283");

        Person customer2 = new Person("Maria", "Smith", LocalDate.of(2018, 6, 25), "Rosengartenstrasse 8, 8037 Zürich", "+41 76 897 65 23");

        vehicleRentalManager.addCustomerList(customer1);
        vehicleRentalManager.addCustomerList(customer2);

        Person denied1 = new Person("Joe", "Biden", LocalDate.of(1980, 7, 11), "The White House", "1-202-456-1111");

        vehicleRentalManager.addPersonToDenyList(denied1);

        Truck truck = new Truck("Mercedes Vita", 1954-1-1, "Mercedes", 36.7, "White", 580);

        vehicleRentalManager.addVehicle(truck);

        Camper camper = new Camper("Hymermobil", 1957, "HYMER", 20, "White", "Yes", "Yes", 2);
        vehicleRentalManager.addVehicle(camper);
    }
}