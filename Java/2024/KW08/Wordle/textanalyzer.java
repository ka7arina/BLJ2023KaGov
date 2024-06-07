import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class textanalyzer {

    // create constants
    private static final int MAX_ATTEMPTS = 6;
    private static final String GREEN = "\u001B[42m";
    private static final String YELLOW = "\u001B[43m";
    private static final String RESET = "\u001B[0m";
    private static final String GREEN2 = "\u001B[32m";
    private static final String YELLOW2 = "\u001B[33m";
    private static final String BLACK2 = "\u001B[90m";
    private static final String GREY = "\u001B[47m";
    private static final String BLACK = "\u001B[30m";

    public static void wordleMechanic() throws IOException {
        String fileName = "C:/Projects/BLJ2023KaGov/Java/2024/KW08/Wordle/wordlist.txt";
        // puts the data from the file (which was read in filereader.java) into the array list
        ArrayList<String> wordList = filereader.readWordList(fileName);
        String randomWord = filereader.getRandomWord(wordList);

        // makes all the words lowercase
        randomWord = randomWord.toLowerCase();

        if (wordList.isEmpty()) {
            System.out.println("Word list is empty or file not found.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" +
                GREEN2 + " _    _      _                            _____       _    _               _ _      \n" + RESET +
                GREEN2 + "| |  | |    | |                          |_   _|     | |  | |             | | |     \n" + RESET +
                YELLOW2 + "| |  | | ___| | ___ ___  _ __ ___   ___    | | ___   | |  | | ___  _ __ __| | | ___ \n" + RESET +
                YELLOW2 +"| |/\\| |/ _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\   | |/ _ \\  | |/\\| |/ _ \\| '__/ _` | |/ _ \\\n" + RESET +
                BLACK2 + "\\  /\\  /  __/ | (_| (_) | | | | | |  __/   | | (_) | \\  /\\  / (_) | | | (_| | |  __/\n" + RESET +
                BLACK2 + " \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|   \\_/\\___/   \\/  \\/ \\___/|_|  \\__,_|_|\\___|\n" + RESET +
                BLACK2 + "                                                                                    \n" + RESET +
                BLACK2 + "                                                                                    \n" + RESET);

        long beginTime = System.currentTimeMillis();

        boolean gameWon = false;

        for (int attempts = 0; attempts < MAX_ATTEMPTS; attempts++) {
            if (attempts < MAX_ATTEMPTS) {

                String userinput;

                while (true) {
                    System.out.println("Input your guess:");
                    System.out.println("You have " + (MAX_ATTEMPTS - attempts) + " guess(es) left.");
                    userinput = scanner.nextLine();
                    if (userinput.length() != 5) {
                        System.out.println("You can only input 5 letter words!");
                    } else {
                        break;
                    }
                }

                if (userinput.equals(randomWord)) {
                    System.out.println("Congrats! You won!" +
                            "\n" +
                            GREEN2 + "          _       _              \n" + RESET +
                            GREEN2 + "   __  __(_)___  (_)__  ___  ___ \n" + RESET +
                            YELLOW2 + "  / / / / / __ \\/ / _ \\/ _ \\/ _ \\\n" + RESET +
                            YELLOW2 + " / /_/ / / /_/ / /  __/  __/  __/\n" + RESET +
                            BLACK2 + " \\__, /_/ .___/_/\\___/\\___/\\___/ \n" + RESET +
                            BLACK2 + "/____/ /_/                       \n" + RESET);
                    break ;
                }

                StringBuilder hint = new StringBuilder();

                    userinput = userinput.toLowerCase();

                    for (int i = 0; i < userinput.length(); i++) {

                            char guessedChar = userinput.charAt(i);
                            char secretChar = randomWord.charAt(i);

                            if (guessedChar == secretChar) {
                                hint.append(GREEN + " " + guessedChar + " " + RESET); // correct letter correct position
                            } else if (randomWord.contains(String.valueOf(guessedChar))) {
                                hint.append(YELLOW + " " + guessedChar + " " + RESET); // correct letter, wrong position
                            } else {
                                hint.append(GREY + BLACK + " "  + guessedChar + " " + RESET); // incorrect letter
                            }
                        }
                        System.out.println(hint.toString());
                    }
                if (attempts == MAX_ATTEMPTS - 1){
                    System.out.println("\nYou are out of guesses! The word was " + randomWord);
                    achievements.mechanic();
                }

            }
        System.out.println("\nCome back " + YELLOW2 + "TOMORROW " + RESET + "for the next word!!!");

            long endTime = System.currentTimeMillis();
            long difference = endTime - beginTime;

        }
    }




