// AuthenticationLogic.java
import java.util.Scanner;

public class AuthenticationLogic {
    public static boolean authenticate(String role, String password) {
        // Perform authentication logic here
        // You can use a database or hardcoded values for simplicity
        if ("boss".equals(role) && "boss!".equals(password)) {
            return true;
        } else if ("customer".equals(role) && "customer".equals(password)) {
            return true;
        }
        return false;
    }
}
