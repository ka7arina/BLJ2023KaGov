package blj.ch.noseryoung;

import java.util.HashMap;

public class starter {
    public static void main(String[] args) {
        String filePath = "C:\\Projects\\BLJ2023KaGov\\Java\\2024\\KW02\\Text File Reader\\script.txt";
        int wordCount = textfileanalyzer.countWords(filePath);
        int uniqueWords = textfileanalyzer.countUniqueWords(filePath);
        HashMap<String, Integer> frequentWords = textfileanalyzer.wordFrequency(filePath);

        // Example usage to write results to a file
        String outputFilePath = "C:\\Projects\\BLJ2023KaGov\\Java\\2024\\KW02\\Text File Reader\\script_evaluate.txt";
        String originalText = "C:\\Projects\\BLJ2023KaGov\\Java\\2024\\KW02\\Text File Reader\\script.txt"; // You might want to populate this with the original text
        textfileanalyzer.writeResultsToFile(outputFilePath, originalText, wordCount, uniqueWords, frequentWords);

        System.out.println(outputFilePath);
    }
}
