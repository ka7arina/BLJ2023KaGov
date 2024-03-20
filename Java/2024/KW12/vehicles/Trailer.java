package vehicles;
import logic.Vehicle;

import java.time.LocalDate;

public class Trailer extends Vehicle {
    public Trailer(LocalDate year, String brand, String mileage, String color) {
        super(year, brand, mileage, color);
    }
}
