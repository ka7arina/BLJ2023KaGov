package ch.noseryoung.blj;

import java.util.Scanner;

/* Konfektionsgrösse Formel: Brustumfang (in cm) geteilt durch 2.
Formel: Brustumfang / 2 -> für Frauen gilt: Brustumfang / 2 - 6 */

/* Fragt nach User Input -> Scannt User Input -> Fragt ob F oder M -> Switch Case -> berechnet
entweder für F oder M -> Output die Konfektionsgrösse */

/* Fragt in welcher Height Range man ist -> Rechnet das aus -> Switch Case */

public class Main {

    public static void main(String[] args) {

        int GarmentSize;

        System.out.println("Welcome to the Garment Size Calculator!!\n");

        computeGarmentSize();

    }

    public static void computeGarmentSize() {

        int GarmentSize = 0;
        int temporarySize; // variable for saving the temporarySize before GarmentSize is decided

        System.out.println("Please pick what applies to you:\n" +
                "Female, between 164-170 cm tall = 1\n" +
                "Female, taller than 170 cm = 2\n" +
                "Female, shorter than 164 cm = 3\n" +
                "Male, (normale grösse) = 4\n" +
                "Male, (kurze grösse) = 5\n" +
                "Male, (lange grösse) = 6\n");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        System.out.println("Please Input your chest measurement (in cm): ");
        int chestMeasurement = scanner.nextInt();


        switch (option) {
            case 1: GarmentSize = chestMeasurement / 2 - 6;
                break;
            case 2: temporarySize = chestMeasurement / 2 - 6;
                    GarmentSize = temporarySize + temporarySize;
                break;
            case 3: GarmentSize = chestMeasurement / 2 / 2 - 6;
                break;
            case 4: GarmentSize = chestMeasurement / 2;
                break;
            case 5: GarmentSize = chestMeasurement / 2 / 2;
                break;
            case 6: GarmentSize = (chestMeasurement - 1) * 2;
                break;
            default: System.out.println("Please Input a Valid number!!!!!!!");
                break;
        }
            System.out.println("This is your Garment Size: " + GarmentSize);
    }
}