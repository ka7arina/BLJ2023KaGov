package vehicles;
import logic.Vehicle;

import java.time.LocalDate;

public class Compact extends Vehicle implements Motorized {

    public int seatAmount;

    public int getSeatAmount() {
        return seatAmount;
    }

    public void setSeatAmount(int seatAmount) {
        this.seatAmount = seatAmount;
    }

    public Compact(String name, int year, String brand, double mileage, String color, int seatAmount) {
        super(name, year, brand, mileage, color);
    }
}
