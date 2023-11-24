package ch.noseryoung.blj;

import java.util.Scanner;

/* Konfektionsgrösse Formel: Brustumfang (in cm) geteilt durch 2.
Formel: Brustumfang / 2 -> für Frauen gilt: Brustumfang / 2 - 6 */

/* Fragt nach User Input -> Scannt User Input -> Fragt ob F oder M -> Switch Case -> berechnet
entweder für F oder M -> Output die Konfektionsgrösse */

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Garment Size Calculator!!\n");
        System.out.println("Are you female or male? (M / F)");

        Scanner scanner = new Scanner(System.in);
        String gender = scanner.next();

        System.out.println("Please Input your chest measurement (in cm): ");


    }

    public static void computeGarmentSize() {

    }
}