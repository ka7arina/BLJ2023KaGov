package ch.noseryoung.blj;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // user enters an integer as input, input gets scanned
        System.out.println("Please enter an integer : ");
        int integer = new Scanner(System.in).nextInt();

        // runs the isPalindrome function with an integer as the parameter
        if(isPalindrome(integer)){
            System.out.println(integer + " is a palindrome");
        }else{
            System.out.println(integer + " is not a palindrome");
        }

    }
    public static boolean isPalindrome(int integer) {
        //
        int palindrome = integer;
        int reverse = 0;

        // Compute the reverse
        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        // The integer is palindrome if integer and reverse are equal
        return integer == reverse;

    }
}
