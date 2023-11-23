package ch.noseryoung.blj;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gib die Länge ein");
        int length = scanner.nextInt();
        System.out.println("Bitte gib den Mittendurchmesser ein");
        int centerDiameter = scanner.nextInt();

        double Volumen;

        Volumen = Math.PI / 4 * Math.pow(centerDiameter, 2 ) * length / 10000;

        System.out.println("Das Volumen ist:" + Volumen);
    }
}