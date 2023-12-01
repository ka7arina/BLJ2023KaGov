import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        HashMap<Character, String> myHashMap = new HashMap<>();
        myHashMap.put('A', ".-");
        myHashMap.put('B', "-...");
        myHashMap.put('C', "-.-.");
        myHashMap.put('D', "-..");
        myHashMap.put('E', ".");
        myHashMap.put('F', "..-.");
        myHashMap.put('G', "--.");
        myHashMap.put('H', "....");
        myHashMap.put('I', "..");
        myHashMap.put('J', ".---");
        myHashMap.put('K', "-.-");
        myHashMap.put('L', ".-..");
        myHashMap.put('M', "--");
        myHashMap.put('N', "-.");
        myHashMap.put('O', "---");
        myHashMap.put('P', ".--.");
        myHashMap.put('Q', "--.-");
        myHashMap.put('R', ".-.");
        myHashMap.put('S', "...");
        myHashMap.put('T', "-");
        myHashMap.put('U', "..-");
        myHashMap.put('V', "...-");
        myHashMap.put('W', ".--");
        myHashMap.put('X', "-..-");
        myHashMap.put('Y', "-.--");
        myHashMap.put('Z', "--..");

        System.out.println("Welcome to the morse code converter!!!¨\n" +
                "Please Input your text here: ");

        Scanner scanner = new Scanner(System.in);
        String inputMessage = scanner.nextLine().toUpperCase(); // Read a line of text and convert to uppercase

        StringBuilder morseCodeBuilder = new StringBuilder();

        for (char c : inputMessage.toCharArray()) {
            if (myHashMap.containsKey(c)) {
                morseCodeBuilder.append(myHashMap.get(c)).append(" ");
            } else if (c == ' ') {
                morseCodeBuilder.append(" ");
            } else {
                System.out.println("Invalid character: " + c);
            }
        }

        System.out.println("Your message in Morse code: " + morseCodeBuilder.toString().trim());
    }
}

