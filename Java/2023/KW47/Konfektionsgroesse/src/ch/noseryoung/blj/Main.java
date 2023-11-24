package ch.noseryoung.blj;

import java.util.Scanner;

/* Konfektionsgrösse Formel: Brustumfang (in cm) geteilt durch 2.
Formel: Brustumfang / 2 -> für Frauen gilt: Brustumfang / 2 - 6 */

/* Fragt nach User Input -> Scannt User Input -> Fragt ob F oder M -> Switch Case -> berechnet
entweder für F oder M -> Output die Konfektionsgrösse */

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the Garment Size Calculator!!\n");

        computeGarmentSize();

        System.out.println("This is your Garment Size: " );

    }

    public static void computeGarmentSize() {

        int GarmentSize;

        System.out.println("Are you female or male? (M = 1 / F = 2)");
        Scanner scanner = new Scanner(System.in);
        int gender = scanner.nextInt();

        System.out.println("Please Input your chest measurement (in cm): ");
        int chestMeasurement = scanner.nextInt();

        switch (gender) {
            case 1: GarmentSize = (int)chestMeasurement / 2;
                break;
            case 2: GarmentSize = (int)chestMeasurement / 2 - 6;
                break;
            default: System.out.println("Please Input a Valid number!!!!!!!");
                break;
        }
    }
}