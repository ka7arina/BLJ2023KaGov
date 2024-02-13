public class welcome {
        public static void welcomeMessage(String role) {
            switch (role) {
                case "boss":
                    System.out.println("Welcome Boss!");
                    break;
                case "customer":
                    System.out.println("Welcome to Ikea!");
                    break;
                default:
                    System.out.println("Unknown role!");
                    break;
            }
        }
    }
