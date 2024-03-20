package vehicles;
import logic.Vehicle;

import java.time.LocalDate;

public class LuxuryCar extends Vehicle implements Motorized {
    public LuxuryCar(LocalDate year, String brand, String mileage, String color) {
        super(year, brand, mileage, color);
    }
}
