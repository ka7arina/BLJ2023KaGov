package vehicles;
import logic.Vehicle;

public class Truck extends Vehicle {

    public double storageSpace;

    public Truck(String name, int year, String brand, double mileage, String color, double storageSpace) {
        super(name, year, brand, mileage, color);
        this.storageSpace = storageSpace;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        String truckInfo = ", Storage Space: " + storageSpace;
        System.out.println(truckInfo);
    }

    @Override
    public String toString() {
        return super.toString() + ", Storage Space: " + storageSpace;
    }
}