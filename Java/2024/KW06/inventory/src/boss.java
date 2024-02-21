import java.sql.*;
import java.util.Scanner;
import java.math.BigDecimal;
public class boss {


    public static void boss() {

        System.out.println("\033[0;1mIt's good to see you again.\033[0;0m");

        try (Connection conn = DB.connect()) {
            String sql = "SELECT product_id, quantity_available FROM inventory.products WHERE quantity_available < ?";
            int threshold = 5; // Define your low stock threshold here

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, threshold);
                ResultSet rs = pstmt.executeQuery();

                // Display low stock items
                while (rs.next()) {
                    int productId = rs.getInt("product_id");
                    int quantityAvailable = rs.getInt("quantity_available");
                    System.out.println("\u001B[31mProduct ID: " + productId + " is low in stock. Quantity available: " + quantityAvailable + "\u001B[0m");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("\n-----------------------" +
                "\nWhat do you want to do?\n" +
                "(Search \033[0;1m'help'\033[0;0m for commands)");

        Scanner scanner = new Scanner(System.in);

        boolean on = true;


        while (on) {
            String userinput = scanner.nextLine();

            if (userinput.contains("inv")) {
                var sql = "SELECT * " +
                        "FROM inventory.products ORDER BY product_id; ";

                try (var conn = DB.connect();
                     var stmt = conn.createStatement()) {
                    var rs = stmt.executeQuery(sql);


                    System.out.println("product id |       name         |                    description                    | quantity_available |          category          |   price  ");
                    System.out.println("-----------+--------------------+---------------------------------------------------+--------------------+----------------------------+---------------------");

                    while (rs.next()) {
                        int productId = rs.getInt("product_id");
                        String name = rs.getString("name");
                        String description = rs.getString("description");
                        int quantity_available = rs.getInt("quantity_available");
                        String category = rs.getString("category");
                        double price = rs.getDouble("price");

                        // Assuming a console width that can handle this, otherwise this will need to be adjusted.
                        System.out.printf("%-10s | %-18s | %-49s | %-18s | %-26s | %-25s%n",
                                productId, name, description, quantity_available, category, price + " CHF");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (userinput.equals("add new product")) {
                var sql = "INSERT INTO inventory.products (product_id, name, description, quantity_available, category, price) VALUES (?, ?, ?, ?, ?, ?);";

                try (var conn = DB.connect();
                     var pstmt = conn.prepareStatement(sql)) {

                    System.out.println("Enter Product Id: ");
                    int prodinputint = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character


                    System.out.println("Enter Product name: ");
                    String prodinputname = scanner.nextLine();

                    System.out.println("Enter Product description: ");
                    String prodinputdesc = scanner.nextLine();

                    System.out.println("Enter Quantity: ");
                    int prodquantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    System.out.println("Enter Category: ");
                    String prodcategory = scanner.nextLine();


                    System.out.println("Enter Price: ");
                    BigDecimal prodprice = scanner.nextBigDecimal();


                    pstmt.setInt(1, prodinputint);
                    pstmt.setString(2, prodinputname);
                    pstmt.setString(3, prodinputdesc);
                    pstmt.setInt(4, prodquantity);
                    pstmt.setString(5, prodcategory);
                    pstmt.setBigDecimal(6, prodprice);

                    int rowsAffected;
                    rowsAffected = pstmt.executeUpdate();
                    System.out.println(rowsAffected + "product successfully added");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (userinput.equals("update stock")) {
                var sql = "UPDATE inventory.products " +
                        "SET quantity_available = ? " +
                        "WHERE product_id = ?;";

                try (var conn = DB.connect();
                     var pstmt = conn.prepareStatement(sql)) {

                    System.out.println("Please input the id of the product you want to update the stock for");
                    int stockid = scanner.nextInt();

                    System.out.println("Input the updated quantity available:");
                    int quantity = scanner.nextInt();


                    pstmt.setInt(2, stockid);
                    pstmt.setInt(1, quantity);


                    int rowsUpdated = pstmt.executeUpdate();

                    // überprüft ob das Update erfolgreich war
                    if (rowsUpdated > 0) {
                        System.out.println("Stock updated successfully.");
                    } else {
                        System.out.println("Failed to update stock.");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

            if (userinput.equals("remove product")) {
                var sql = "DELETE FROM inventory.products WHERE product_id = ?";

                try (var conn = DB.connect();
                     var pstmt = conn.prepareStatement(sql)) {

                    System.out.println("Please select the id of the product you want to remove");
                    int productid = scanner.nextInt();


                    pstmt.setInt(1, productid);


                    int rowsUpdated = pstmt.executeUpdate();

                    // Überprüfen Sie, ob das Update erfolgreich war
                    if (rowsUpdated > 0) {
                        System.out.println("Removed product successfully");
                    } else {
                        System.out.println("Failed to remove product");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }

            if (userinput.equals("change id")) {
                var sql = "UPDATE inventory.products SET product_id = ? WHERE product_id = ?";

                try (var conn = DB.connect();
                     var pstmt = conn.prepareStatement(sql)) {

                    System.out.println("Which id do you wish to change?");
                    int productid = scanner.nextInt();

                    System.out.println("Please input the updated id:");
                    int oldid = scanner.nextInt();


                    pstmt.setInt(2, productid);
                    pstmt.setInt(1, oldid);


                    int rowsUpdated = pstmt.executeUpdate();

                    // Überprüfen Sie, ob das Update erfolgreich war
                    if (rowsUpdated > 0) {
                        System.out.println("Changed the id successfully");
                    } else {
                        System.out.println("Failed to change the id");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }

            if (userinput.equals("change name")) {
                var sql = "UPDATE inventory.products SET name = ? WHERE product_id = ?";

                try (var conn = DB.connect();
                     var pstmt = conn.prepareStatement(sql)) {

                    System.out.println("Input your updated name:");
                    String prodname = scanner.nextLine();

                    System.out.println("Please input the id of the product you want to rename:");
                    int id = scanner.nextInt();


                    pstmt.setString(1, prodname);
                    pstmt.setInt(2, id);


                    int rowsUpdated = pstmt.executeUpdate();

                    // Überprüfen Sie, ob das Update erfolgreich war
                    if (rowsUpdated > 0) {
                        System.out.println("Renamed successfully");
                    } else {
                        System.out.println("Failed to rename");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (userinput.equals("change price")) {
                var sql = "UPDATE inventory.products SET price = ? WHERE product_id = ?";

                try (var conn = DB.connect();
                     var pstmt = conn.prepareStatement(sql)) {

                    System.out.println("Please input the id of the product you want to change the price of:");
                    int id = scanner.nextInt();

                    System.out.println("Input your updated price:");
                    BigDecimal newprice = scanner.nextBigDecimal();

                    pstmt.setBigDecimal(1, newprice);
                    pstmt.setInt(2, id);


                    int rowsUpdated = pstmt.executeUpdate();

                    // Überprüfen Sie, ob das Update erfolgreich war
                    if (rowsUpdated > 0) {
                        System.out.println("Updated price successfully");
                    } else {
                        System.out.println("Failed to update price");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (userinput.equals("change category")) {
                var sql = "UPDATE inventory.products SET category = ? WHERE product_id = ?";

                try (var conn = DB.connect();
                     var pstmt = conn.prepareStatement(sql)) {

                    System.out.println("Input your updated category:");
                    String newcat = scanner.nextLine();

                    System.out.println("Id of the product you want to change the category of:");
                    int id = scanner.nextInt();


                    pstmt.setString(1, newcat);
                    pstmt.setInt(2, id);


                    int rowsUpdated = pstmt.executeUpdate();

                    // Überprüfen Sie, ob das Update erfolgreich war
                    if (rowsUpdated > 0) {
                        System.out.println("Updated category successfully");
                    } else {
                        System.out.println("Failed to update category");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (userinput.contains("change desc")) {
                var sql = "UPDATE inventory.products SET description = ? WHERE product_id = ?";

                try (var conn = DB.connect();
                     var pstmt = conn.prepareStatement(sql)) {

                    System.out.println("Input your updated description");
                    String newdesc = scanner.nextLine();

                    System.out.println("Please input the id of the product you want to change the description of:");
                    int id = scanner.nextInt();


                    pstmt.setString(1, newdesc);
                    pstmt.setInt(2, id);


                    int rowsUpdated = pstmt.executeUpdate();

                    // Überprüfen Sie, ob das Update erfolgreich war
                    if (rowsUpdated > 0) {
                        System.out.println("Updated description successfully");
                    } else {
                        System.out.println("Failed to update description");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (userinput.equals("help")) {

                System.out.println("\033[0;1m" + "✧˚ ༘ ⋆｡ ˚ Welcome to the ₊⊹ ⋆⭒˚｡⋆ જ⁀➴\033[0;0m" +
                        "\n" +
                        "  _____ _                _    _      _                      _            \n" +
                        " |_   _| |              | |  | |    | |                    | |           \n" +
                        "   | | | | _____  __ _  | |__| | ___| |_ __   ___ ___ _ __ | |_ ___ _ __ \n" +
                        "   | | | |/ / _ \\/ _` | |  __  |/ _ \\ | '_ \\ / __/ _ \\ '_ \\| __/ _ \\ '__|\n" +
                        "  _| |_|   <  __/ (_| | | |  | |  __/ | |_) | (_|  __/ | | | ||  __/ |   \n" +
                        " |_____|_|\\_\\___|\\__,_| |_|  |_|\\___|_| .__/ \\___\\___|_| |_|\\__\\___|_|   \n" +
                        "                                      | |                                \n" +
                        "                                      |_|                                \n\n");
                System.out.println("Commands:\n");
                System.out.println("-------------------------------------------------------------------\n");
                System.out.println("\033[0;1m'inventory/inv'\033[0;0m -> Shows the stores current inventory\n");
                System.out.println("\033[0;1m'add new product'\033[0;0m -> Adds a new product to the inventory\n");
                System.out.println("\033[0;1m'remove product'\033[0;0m -> Removes a product from the inventory\n");
                System.out.println("\033[0;1m'update stock'\033[0;0m -> Updates the stock of an item\n");
                System.out.println("\033[0;1m'change id'\033[0;0m -> Changes the id of a product\n");
                System.out.println("\033[0;1m'change name'\033[0;0m -> Changes the name of a product\n");
                System.out.println("\033[0;1m'change price'\033[0;0m -> Changes the price of a product\n");
                System.out.println("\033[0;1m'change category'\033[0;0m -> Changes the category of a product\n");
                System.out.println("\033[0;1m'change desc'\033[0;0m -> Changes the description of a product\n");
                System.out.println("\033[0;1m'reorder'\033[0;0m -> Reorder items from the warehouse and restock them (includes cool animation)\n");
                System.out.println("-------------------------------------------------------------------\n");
            }

            if (userinput.contains("reorder")) {

                var sql = "UPDATE inventory.products SET quantity_available = 100 WHERE product_id = ?;";

                try (var conn = DB.connect();
                     var pstmt = conn.prepareStatement(sql)) {

                    System.out.println("Please input the id of the product you would like to reorder:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character


                    pstmt.setInt(1, id);

                    System.out.println("Reordering");
                    Loading.loadingAnimationWithTimer(10000);

                    System.out.println("Would you like to restock? (yes/no");
                    String restockinput = scanner.nextLine();

                    if(restockinput.equals("yes")) {

                        System.out.println("Restocking");
                        Loading.loadingAnimationWithTimer(5000);
                        int rowsUpdated = pstmt.executeUpdate();

                        // Überprüfen Sie, ob das Update erfolgreich war
                        if (rowsUpdated > 0) {
                            System.out.println("Restocked!");
                        } else {
                            System.out.println("Failed to restocked");
                        }
                    } else {
                        System.out.println("You can manually restock it the next time!");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(userinput.equals("logout")) {
                System.out.println("Bye boss!");
                login.login();
            }
        }
    }

}

