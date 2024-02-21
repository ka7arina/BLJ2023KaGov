import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class filereader {
    private static final int MAX_ATTEMPTS = 6;
        public static void fileReader() {
            String fileName = "C:/Projects/BLJ2023KaGov/Java/2024/KW08/Wordle/wordlist.txt";

                ArrayList<String> wordList = readWordList("wordlist.txt");

                if (wordList.isEmpty()) {
                    System.out.println("Word list is empty or file not found.");
                    return;
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
        }

