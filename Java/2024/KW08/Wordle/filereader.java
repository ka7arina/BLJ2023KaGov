import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class filereader {
        public static void fileReader() {
            String fileName = "C:/Projects/BLJ2023KaGov/Java/2024/KW08/Wordle/wordlist.txt";

            try {
                // file objekt erstellen
                File file = new File(fileName);

                Scanner scanner = new Scanner(file);

                // zeilenweise die datei einlesen
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }

                scanner.close();
            } catch (FileNotFoundException e) {
                // exception falls die file nicht gefunden werden konnte
                System.out.println("The file could not be found: " + e.getMessage());
            }
        }
    }

