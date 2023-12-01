package ch.noseryoung.blj;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the Leap Year Tester!\n" +
                "Input the year you want to test: ");

        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        boolean isLeapYear = leapYear(year);

        if (isLeapYear) {
            System.out.println(year + " is a leap year!");
        } else {
            System.out.println(year + " is not a leap year.");
        }

    }

    public static boolean leapYear(int year) {


        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }

}


