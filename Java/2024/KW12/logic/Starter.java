package logic;

public class Starter {
    public static void main(String[] args) {
        VehicleRentalManager vehicleRentalManager = new VehicleRentalManager();

        Vehicle vehicle = new Vehicle("Hymermobil", 1957, "HYMER", "20 mpg", "white");
        vehicle.printInfo();

    }
}
