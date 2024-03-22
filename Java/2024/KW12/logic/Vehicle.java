package logic;

public class Vehicle {

    public int year;
    public String brand;
    public double mileage;
    public String color;
    public String name;


    public Vehicle(String name, int year, String brand, double mileage, String color) {

        this.name = name;
        this.year = year;
        this.brand = brand;
        this.mileage = mileage;
        this.color = color;
    }

    public void printInfo() {
        String info = "Name: " + name + ", Year: " + year + ", Brand: " + brand + ", Mileage: " + mileage + " MGP, Color: " + color;
    }

    @Override
    public String toString() {
        return "\nName: " + name + ", Year: " + year + ", Brand: " + brand + ", Mileage: " + mileage + " MGP, Color: " + color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}