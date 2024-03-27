package logic;
import java.time.LocalDate;

public class Person {

    // Variables
    private String firstName;
    private String lastName;
    public LocalDate birthYear;
    private String address;
    private String phoneNumber;

    private Person denied;

    // Constructor
    public Person(String firstName, String lastName, LocalDate birthYear, String address, String phoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(LocalDate birthYear) {
        this.birthYear = birthYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Person getDenied() {
        return denied;
    }

    public void setDenied(Person denied) {
        this.denied = denied;
    }

    @Override
    public String toString() {
        return "\nFirst Name: " + firstName +
                ", Last Name: " + lastName +
                ", Birth Year: " + birthYear +
                ", Address: " + address +
                ", Phone Number: " + phoneNumber;
    }
}
