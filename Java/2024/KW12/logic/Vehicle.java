package logic;

import java.time.LocalDate;

public class Vehicle {

    private LocalDate year;
    private String brand;
    private String mileage;
    private String color;

    public Vehicle(LocalDate year, String brand, String mileage, String color) {

        this.year = year;
        this.brand = brand;
        this.mileage = mileage;
        this.color = color;
    }
}
