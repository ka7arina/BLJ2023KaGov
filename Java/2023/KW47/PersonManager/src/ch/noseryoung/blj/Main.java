package ch.noseryoung.blj;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Personen Taylor = new Personen("Taylor", 32, "Reading, Pennsylvania", "American", 01);
        Personen Gracie = new Personen("Gracie", 24, "Los Angeles, California", "American", 02);
        Personen Lexi = new Personen("Lexi", 20, "Los Angeles, California", "American", 03);

        ArrayList<Personen> personenList = new ArrayList<>();
        personenList.add(Taylor);
        personenList.add(Gracie);
        personenList.add(Lexi);


        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(personenList.toString());
        System.out.println("----------------------------------------------------------------------------------------------------------");

        addNewPerson(personenList);

        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(personenList.toString());
        System.out.println("----------------------------------------------------------------------------------------------------------");
    }

        private static void addNewPerson(ArrayList<Personen> personenList) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter details for the new person:");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Place of Birth: ");
            String placeOfBirth = scanner.nextLine();

            System.out.print("Nationality: ");
            String nationality = scanner.nextLine();

            System.out.print("ID: ");
            int id = scanner.nextInt();

            Personen newPerson = new Personen(name, age, placeOfBirth, nationality, id);
            personenList.add(newPerson);

            System.out.println("New person added successfully!");
    }

}