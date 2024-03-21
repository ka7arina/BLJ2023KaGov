package vehicles;
import logic.Vehicle;

import java.time.LocalDate;

public class Compact extends Vehicle implements Motorized {
    public Compact(String name, LocalDate year, String brand, String mileage, String color) {
        super(name, year, brand, mileage, color);
    }
}
