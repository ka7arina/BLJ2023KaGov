package ch.noseryoung.blj;

public class Main {
    public static void main(String[] args) {
        System.out.println("Summe = " + summe(27));
    }

    public static int summe(int n)
    {
        int summe = 0; // this variable will be used to store the cumulative sum of numbers.
        for (int i = 3; i <= 27; i++) // for loop that initializes a variable i to 3, continues as
            // long as i is less than or equal to 27, and makes i one higher by 1 in each iteration.
        {
            summe = summe + i; // in each iteration of the loop the current sum gets added to the 'summe' variable
        }
        return summe; // returns the final value of 'summe'
    }
}