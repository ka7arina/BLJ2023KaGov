package vehicles;
import logic.Vehicle;

import java.time.LocalDate;

public class Camper extends Vehicle implements Liveable {


    public String hasShower;

    public int bedAmount;

    public String hasKitchen;

    public Camper(String name, int year, String brand, double mileage, String color, String hasShower, String hasKitchen, int bedAmount) {

        // Calling the constructor of Vehicle
        super(name, year, brand, mileage, color);
        this.hasShower = hasShower;
        this.hasKitchen = hasKitchen;
        this.bedAmount = bedAmount;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        String camperInfo = ", Shower included: " + hasShower + ", Kitchen included: " + hasKitchen + ", Amount of beds: " + bedAmount;
        System.out.println(camperInfo);
    }

    @Override
    public String toString() {
        return super.toString() + ", Shower included: " + hasShower + ", Kitchen included: " + hasKitchen + ", Amount of beds: " + bedAmount;
    }

    public String getHasShower() {
        return hasShower;
    }

    public void setHasShower(String hasShower) {
        this.hasShower = hasShower;
    }

    public int getBedAmount() {
        return bedAmount;
    }

    public void setBedAmount(int bedAmount) {
        this.bedAmount = bedAmount;
    }

    public String getHasKitchen() {
        return hasKitchen;
    }

    public void setHasKitchen(String hasKitchen) {
        this.hasKitchen = hasKitchen;
    }

}