package com.cognifyz.level1.task1;

import java.util.Scanner;
/*
Level-1:
    Task-1:
             Temperature Converter
    Description:
             Create a program that converts
             temperatures between Celsius and
             Fahrenheit. Prompt the user to enter a
             temperature value and the unit of
             measurement, and then perform the
             conversion. Display the converted
             temperature.
    Skills:
             Basic input/output operations,
             arithmetic operations.

 */
public class TemperatureConverter {
    public static void main(String[] args) {
        System.out.println("-------------Welcome to Temperature Converter-------------");

        Scanner userInput = new Scanner(System.in);
        boolean continueConversion = true;

        while(continueConversion) {
            System.out.println("Enter the temperature value: ");
            double temperature = userInput.nextDouble();

            System.out.println("Enter the unit of measurement (C or F): ");
            String unit = userInput.next().toUpperCase();

            convertTemperature(temperature, unit);

            System.out.print("Do you want to continue? (yes/no): ");
            String userChoice = userInput.next().toLowerCase();

            continueConversion = toBeContinue(userChoice, continueConversion);
        }
        userInput.close();
    }

    private static void convertTemperature(double temperature, String unit) {
        if (unit.equals("C")) {
            double convertedTemperature = celsiusToFahrenheit(temperature);
            System.out.println(temperature + " ℃ = " + convertedTemperature + " ℉");
        } else if (unit.equals("F")) {
            double convertedTemperature = fahrenheitToCelsius(temperature);
            System.out.println(temperature + " ℉ = " + convertedTemperature + " ℃");
        } else {
            System.out.println("Invalid unit " + unit + " of measurement, please enter C or F!");
        }
    }

    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    private static boolean toBeContinue(String userChoice, boolean continueConversion) {
        if (userChoice.equals("no")) {
            continueConversion = false;
            System.out.println("Goodbye!, Thanks for visiting Temperature Converter.");
        } else if (!userChoice.equals("yes")) {
            continueConversion = false;
            System.out.println("Invalid input. Goodbye!, Thanks for visiting Temperature Converter.");
        }
        return continueConversion;
    }
}
