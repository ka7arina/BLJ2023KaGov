package ch.noseryoung.blj;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // assigns the information to the person
        Personen Taylor = new Personen("Taylor", 32, "Reading, Pennsylvania", "American", 01);
        Personen Gracie = new Personen("Gracie", 24, "Los Angeles, California", "American", 02);
        Personen Lexi = new Personen("Lexi", 20, "Los Angeles, California", "American", 03);

        // creates an array list -> with an array list you can create functions that add a user input as a new person
        ArrayList<Personen> personenList = new ArrayList<>();
        personenList.add(Taylor);
        personenList.add(Gracie);
        personenList.add(Lexi);

        // welcomes the user
        System.out.println("\n\nWelcome to the Personen Manager!\n");

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        // exit loop false
        boolean exitLoop = false;

        // while loop
        while (!exitLoop) {
            System.out.println("What would you like to do?\n" +
                    "Print the Person List: 1\n" +
                    "Add a new person to the list: 2\n" +
                    "Stop the programm: 3\n");
            System.out.println("Enter a Number");
            int number = myObj.nextInt(); // reads the user input as int because it's a number
            switch(number) {
                case 1: // if 1 is input
                    // prints out the current person list
                    System.out.println("----------------------------------------------------------------------------------------------------------");
                    System.out.println(personenList.toString());
                    System.out.println("----------------------------------------------------------------------------------------------------------");
                    break;
                case 2: // if 2 is input
                    // adds the new person
                    addNewPerson(personenList);
                    break;
                case 3: // if 3 is input
                    System.out.println("Thank you so much for using the Personen Manager!");
                    exitLoop = true; // exit the loop if a different option is entered
            }
        }

    }

    // creates the add person function
        private static void addNewPerson(ArrayList<Personen> personenList) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter details for the new person:");

            // takes the users input for each variable
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

            // adds the new person to the person list
            Personen newPerson = new Personen(name, age, placeOfBirth, nationality, id);
            personenList.add(newPerson);

            System.out.println("New person added successfully!\n");
    }

}