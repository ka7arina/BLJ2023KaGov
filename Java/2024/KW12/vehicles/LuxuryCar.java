package vehicles;
import logic.Vehicle;

import java.time.LocalDate;

public class LuxuryCar extends Vehicle implements Motorized {
    public LuxuryCar(String name, LocalDate year, String brand, String mileage, String color) {
        super(name, year, brand, mileage, color);
    }
}
