package vehicles;
import logic.Vehicle;

public class Compact extends Vehicle {


    public int seatAmount;

    public int getSeatAmount() {
        return seatAmount;
    }

    public void setSeatAmount(int seatAmount) {
        this.seatAmount = seatAmount;
    }

    public Compact(String name, int year, String brand, double mileage, String color, int seatAmount) {
        super(name, year, brand, mileage, color);

        this.seatAmount = seatAmount;
    }

}
