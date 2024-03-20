package logic;

import java.time.LocalDate;

public class Vehicle {

    public LocalDate year;
    public String brand;
    public String mileage;
    public String color;

    public Vehicle(LocalDate year, String brand, String mileage, String color) {

        this.year = year;
        this.brand = brand;
        this.mileage = mileage;
        this.color = color;
    }
}
