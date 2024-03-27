package logic;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Login {
    private VehicleRentalManager vehicleRentalManager;

    public Login(VehicleRentalManager vehicleRentalManager) {
        this.vehicleRentalManager = vehicleRentalManager;
    }

    public void loginLogic() throws InterruptedException {

        do {
        System.out.println("Login: ");

        Scanner login = new Scanner(System.in);
        String userName = login.nextLine();

        System.out.println("Do you want to log in as " + userName + "?");

            String userConfirmation = login.nextLine();

            if (userConfirmation.equals("yes")) {
                System.out.println("Logging you in...");
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("...");
            } else if (userConfirmation.equals("no")) {
                System.out.println("okay!");
            } else {
                System.out.println("Login Denied");
            }

            if (userName.equals("admin") && userConfirmation.equals("yes")) {
                Admin admin = new Admin(vehicleRentalManager);
                admin.adminLogic();
                break;
            } else if (userName.equals("customer") && userConfirmation.equals("yes")) {
                Customer customer = new Customer();
                customer.customerLogic();
                break;
            } else {
                System.out.println("Login Denied");
            }

        } while (true);


    }
}
