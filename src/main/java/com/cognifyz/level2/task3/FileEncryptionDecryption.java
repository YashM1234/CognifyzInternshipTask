package com.cognifyz.level2.task3;

import com.cognifyz.level2.task3.service.DecryptionProcessor;
import com.cognifyz.level2.task3.service.EncryptionProcessor;
import com.cognifyz.level2.task3.service.FileProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Level-2:
    Task-3:
              File Encryption/Decryption
    Description:
             Create a program that encrypts or
             decrypts the contents of a text file using a simple
             encryption algorithm. Prompt the user to choose
             between encryption or decryption, and input the
             file name or path. Encrypt or decrypt the file
             accordingly and save the result to a new file.
    Skills:
             File handling, string manipulation, basic
             input/output operations.

 */
public class FileEncryptionDecryption {
    public static void main(String[] args) {
        System.out.println("---------------Welcome to File Encryption/Decryption Application---------------");
        boolean continueProcessing = true;
        try (BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
            while (continueProcessing) {
                System.out.println("Choose an option: ");
                System.out.println("1. Encrypt File");
                System.out.println("2. Decrypt File");
                System.out.println("3. Exit");

                System.out.println("Enter your option: ");
                int option = Integer.parseInt(userInput.readLine());
                    switch ( option ) {
                        case 1 -> performOperation(new EncryptionProcessor(), userInput);
                        case 2 -> performOperation(new DecryptionProcessor(), userInput);
                        case 3 -> {
                            continueProcessing = false;
                            System.out.println("Goodbye!, Thanks for visiting File Encryption/Decryption Application");
                        }
                        default -> System.out.println("Invalid option: " + option + "\nPlease select correct option!");
                    }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void performOperation(FileProcessor fileProcessor, BufferedReader userInput){
        try {
            System.out.println("Enter input file path:");
            String inputFileName = userInput.readLine();
            fileProcessor.processFile(inputFileName);
            System.out.println("Operation completed successfully!");
        } catch (IOException ex) {
            System.err.println("Error processing the file: " + ex.getMessage());
        }
    }
}
