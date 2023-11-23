package ch.noseryoung.blj;

public class Main {
    public static void main(String[] args) {
        int numRows = 7;

        // repeats for the amount of rows there are
        for (int i = 1; i <= numRows; i++) {
            // prints spaces before the stars
            for (int j = 0; j < numRows - i; j++) {
                System.out.print(" ");
            }

            // prints the stars
            for (int k = 0; k < 2 * i - 1; k++) {
                System.out.print("*");
            }

            // Move to the next line after each row
            System.out.println();
        }
        // Print spaces before the stars
        for (int j = 0; j < 2 - j; j++) {
            System.out.print("     ");
            System.out.println("***");
        }
    }
}
