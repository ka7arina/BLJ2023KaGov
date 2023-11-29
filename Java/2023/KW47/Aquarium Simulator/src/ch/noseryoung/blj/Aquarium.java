package ch.noseryoung.blj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Aquarium {
    boolean isSaltWater;

    // 2d array erstellt
    private int[][] aquarium;

    // array list erstellt
    private ArrayList<Fish> fishes = new ArrayList<>();

    private ArrayList<Decor> decorations = new ArrayList<>();

    public Aquarium() {

    }

    // constructor
    public Aquarium(int width, int length, boolean isSaltWater) {
        this.isSaltWater = isSaltWater;
        // sagt das dieses aquarium so breit und so lang ist
        this.aquarium = new int[width][length];
    }

    // added einen fish in das aquarium -> 1 heisst ja das das wasser mit dem fish symbol replaced wird, deswegen kommt danach eine 1
    public void addFish(Fish newFish) {
        // wenn isSaltWater = true
        if (isSaltWater == newFish.isSaltWater()) {
            // add the fish like normal
            fishes.add(newFish);
            aquarium[newFish.getyPos()][newFish.getxPos()] = 1;
            // if isSaltWater is not true (false) then display an error message
            System.out.println("Your fish " + newFish.getName() + " has been added.");
        } else {
            System.out.println("Error! You cannot add a freshwater fish (" + newFish.getName() + ") into a saltwater aquarium");
        }
    }

    // entferne einen fish vom aquarium function - 0 weil 0 heisst das irgendetwas das darin steht mit dem water replaced wird
    public void removeFish(Fish newFish) {
        fishes.remove(newFish);
        System.out.println("Your fish " + newFish.getName() + " has been removed.");
        aquarium[newFish.getyPos()][newFish.getxPos()] = 0;
    }

    // bewege einen fisch von einer position im aquarium zu einem anderen
    public void moveFish(Fish newFish, int x, int y) {
        // finds the already existing fish
        aquarium[newFish.getyPos()][newFish.getxPos()] = 0;
        // finds the index of the existing fish
        int index = findIndexOfFish(newFish);
        // gets index of the fish and sets the x position
        fishes.get(index).setxPos(x);
        // gets index of the fish and sets the y position
        fishes.get(index).setyPos(y);
        // gets the new positions of the fish and places it there
        aquarium[newFish.getyPos()][newFish.getxPos()] = 1;
    }

    public int findIndexOfFish(Fish fish) {
        int index = 0;

        // looks for the fish in our fishes list and sees current fish
        for (Fish currentFish: fishes) {
            // if the current fish equals the fish we're looking for it returns the index of that fish
            if (currentFish.equals(fish)) {
                return index;
                // if NOT then it goes up another index and looks for the fish we need again until it finds it
            } else {
                index++;
            }
        }
        return index;
    }

    public void addDecor(Decor newDecor) {
            decorations.add(newDecor);
            aquarium[newDecor.getyPos()][newDecor.getxPos()] = 2;
            System.out.println("Your decor " + newDecor.getType() + " has been added.");
    }

    public void removeDecor(Decor newDecor) {
        decorations.remove(newDecor);
        System.out.println("Your decor " + newDecor.getType() + " has been removed.");
        aquarium[newDecor.getyPos()][newDecor.getxPos()] = 0;
    }

    // print aquarium funktion
    public void printAquarium() {
        for (int i = 0; i < aquarium.length; i++) {
            System.out.print("▓▓");
        }
        System.out.println("▓");
        String aquariumAsString = Arrays.deepToString(aquarium);
        aquariumAsString = aquariumAsString.replace("[[", "▓").replace("], [", "▓\n▓").replace(", ", " ").replace("]]",
                "▓").replace("0", "~").replace("1", "\uD80C\uDDFC").replace("2","✪");
        System.out.println(aquariumAsString);

        for (int i = 0; i < aquarium.length; i++) {
            System.out.print("▓▓");
        }
        System.out.println("▓");
    }

}
