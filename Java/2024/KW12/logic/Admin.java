package logic;
import java.util.Scanner;

public class Admin {

    private VehicleRentalManager vehicleRentalManager;

    public Admin(VehicleRentalManager vehicleRentalManager) {
        this.vehicleRentalManager = vehicleRentalManager;
    }

    public void adminLogic() {

        boolean exit = false;

        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome back admin!\n");

        do {

            System.out.println("What would you like to do?");

            String choose = userInput.nextLine();

            if (choose.equals("help")) {
                System.out.println("see contracts -> scc\n" +
                        "see vehicles -> sv\n" +
                        "see customers -> sc\n" +
                        "see denylist -> sd\n" +
                        "add vehicle -> add vehicle\n");
            }

            if (choose.equals("scc")) {
                System.out.println("Contracts: " + vehicleRentalManager.contracts);
            }

            if (choose.equals("sv")) {
                System.out.println("Vehicles: " + vehicleRentalManager.vehicles);
            }

            if (choose.equals("sc")) {
                System.out.println("Customers: " + vehicleRentalManager.customerList);
            }

            if (choose.equals("sd")) {
                System.out.println("Deny List: " + vehicleRentalManager.denyList);
            }

            if (choose.equals("add vehicle")) {

                Scanner input = new Scanner(System.in);

                System.out.println("Name: ");
                String name = input.nextLine();

                System.out.println("Year: ");
                int year = input.nextInt();

                Scanner input2 = new Scanner(System.in);

                System.out.println("Brand: ");
                String brand = input2.nextLine();

                System.out.println("Mileage: ");
                int mileage = input2.nextInt();

                Scanner input3 = new Scanner(System.in);

                System.out.println("Color: ");
                String color = input3.nextLine();

                Vehicle newVehicle = new Vehicle(name, year, brand, mileage, color);

                vehicleRentalManager.addVehicle(newVehicle);

                System.out.println("Successfully added!");

            }

            if (choose.equals("exit")) {
                exit = true;
                System.out.println("bye!");
            }
        } while (!exit);
    }
}
