package ch.noseryoung.blj;

import java.util.Scanner;

/* Konfektionsgrösse Formel: Brustumfang (in cm) geteilt durch 2.
Formel: Brustumfang / 2 -> für Frauen gilt: Brustumfang / 2 - 6 */

/* Fragt nach User Input -> Scannt User Input -> Fragt ob F oder M -> Switch Case -> berechnet
entweder für F oder M -> Output die Konfektionsgrösse */

public class Main {

    public static void main(String[] args) {

        int GarmentSize;

        System.out.println("Welcome to the Garment Size Calculator!!\n");

        computeGarmentSize();

    }

    public static void computeGarmentSize() {

        int GarmentSize = 0;

        System.out.println("Are you female or male? (M = 1 / F = 2)");
        Scanner scanner = new Scanner(System.in);
        int gender = scanner.nextInt();

        System.out.println("Please Input your chest measurement (in cm): ");
        int chestMeasurement = scanner.nextInt();

        switch (gender) {
            case 1: GarmentSize = chestMeasurement / 2;
                break;
            case 2: GarmentSize = chestMeasurement / 2 - 6;
                break;
            default: System.out.println("Error!! Invalid number.");
                break;
        }

    }
}