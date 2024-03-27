package logic;
import exceptions.DenylistedPersonException;
import exceptions.LeaseLengthCollisionException;
import exceptions.MinorAgeException;
import vehicles.Camper;
import vehicles.Truck;
import java.time.LocalDate;

public class Starter {
    public static void main(String[] args) throws MinorAgeException, DenylistedPersonException, LeaseLengthCollisionException, InterruptedException {

        System.out.println("""
                 ___       __   _______   ___       ________  ________  _____ ______   _______           _________  ________          _________  ___  ___  _______     \s
                |\\  \\     |\\  \\|\\  ___ \\ |\\  \\     |\\   ____\\|\\   __  \\|\\   _ \\  _   \\|\\  ___ \\         |\\___   ___\\\\   __  \\        |\\___   ___\\\\  \\|\\  \\|\\  ___ \\    \s
                \\ \\  \\    \\ \\  \\ \\   __/|\\ \\  \\    \\ \\  \\___|\\ \\  \\|\\  \\ \\  \\\\\\__\\ \\  \\ \\   __/|        \\|___ \\  \\_\\ \\  \\|\\  \\       \\|___ \\  \\_\\ \\  \\\\\\  \\ \\   __/|   \s
                 \\ \\  \\  __\\ \\  \\ \\  \\_|/_\\ \\  \\    \\ \\  \\    \\ \\  \\\\\\  \\ \\  \\\\|__| \\  \\ \\  \\_|/__           \\ \\  \\ \\ \\  \\\\\\  \\           \\ \\  \\ \\ \\   __  \\ \\  \\_|/__ \s
                  \\ \\  \\|\\__\\_\\  \\ \\  \\_|\\ \\ \\  \\____\\ \\  \\____\\ \\  \\\\\\  \\ \\  \\    \\ \\  \\ \\  \\_|\\ \\           \\ \\  \\ \\ \\  \\\\\\  \\           \\ \\  \\ \\ \\  \\ \\  \\ \\  \\_|\\ \\\s
                   \\ \\____________\\ \\_______\\ \\_______\\ \\_______\\ \\_______\\ \\__\\    \\ \\__\\ \\_______\\           \\ \\__\\ \\ \\_______\\           \\ \\__\\ \\ \\__\\ \\__\\ \\_______\\
                    \\|____________|\\|_______|\\|_______|\\|_______|\\|_______|\\|__|     \\|__|\\|_______|            \\|__|  \\|_______|            \\|__|  \\|__|\\|__|\\|_______|
                 ___      ___ _______   ___  ___  ___  ________  ___       _______           ________  _______   ________   _________  ________  ___                   \s
                |\\  \\    /  /|\\  ___ \\ |\\  \\|\\  \\|\\  \\|\\   ____\\|\\  \\     |\\  ___ \\         |\\   __  \\|\\  ___ \\ |\\   ___  \\|\\___   ___\\\\   __  \\|\\  \\                  \s
                \\ \\  \\  /  / | \\   __/|\\ \\  \\\\\\  \\ \\  \\ \\  \\___|\\ \\  \\    \\ \\   __/|        \\ \\  \\|\\  \\ \\   __/|\\ \\  \\\\ \\  \\|___ \\  \\_\\ \\  \\|\\  \\ \\  \\                 \s
                 \\ \\  \\/  / / \\ \\  \\_|/_\\ \\   __  \\ \\  \\ \\  \\    \\ \\  \\    \\ \\  \\_|/__       \\ \\   _  _\\ \\  \\_|/_\\ \\  \\\\ \\  \\   \\ \\  \\ \\ \\   __  \\ \\  \\                \s
                  \\ \\    / /   \\ \\  \\_|\\ \\ \\  \\ \\  \\ \\  \\ \\  \\____\\ \\  \\____\\ \\  \\_|\\ \\       \\ \\  \\\\  \\\\ \\  \\_|\\ \\ \\  \\\\ \\  \\   \\ \\  \\ \\ \\  \\ \\  \\ \\  \\____           \s
                   \\ \\__/ /     \\ \\_______\\ \\__\\ \\__\\ \\__\\ \\_______\\ \\_______\\ \\_______\\       \\ \\__\\\\ _\\\\ \\_______\\ \\__\\\\ \\__\\   \\ \\__\\ \\ \\__\\ \\__\\ \\_______\\         \s
                    \\|__|/       \\|_______|\\|__|\\|__|\\|__|\\|_______|\\|_______|\\|_______|        \\|__|\\|__|\\|_______|\\|__| \\|__|    \\|__|  \\|__|\\|__|\\|_______|   \s

                """);
        // creates all the objects

        VehicleRentalManager vehicleRentalManager = new VehicleRentalManager();

        Person customer1 = new Person("John", "Miller", LocalDate.of(2000, 11, 9), "Heckengasse 2, 7035 Oerlikon", "+41 65 765 283");

        Person customer2 = new Person("Maria", "Smith", LocalDate.of(2018, 6, 25), "Rosengartenstrasse 8, 8037 Zürich", "+41 76 897 65 23");

        vehicleRentalManager.addCustomerList(customer1);
        vehicleRentalManager.addCustomerList(customer2);

        Person denied1 = new Person("Joe", "Biden", LocalDate.of(1980, 7, 11), "The White House", "1-202-456-1111");

        vehicleRentalManager.addPersonToDenyList(denied1);

        Truck truck = new Truck("Mercedes Vita", 1954 - 1 - 1, "Mercedes", 36.7, "White", 580);

        vehicleRentalManager.addVehicle(truck);

        Camper camper = new Camper("Hymermobil", 1957, "HYMER", 20, "White", "Yes", "Yes", 2);
        vehicleRentalManager.addVehicle(camper);

        Contract contract = new Contract(customer1, camper, LocalDate.of(2024, 3, 22), LocalDate.of(2024, 4, 22), "Idek what contract models really are but slay anyways woohoo", 650);

        Contract contract4 = new Contract(customer1, camper, LocalDate.of(2024, 1, 23), LocalDate.of(2024, 1, 24), "juhu", 83000);

        vehicleRentalManager.createContract(contract);
        vehicleRentalManager.createContract(contract4);

        Login login = new Login(vehicleRentalManager);
        login.loginLogic();


    }
}