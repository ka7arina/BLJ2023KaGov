package vehicles;
import logic.Vehicle;

import java.time.LocalDate;

public class Car extends Vehicle implements Motorized {


    public Car(LocalDate year, String brand, String mileage, String color) {
        super(year, brand, mileage, color);

    }
}