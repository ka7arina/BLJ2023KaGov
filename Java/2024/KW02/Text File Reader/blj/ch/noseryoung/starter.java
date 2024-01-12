package blj.ch.noseryoung;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
public class starter {
    public static void main(String[] args) {

                String filePath = "C:\\Users\\katig\\Downloads\\script.txt";
                int wordCount = textfileanalyzer.countWords(filePath);
                int uniqueWords = textfileanalyzer.countUniqueWords(filePath);

                System.out.println("Total words: " + wordCount);
                System.out.println("Unique words: " + uniqueWords);
            }
        }


// try {
//            File myObj = new File("C:\\Users\\katig\\Downloads\\script.txt");
//            Scanner myReader = new Scanner(myObj);
//
//
//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
//               // System.out.println(data); - so the next step should be for the programm to evaluate the data instead of printing it
//            }
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//
