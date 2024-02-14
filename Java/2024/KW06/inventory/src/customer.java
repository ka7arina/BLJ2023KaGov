import java.sql.SQLException;
import java.util.Scanner;
public class customer {

    public static void customer() {
        boolean on = true;

        int counter = 0;
        int[] ids = new int[100];
        double wallet = 500.00;
        double total = 0;

        while (on) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("-----------------------" +
                    "\nWhat do you want to do?\n" +
                    "(Search \033[0;1m'help'\033[0;0m for commands)");
            String userinput = scanner.nextLine();


            if (userinput.equals("show products")) {
                ProductDB.showproducts();
            }

            if (userinput.equals("add")) {
                System.out.println("Which product do you want to add to your cart?");
                String productinput = scanner.nextLine();

                int productId = Integer.parseInt(productinput); // Assuming productinput is the product ID input by the user
                int quantityAvailable = ProductDB.checkstock(productId);
                if (quantityAvailable < 1) {
                    System.out.println("This item is out of stock!");
                } else {

                    int prodinput = Integer.parseInt(productinput);

                    ids[counter] = prodinput;
                    counter += 1;
                    System.out.println("You have " + counter + " Product(s) in your cart");
                }
            }

            if (userinput.equals("remove")) {
                if (counter == 0) {
                    System.out.println("Your cart is empty. Nothing to remove.");
                } else {
                    System.out.println("Which product do you want to remove from your cart?");
                    String productinput = scanner.nextLine();

                    int productId = Integer.parseInt(productinput); // Assuming productinput is the product ID input by the user

                    // Check if the product ID exists in the cart
                    boolean found = false;
                    for (int i = 0; i < counter; i++) {
                        if (ids[i] == productId) {
                            found = true;
                            // Shift remaining elements to the left
                            for (int j = i; j < counter - 1; j++) {
                                ids[j] = ids[j + 1];
                            }
                            counter--;
                            System.out.println("Product removed from your cart.");
                            break; // Exit the loop once the product is found and removed
                        }
                    }

                    if (!found) {
                        System.out.println("Product not found in your cart.");
                    }
                }
            }

            if (userinput.equals("check out")) {

                int second = counter;

                if (counter == 0) {
                    System.out.println("You havent even put anything into your cart");
                }

                for (; counter > 0; ) {
                    counter -= 1;
                    total += ProductDB.searchbyid(ids[counter]);
                    int rows = ProductDB.update(-1, ids[counter]);
                }
                System.out.println("Your total is " + total + " CHF");


                if (wallet > total) {
                    wallet -= total;

                    System.out.println("\u001B[33mYou now have " + wallet + " CHF in your wallet!\u001B[0m");

                } else {
                    System.out.println("\u001B[31mYou don't have enough money for this!\u001B[0m");
                    counter = second;
                    for (; second > 0; ) {
                        second -= 1;
                        ProductDB.update(1, ids[second]);
                    }
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
                System.out.println("\033[0;1m'show products'\033[0;0m -> Shows all available products and their price");
                System.out.println("\033[0;1m'add'\033[0;0m and after it asks you which id: "
                        + "\033[0;1m'[product id]'\033[0;0m" + " -> Add items to your cart");
                System.out.println("\033[0;1m'check out'\033[0;0m -> Buy/pay the products currently in your cart\n");
                System.out.println("-------------------------------------------------------------------\n");
            }
        }
    }
}
