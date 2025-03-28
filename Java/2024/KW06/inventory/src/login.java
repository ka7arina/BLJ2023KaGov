import java.util.Scanner;

public class login {

    public static void login() {
        Scanner scanner = new Scanner(System.in);
        boolean login = true;


        while (login) {
            System.out.println("Enter your role ('boss' or 'customer'):");
            String role = scanner.nextLine();

            System.out.println("Enter your password:");
            String password = scanner.nextLine();

            if (AuthenticationLogic.authenticate(role, password)) {
                welcome.welcomeMessage(role);
                login = false;

                if (role.equals("boss") && password.equals("boss!")) {
                    boss.boss();
                } else if (role.equals("customer") && password.equals("customer")) {
                    customer.customer();
                } else {
                    System.out.println("Invalid role or password for the given role.");
                }
            } else {
                System.out.println("Authentication failed. Invalid role or password.");
            }
        }
        scanner.close();


    }
    }
