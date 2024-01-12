package ch.noseryoung.blj;

import java.util.Scanner;

public class Starter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int option;

        Fish bob = new Fish("Bob", "Male", "Yellow", "Bluecheek Butterflyfish", 5, true, 2, 3);
        Fish dylan = new Fish("Dylan", "Male", "Golden", "Goldfish", 7, true, 4, 7);
        Fish greg = new Fish("Greg", "Male", "Blue", "Swordfish", 5, true, 5, 7);
        Fish lily = new Fish("Lily", "Female", "Pink", "Pink Tetra", 3, false, 5, 6);
        Decor seagrass = new Decor("Seagrass",3, 0, 0);
        Decor coral = new Decor("Coral",3, 0, 0);

        // erstellt ein neues objekt - aquarium - mit width, length und welche art von wasser es ist
        Aquarium mySaltWaterA = new Aquarium(10, 10, true);
        mySaltWaterA.addFish(bob);

        System.out.println("------------------------------");
        System.out.println("Welcome to the Aquarium");
        System.out.println("------------------------------\n");

        // do while loop - do this code while the option IS NOT 6, aka the exit option.
        do {

        System.out.println("What would you like to do?\n" +
                "----------------------------\n" +
                "Add a fish: 1\n" +
                "Remove a fish: 2\n" +
                "Print the aquarium: 3\n" +
                "Add decoration: 4\n" +
                "Move a fish: 5\n" +
                "Exit: 6\n");

        option = scanner.nextInt();


            // switch statement welche option man ausführen will und darin noch ein switch statement für den fish
            switch (option) {
                case 1: // add fish
                    System.out.println("Please choose a fish to add (bob, dylan, greg, lily): ");
                    String fishname = scanner.next();
                    switch (fishname) {
                        case "bob":
                            mySaltWaterA.addFish(bob);
                            break;
                        case "dylan":
                            mySaltWaterA.addFish(dylan);
                            break;
                        case "greg":
                            mySaltWaterA.addFish(greg);
                            break;
                        case "lily":
                            mySaltWaterA.addFish(lily);
                            break;
                    }
                    break;
                case 2: // remove a fish
                    System.out.println("Please choose a fish to remove (bob, dylan, greg, lily): ");
                    String removefish = scanner.next();
                    switch (removefish) {
                        case "bob":
                            mySaltWaterA.removeFish(bob);
                        /* if (if aquarium = empty, then you cant remove a fish) {
                          System.out.println("Error! You cannot remove a fish from an empty aquarium!!!"); */
                            break;
                        case "dylan":
                            mySaltWaterA.removeFish(dylan);
                            break;
                        case "greg":
                            mySaltWaterA.removeFish(greg);
                            break;
                        case "lily":
                            mySaltWaterA.removeFish(lily);
                            break;
                    }
                    break;
                case 3: // print the aquarium
                    mySaltWaterA.printAquarium();
                    break;
                case 4: // add decor
                    System.out.println("Please choose a decoration to add (seagrass, coral): ");
                    String decor = scanner.next();
                    System.out.println("Where would you like to add it?\n" +
                            " x Position: ");
                    int x = scanner.nextInt(); // scans the user location input for x Position
                    System.out.println(" y Position: ");
                    int y = scanner.nextInt(); // scans the user location input for x Position
                    switch(decor) {
                        case "seagrass":
                            mySaltWaterA.addDecor(new Decor("seagrass", 4, x, y)); // adds the seagrass decor
                                break;
                        case "coral":
                            mySaltWaterA.addDecor(new Decor("coral", 3, x, y)); // adds the coral decor
                                break;
                    }
                    break;
                case 5: // move fish
                    System.out.println("Which fish would you like to move?");
                    String move = scanner.next();
                    System.out.println("Where would you like to move the fish?\n" +
                            "x Position: ");
                    int xPos = scanner.nextInt();
                    System.out.println("y Position: ");
                    int yPos = scanner.nextInt();
                    switch(move) {
                        case "bob":
                            mySaltWaterA.moveFish(bob, xPos, yPos);
                            break;
                        case "dylan":
                            mySaltWaterA.moveFish(dylan, xPos, yPos);
                            break;
                        case "greg":
                            mySaltWaterA.moveFish(greg, xPos, yPos);
                            break;
                        case "lily":
                            mySaltWaterA.moveFish(lily, xPos, yPos);
                            break;
                    }
                    break;
                case 6:
                    // exit, prints out an exit message and ends the program
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("Thank you for using the Aquarium Simulator!!! Until next time <3");
                    System.out.println("-----------------------------------------------------------------");
                        break;
                case 10: // random secret case that shows up if someone accidentally chooses the case number
                    System.out.println("SHHHH! You found the secret 7th option!\n\n\n" +
                            "Now go back to the ACTUAL options xx\n\n");
                default:
                    System.out.println("Error! This case doesn't exist!");
            }
        } while (option !=6);

    }
}

