package ch.noseryoung.blj;

import java.util.ArrayList;
import java.util.Scanner;

public class Starter {

    public static void main(String[] args) {

        Fish Bob = new Fish("Bob", "Male", "Yellow", "Bluecheek Butterflyfish", 5, true, false);

        ArrayList<Fish> fishList = new ArrayList();
        fishList.add(Bob);

        System.out.println(fishList.toString());

    }

}
