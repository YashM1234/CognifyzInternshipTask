package com.cognifyz.level1.task2;

import java.util.Scanner;
/*
Level-1:
    Task-2:
             Palindrome Checker
    Description:
             Implement a program that checks
             whether a given word or phrase is a palindrome. A
             palindrome is a word or phrase that reads the
             same forwards and backward, ignoring spaces and
             punctuation.
    Skills:
             String manipulation, loops, conditional
             statements.

 */
public class PalindromeChecker {
    public static void main(String[] args) {
        System.out.println("----------Welcome to Palindrome Checker----------");

        Scanner userInput = new Scanner(System.in);
        boolean continueChecking = true;

        while(continueChecking) {
            System.out.println("Enter a word or phrase: ");
            String strInput = userInput.next();

            if (isPalindrome(strInput)) {
                System.out.println("The entered word or phrase is a palindrome!");
            } else {
                System.out.println("The entered word or phrase is not a palindrome!");
            }

            System.out.print("Do you want to continue? (yes/no): ");
            String userChoice = userInput.next().toLowerCase();

            continueChecking = toBeContinue(userChoice, continueChecking);

            userInput.nextLine();
        }
        userInput.close();
    }

    private static boolean isPalindrome(String strInput) {
        String cleanStr = strInput.replaceAll("[^a-zA-Z]", "").toLowerCase();

        int left = 0;
        int right = cleanStr.length() - 1;

        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private static boolean toBeContinue(String userChoice, boolean continueChecking) {
        if (userChoice.equals("no")) {
            continueChecking = false;
            System.out.println("Goodbye!, Thanks for visiting Palindrome Checker.");
        } else if (!userChoice.equals("yes")) {
            continueChecking = false;
            System.out.println("Invalid input. Goodbye!, Thanks for visiting Palindrome Checker.");
        }
        return continueChecking;
    }
}
