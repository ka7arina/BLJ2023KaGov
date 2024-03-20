package vehicles;
import logic.Vehicle;

import java.time.LocalDate;

public class Compact extends Vehicle implements Motorized {
    public Compact(LocalDate year, String brand, String mileage, String color) {
        super(year, brand, mileage, color);
    }
}
