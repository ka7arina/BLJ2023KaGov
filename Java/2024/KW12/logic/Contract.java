package logic;
import java.time.LocalDate;

public class Contract {

    // Variables
    public Person person;
    public LocalDate startDate;
    public LocalDate endDate;
    public String contractModel;
    public int leasingRate;

    public String vehicle;

    public Contract(Person person, String vehicle, LocalDate startDate, LocalDate endDate, String contractModel, int leasingRate) {
        this.person = person;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractModel = contractModel;
        this.leasingRate = leasingRate;
        this.vehicle = vehicle;

    }



    // Getters and Setters

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getContractModel() {
        return contractModel;
    }

    public void setContractModel(String contractModel) {
        this.contractModel = contractModel;
    }

    public int getLeasingRate() {
        return leasingRate;
    }

    public void setLeasingRate(int leasingRate) {
        this.leasingRate = leasingRate;
    }

    @Override
    public String toString() {
        return "Name: " + person +
                ", Vehicle: " + vehicle +
                ", Starts: " + startDate +
                ", Ends: " + endDate +
                ", Leasing Rate: " + leasingRate +
                ", Text: '" + contractModel;
    }
}
