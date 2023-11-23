package ch.noseryoung.blj;

public class Main {
    public static void main(String[] args) {
        // loops through everything until 9999 and inciments one i for each time it loops
        for (int i = 1; i <= 9999; i++) {
            // string format for '0000', this way you can use '0000', '0001', '0002' etc.
            String formattedNumber = String.format("%04d", i);
            // prints out the now formatted number
            System.out.println(formattedNumber);

        }
    }
}
