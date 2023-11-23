import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your weight in kg");
        int weight = scanner.nextInt();
        System.out.println("Please enter your height in cm");
        int height = scanner.nextInt();
        System.out.println("Please enter your age in years");
        int age = scanner.nextInt();

        double stoffwechselrate;

        System.out.println("Are you male or female?\n" +
                "Press 1 for Male\n" +
                "Press 2 for female");
        int gender = scanner.nextInt();
        switch(gender) {
            case 1:
                stoffwechselrate = 66.47 + 13.7 * weight + 5 * height - 6.8 * age;
                break;
            case 2:
                stoffwechselrate = 655.1 + 9.6 * weight + 1.8 * height - 4.7 * age;
                break;
            default:
                System.out.println("Invalid input. Please enter 1 or 2.");
                return;

        }
        System.out.println("The stoffwechselrate is: " + stoffwechselrate);

        }
    }
