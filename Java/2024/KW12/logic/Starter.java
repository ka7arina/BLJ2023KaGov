package logic;
import vehicles.Camper;

public class Starter {
    public static void main(String[] args) {

        VehicleRentalManager vehicleRentalManager = new VehicleRentalManager();

        Camper camper = new Camper("Hymermobil", 1957, "HYMER", "20 mpg", "White", "Yes", "Yes", 2);
        vehicleRentalManager.addVehicle(camper);
        System.out.println(vehicleRentalManager.vehicles);

    }
}
