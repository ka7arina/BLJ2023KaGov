package ch.noseryoung.blj;

import java.util.ArrayList;
import java.util.Scanner;

public class Starter {

    public static void main(String[] args) {

        Fish bob = new Fish("Bob", "Male", "Yellow", "Bluecheek Butterflyfish", 5, true, false, 2, 3);
        Fish dylan = new Fish("Dylan", "Male", "Golden", "Goldfish", 7, true, false, 4, 7);
        Fish greg = new Fish("Greg", "Male", "Blue", "Swordfish", 5, true, false, 5, 7);
        Fish lily = new Fish("Lily", "Female", "Pink", "Pink Tetra", 3, false, true, 5,6);

        // erstellt ein neues objekt - aquarium - mit width, length und welche art von wasser es ist
        Aquarium mySaltWaterA = new Aquarium(10, 10, true, false);
        mySaltWaterA.addFish(bob);
        mySaltWaterA.addFish(dylan);

        mySaltWaterA.printAquarium();

        mySaltWaterA.moveFish(dylan, 3, 2);

        mySaltWaterA.printAquarium();

        mySaltWaterA.addFish(greg);

        mySaltWaterA.printAquarium();

        mySaltWaterA.removeFish(greg);

        mySaltWaterA.printAquarium();

        mySaltWaterA.addFish(lily);

        mySaltWaterA.printAquarium();
    }

}
