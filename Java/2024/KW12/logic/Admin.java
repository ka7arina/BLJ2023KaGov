package logic;

import java.util.Scanner;

public class Admin {

    public void adminLogic() {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome back admin!\n" +
                "What would you like to do?");

        String choose = userInput.nextLine();

        if (choose.equals("help")) {
            System.out.println("see contracts -> scc\n" +
                    "see vehicles -> sv\n" +
                    "see customers -> sc\n");
        }

        if (choose.equals("scc")) {
            VehicleRentalManager contracts = new VehicleRentalManager();
            System.out.println(contracts.contracts);
        }

        if (choose.equals("sv")) {
            VehicleRentalManager vehicles = new VehicleRentalManager();
            System.out.println(vehicles.vehicles);
        }
    }
}
