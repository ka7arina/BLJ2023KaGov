package logic;

import vehicles.Compact;

import java.time.LocalDate;

public class VehicleRentalManager {

    public void customerList() {
        // Create birthyear and customers
        LocalDate birth1 = LocalDate.of(2000, 11, 27);
        birth1.getYear();
        Person person1 = new Person("John", "Miller", birth1, "Heckengasse 2, 7035 Oerlikon", "+41 65 765 283");
        System.out.println(person1.toString());
        LocalDate birth2 = LocalDate.of(2018, 8, 27);
        birth2.getYear();
    }

    public void denyList() {

    }

    public void vehicles() {
    }


}
