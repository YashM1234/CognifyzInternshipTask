package com.cognifyz.level1.task3;

import java.util.Scanner;
/*
Level-1:
    Task-3:
             Student Grade Calculator
    Description:
             Create a program that
             calculates and displays the average grade of
             a student. Prompt the user to enter the
             number of grades to be entered, and then
             input each grade. Calculate the average and
             display it to the user.
    Skills:
             Loops, arrays, basic arithmetic
             operations.

 */
public class StudentGradeCalculator {
    public static void main(String[] args) {
        System.out.println("----------Welcome to Student Grade Calculator----------");

        Scanner userInput = new Scanner(System.in);
        boolean nextStudent = true;
        while (nextStudent){
            System.out.println("Enter the number of grades: ");
            int numberOfGrades = userInput.nextInt();

            if(numberOfGrades <= 0){
                System.out.println("Please enter a valid positive number of grades!");
                continue;
            }

            int[] grades = getGrades(userInput, numberOfGrades);

            int totalGrade = getTotalGrade(grades);

            double averageGrade = getAverageGrade(numberOfGrades, totalGrade);
            System.out.println("Average grade: " + averageGrade);

            System.out.print("Do you want to continue? (yes/no): ");
            String userChoice = userInput.next().toLowerCase();

            nextStudent = toBeContinue(userChoice, nextStudent);

        }
        userInput.close();
    }

    private static double getAverageGrade(int numberOfGrades, int totalGrade) {
        return (double) totalGrade / numberOfGrades;
    }

    private static int getTotalGrade(int[] grades) {
        int totalGrade = 0;
        for(int grade: grades){
            totalGrade = totalGrade + grade;
        }
        return totalGrade;
    }

    private static int[] getGrades(Scanner userInput, int numberOfGrades) {
        int[] grades = new int[numberOfGrades];
        for(int i = 0; i < grades.length; i++){
            System.out.println("Enter the grade " + (i + 1) + ": ");
            int grade = userInput.nextInt();
            grades[i] = grade;
        }
        return grades;
    }

    private static boolean toBeContinue(String userChoice, boolean nextStudent) {
        if (userChoice.equals("no")) {
            nextStudent = false;
            System.out.println("Goodbye!, Thanks for visiting Student Grade Calculator.");
        } else if (!userChoice.equals("yes")) {
            nextStudent = false;
            System.out.println("Invalid input. Goodbye!, Thanks for visiting Student Grade Calculator.");
        }
        return nextStudent;
    }
}
