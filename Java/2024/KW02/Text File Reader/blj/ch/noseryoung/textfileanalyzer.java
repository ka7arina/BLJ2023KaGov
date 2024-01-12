package blj.ch.noseryoung;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class textfileanalyzer {

    public static int countWords(String filePath) {
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);

            int countWords = 0;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                countWords += data.split("\\s+").length;
            }

            myReader.close();

            return countWords;
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static int countUniqueWords(String filePath) {
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);

            int countUniqueWords = 0;
            Set<String> uniqueWords = new HashSet<>();

            while (myReader.hasNext()) {
                String data = myReader.next();
                String[] words = data.split("[!-~]*\\s+");

                for (String word : words) {
                    uniqueWords.add(word);
                }
            }

            myReader.close();

            return uniqueWords.size();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}

