// AuthenticationLogic.java
import java.util.Scanner;

public class AuthenticationLogic {
    public static boolean authenticate(String role, String password) {
        // Perform authentication logic here
        // You can use a database or hardcoded values for simplicity
        if ("boss".equals(role) && "boss_password".equals(password)) {
            return true;
        } else if ("customer".equals(role) && "customer_password".equals(password)) {
            return true;
        }
        return false;
    }
}
