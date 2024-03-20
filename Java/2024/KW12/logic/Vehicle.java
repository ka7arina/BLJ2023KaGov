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


    public void printInfo() {
        String info = year + brand + mileage + color;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
