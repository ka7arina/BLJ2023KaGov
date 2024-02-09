package blj.ch.noseryoung;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

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

    public static HashMap<String, Integer> wordFrequency(String filePath) {
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);

            HashMap<String, Integer> wordFrequencyMap = new HashMap<>();

            while (myReader.hasNext()) {
                String word = myReader.next().replaceAll("[^a-zA-Z0-9]", "");
                if (!word.isEmpty()) {
                    wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                }
            }

            myReader.close();

            wordFrequencyMap = wordFrequencyMap.entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            return wordFrequencyMap;
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void writeResultsToFile(String outputFilePath, String originalText, int wordCount, int uniqueWordCount, Map<String, Integer> wordFrequencyMap) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {
            writer.println("Original Text:");
            writer.println(originalText);
            writer.println();

            writer.println("[Datum / Uhrzeit] [Name der gelesenen Datei]\n--------------------------------------------");
            writer.println("Number of unique words: " + uniqueWordCount);
            writer.println("\nTotal number of words:  " + wordCount);

            writer.println("Word\tFrequency");
            for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
                writer.println(entry.getKey() + "\t" + entry.getValue());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


