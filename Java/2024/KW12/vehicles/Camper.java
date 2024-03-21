package vehicles;
import logic.Vehicle;

import java.time.LocalDate;

public class Camper extends Vehicle implements Liveable {
    public Camper(String name, int year, String brand, String mileage, String color) {
        super(name, year, brand, mileage, color);
    }
}
