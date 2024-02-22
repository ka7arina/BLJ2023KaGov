import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class textanalyzer {

    private static final int MAX_ATTEMPTS = 6;
    private static final String GREEN = "\u001B[0;32m";
    private static final String YELLOW = "\u001B[0;33m";
    private static final String RESET = "\u001B[0;0m";


    private static boolean wordValidation(String word, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equalsIgnoreCase(word)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void wordleMechanic() {
        String fileName = "C:/Projects/BLJ2023KaGov/Java/2024/KW08/Wordle/usa2.txt";
        ArrayList<String> wordList = readWordList(fileName); // Populate wordList
        String randomWord = getRandomWord(wordList);

        randomWord = randomWord.toLowerCase();

        if (wordList.isEmpty()) {
            System.out.println("Word list is empty or file not found.");
            return;
        }

        Scanner scanner = new Scanner(System.in);


        System.out.println("---- Welcome to Wordle ----");



        for (int attempts = 0; attempts < MAX_ATTEMPTS; attempts++) {
            if (attempts < MAX_ATTEMPTS - 1) {
                System.out.println("     Input your guess:");
                System.out.println("You have " + (MAX_ATTEMPTS-attempts) + " guess(es) left.");
                String userinput = scanner.nextLine().trim();


                userinput = userinput.toLowerCase();

                StringBuilder hint = new StringBuilder();

                if (userinput.length() > 5 || userinput.length() < 5) {
                    System.out.println("You can only input 5 letter words!");
                    attempts = -1;
                }

                if (wordValidation(userinput, fileName)) {

                    for (int i = 0; i < userinput.length(); i++) {


                    char guessedChar = userinput.charAt(i);
                    char secretChar = randomWord.charAt(i);

                   if (userinput.equals(randomWord)) {
                        System.out.println("Congrats! You won!");
                        i = 0;
                    } else if (guessedChar == secretChar) {
                        hint.append(GREEN + guessedChar + RESET); // correct letter correct position
                    } else if (randomWord.contains(String.valueOf(guessedChar))) {
                        hint.append(YELLOW + guessedChar + RESET); // correct letter, wrong position
                    } else {
                        hint.append(guessedChar); // incorrect letter
                    }
                }
                System.out.println(hint.toString());
                } else {
                    System.out.println("Input a valid word.");
                    attempts = -1;
                }
            } else {
                System.out.println("You are out of guesses! The word was " + randomWord);
            }

        }
    }

    private static ArrayList<String> readWordList(String fileName) {
        ArrayList<String> wordList = new ArrayList<>();
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();
                if (!word.isEmpty()) {
                    wordList.add(word);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        return wordList;
    }

    private static String getRandomWord(ArrayList<String> wordList) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(wordList.size());
        return wordList.get(randomIndex);
    }

}


