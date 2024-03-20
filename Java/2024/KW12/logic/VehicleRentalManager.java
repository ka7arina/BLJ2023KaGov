package logic;

import vehicles.Car;

import java.time.LocalDate;

public class VehicleRentalManager {

    public void customerList() {
        LocalDate dt = LocalDate.parse("2000-11-27");

        // Pass the LocalDate object directly
        Person person1 = new Person("John", "Miller", dt, "Heckengasse 2, 7035 Oerlikon", "+41 65 765 283");
        System.out.println(person1);
    }

    public void denyList() {

    }

    public void vehicles() {

    }


}
