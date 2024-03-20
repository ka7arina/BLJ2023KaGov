package vehicles;
import logic.Vehicle;

import java.time.LocalDate;

public class Truck extends Vehicle implements Motorized {
    public Truck(LocalDate year, String brand, String mileage, String color) {
        super(year, brand, mileage, color);
    }
}
