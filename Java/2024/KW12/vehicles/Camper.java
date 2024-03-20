package vehicles;
import logic.Vehicle;

import java.time.LocalDate;

public class Camper extends Vehicle implements Liveable {
    public Camper(LocalDate year, String brand, String mileage, String color) {
        super(year, brand, mileage, color);
    }
}
