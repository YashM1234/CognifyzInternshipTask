package com.cognifyz.level2.task2;

import java.util.Scanner;
/*
Level-2:
    Task-2:
              Password Strength Checker
    Description:
             Create a program that checks the
             strength of a password. Prompt the user to input a
             password and analyze its strength based on
             certain criteria, such as length, presence of
             uppercase letters, lowercase letters, numbers,
             and special characters. Provide feedback on the
             password strength.
    Skills:
             String manipulation, conditional
             statements.

 */
public class PasswordStrengthChecker {
    public static void main(String[] args) {
        System.out.println("---------------Welcome to Password Strength Checker---------------");
        Scanner userInput = new Scanner(System.in);
        boolean continueChecking = true;

        while (continueChecking) {
            System.out.println("Enter your password: ");
            String password = userInput.next();

            String strengthFeedback = checkPasswordStrength(password);
            System.out.println("Password Strength: \n\t" + strengthFeedback);
            System.out.print("Do you want to continue? (yes/no): ");
            String userChoice = userInput.next().toLowerCase();

            continueChecking = toBeContinue(userChoice, continueChecking);
        }
        userInput.close();
    }

    private static String checkPasswordStrength(String password) {
        int length = password.length();
        boolean hasUpperCase = !password.equals(password.toLowerCase());
        boolean hasLowerCase = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecialChar = !password.matches("[A-Za-z0-9]*");

        if (length < 8 || !hasUpperCase || !hasLowerCase || !hasDigit || !hasSpecialChar) {
            return """
                    Weak: Password does not meet strong password criteria, Bad Choice!
                    \t\t1. Password should be at least 8 characters long.
                    \t\t2. Password should contain at least one uppercase letter.
                    \t\t3. Password should contain at least one lowercase letter.
                    \t\t4. Password should contain at least one digit.
                    \t\t5. Password should contain at least one Special Character.""";
        } else {
            return "Strong: Password meets the criteria for a strong password, Good Choice!.";
        }
    }

    private static boolean toBeContinue(String userChoice, boolean continueChecking) {
        if (userChoice.equals("no")) {
            continueChecking = false;
            System.out.println("Goodbye!, Thanks for visiting Password Strength Checker.");
        } else if (!userChoice.equals("yes")) {
            continueChecking = false;
            System.out.println("Invalid input. Goodbye!, Thanks for visiting Password Strength Checker.");
        }
        return continueChecking;
    }
}
