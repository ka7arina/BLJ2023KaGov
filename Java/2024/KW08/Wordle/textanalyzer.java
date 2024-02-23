import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class textanalyzer {

    // create constants
    private static final int MAX_ATTEMPTS = 6;
    private static final String GREEN = "\u001B[0;32m";
    private static final String YELLOW = "\u001B[0;33m";
    private static final String RESET = "\u001B[0;0m";


    public static void wordleMechanic() throws IOException {
        String fileName = "C:/Projects/BLJ2023KaGov/Java/2024/KW08/Wordle/wordlist.txt";
        ArrayList<String> wordList = filereader.readWordList(fileName);
        String randomWord = filereader.getRandomWord(wordList);

        // makes all the words lowercase
        randomWord = randomWord.toLowerCase();

        if (wordList.isEmpty()) {
            System.out.println("Word list is empty or file not found.");
            return;
        }

        Scanner scanner = new Scanner(System.in);


        System.out.println("---- Welcome to Wordle ----");

        long beginTime = System.currentTimeMillis();

        boolean gameWon = false;


        for (int attempts = 0; attempts < MAX_ATTEMPTS; attempts++) {
            if (attempts < MAX_ATTEMPTS) {

                String userinput;

                while (true) {
                    System.out.println("     Input your guess:");
                    System.out.println("You have " + (MAX_ATTEMPTS - attempts) + " guess(es) left.");
                    userinput = scanner.nextLine();
                    if (userinput.length() != 5) {
                        System.out.println("You can only input 5 letter words!");
                    } else {
                        break;
                    }
                }

                if (userinput.equals(randomWord)) {
                    System.out.println("Congrats! You won!");
                    break ;
                }

                StringBuilder hint = new StringBuilder();


                    userinput = userinput.toLowerCase();


                    for (int i = 0; i < userinput.length(); i++) {


                            char guessedChar = userinput.charAt(i);
                            char secretChar = randomWord.charAt(i);


                            if (guessedChar == secretChar) {
                                hint.append(GREEN + guessedChar + RESET); // correct letter correct position
                            } else if (randomWord.contains(String.valueOf(guessedChar))) {
                                hint.append(YELLOW + guessedChar + RESET); // correct letter, wrong position
                            } else {
                                hint.append(guessedChar); // incorrect letter
                            }
                        }
                        System.out.println(hint.toString());
                    }
                if (attempts == MAX_ATTEMPTS - 1){
                    System.out.println("You are out of guesses! The word was " + randomWord);
                    achievements.mechanic();
                }

            }


            long endTime = System.currentTimeMillis();
            long difference = endTime - beginTime;

        }
    }




