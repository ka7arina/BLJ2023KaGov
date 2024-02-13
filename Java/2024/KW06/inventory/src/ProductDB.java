
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductDB {

    public static void showproducts() {
        var sql = "SELECT product_id, name, price " +
                "FROM inventory.products ";

        try (var conn = DB.connect();
             var stmt = conn.createStatement()) {
            var rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                System.out.println(productId + ". " + name + " - " + price + " CHF");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static double searchbyid(int id) {
        var sql = "SELECT price FROM inventory.products WHERE product_id = ?";
        double price = 0;

        try (var conn = DB.connect()) {
            var pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            var rs = pstmt.executeQuery();

            if (rs.next()) {
                price = rs.getDouble("price");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return price;
    }


    public static int update(int add, int id) {
        var sql = "UPDATE inventory.products " +
                "SET quantity_available = quantity_available + ? " +
                "WHERE product_id = ?";

        int affectedRows = 0;

        try (var conn = DB.connect();
             var pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, add);
            pstmt.setInt(2, id);
            affectedRows = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public static int checkstock(int productId) {
        var sql = "SELECT quantity_available FROM inventory.products WHERE product_id = ?";
        int quantityAvailable = 0;

        try (var conn = DB.connect();
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productId); // Correctly use productId to filter the query

            var rs = pstmt.executeQuery();

            if (rs.next()) {
                quantityAvailable = rs.getInt("quantity_available");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quantityAvailable;
    }

}



