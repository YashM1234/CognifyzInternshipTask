package com.cognifyz.level1.task4;

import java.security.SecureRandom;
import java.util.Scanner;
/*
Level-1:
    Task-4:
             Random Password Generator
    Description:
             Build a program that generates a
             random password for the user. Prompt the user to
             enter the desired length of the password and
             specify whether it should include numbers,
             lowercase letters, uppercase letters, and special
             characters. Generate the password accordingly
             and display it to the user.
    Skills:
             Random number generation, string
             manipulation, user input.

 */
public class RandomPasswordGenerator {
    public static void main(String[] args) {
        System.out.println("----------Welcome to Random Password Generator----------");

        Scanner userInput = new Scanner(System.in);
        boolean generateNext = true;

        while (generateNext){
            System.out.println("Enter the length of the password: ");
            int passwordLength = userInput.nextInt();

            System.out.print("Include numbers? (yes/no): ");
            boolean includeNumbers = userInput.next().equalsIgnoreCase("yes");

            System.out.print("Include lowercase letters? (yes/no): ");
            boolean includeLowercase = userInput.next().equalsIgnoreCase("yes");

            System.out.print("Include uppercase letters? (yes/no): ");
            boolean includeUppercase = userInput.next().equalsIgnoreCase("yes");

            System.out.print("Include special characters? (yes/no): ");
            boolean includeSpecialCharacters = userInput.next().equalsIgnoreCase("yes");

            if (!includeNumbers && !includeLowercase && !includeUppercase && !includeSpecialCharacters) {
                System.out.println("Please include at least one type of character (numbers, lowercase, " +
                        "uppercase, or special characters) to generate password!");
                continue;
            }

            String password = generateRandomPassword(passwordLength, includeNumbers, includeLowercase, includeUppercase, includeSpecialCharacters);

            System.out.println("Generated password: " + password);

            System.out.print("Do you want to continue? (yes/no): ");
            String userChoice = userInput.next().toLowerCase();

            generateNext = toBeContinue(userChoice, generateNext);

        }
        userInput.close();
    }

    private static String generateRandomPassword(int passwordLength, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean includeSpecialCharacters) {
        String numbers = "0123456789";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

        StringBuilder validCharacters = new StringBuilder();

        if (includeNumbers) {
            validCharacters.append(numbers);
        }

        if (includeLowercase) {
            validCharacters.append(lowercaseLetters);
        }

        if (includeUppercase) {
            validCharacters.append(uppercaseLetters);
        }

        if (includeSpecialCharacters) {
            validCharacters.append(specialCharacters);
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(validCharacters.length());
            password.append(validCharacters.charAt(randomIndex));
        }
        return password.toString();
    }

    private static boolean toBeContinue(String userChoice, boolean generateNext) {
        if (userChoice.equals("no")) {
            generateNext = false;
            System.out.println("Goodbye!, Thanks for visiting Random Password Generator.");
        } else if (!userChoice.equals("yes")) {
            generateNext = false;
            System.out.println("Invalid input. Goodbye!, Thanks for visiting Random Password Generator.");
        }
        return generateNext;
    }
}
