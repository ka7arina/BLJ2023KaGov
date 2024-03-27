package logic;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Login {

    public void loginLogic() throws InterruptedException {
        System.out.println("Login: ");

        Scanner login = new Scanner(System.in);
        String userName = login.nextLine();

        System.out.println("Do you want to log in as " + userName + "?");

        String userConfirmation = login.nextLine();

        if(userName.equals("admin")) {
            Admin admin = new Admin();
            admin.adminLogic();
        } else if(userName.equals("customer")) {
            Customer customer = new Customer();
            customer.customerLogic();
        } else {

        }

        if(userConfirmation.equals("yes")) {
            System.out.println("Logging you in...");
            TimeUnit.MILLISECONDS.sleep(300);

        } else if(userConfirmation.equals("no")) {
            System.out.println("okay!");
        } else {
            System.out.println("please input a valid answer");
        }
    }

}
