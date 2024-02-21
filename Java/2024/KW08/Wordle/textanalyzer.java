import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
public class textanalyzer {

    private static final int MAX_ATTEMPTS = 6;


    public static void wordleMechanic() {

        String fileName = "C:/Projects/BLJ2023KaGov/Java/2024/KW08/Wordle/wordlist.txt";
        ArrayList<String> wordList = new ArrayList<>();
        String randomWord = getRandomWord(wordList);


        if (wordList.isEmpty()) {
            System.out.println("Word list is empty or file not found.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("---- Welcome to Wordle ----");


        for (int attempts = 0; attempts < MAX_ATTEMPTS; attempts++) {
            if (attempts < MAX_ATTEMPTS - 1) {
                System.out.println("     Input your guess:");
                String userinput = scanner.nextLine();
            } else {
                System.out.println("You are out of guesses! The word was " + randomWord);
            }
        }

    }

    private static ArrayList<String> readWordList(String fileName) {
        ArrayList<String> wordList = new ArrayList<>();
        File file = new File(fileName);
        String randomWord = getRandomWord(wordList);

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
