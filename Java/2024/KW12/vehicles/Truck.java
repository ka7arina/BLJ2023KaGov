package vehicles;
import logic.Vehicle;

import java.time.LocalDate;

public class Truck extends Vehicle implements Motorized {
    public Truck(String name, LocalDate year, String brand, String mileage, String color) {
        super(name, year, brand, mileage, color);
    }
}
