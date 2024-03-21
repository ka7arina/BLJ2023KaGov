package vehicles;
import logic.Vehicle;

import java.time.LocalDate;

public class Trailer extends Vehicle {
    public Trailer(String name, LocalDate year, String brand, String mileage, String color) {
        super(name, year, brand, mileage, color);
    }
}
