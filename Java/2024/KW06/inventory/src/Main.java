import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (var ignored = DB.connect()) {
            System.out.println("Connected to the PostgreSQL database.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        logo.logo();
        login.login();
        }
    }
