package com.cognifyz.level2.task3.service;

import com.cognifyz.level2.task3.util.OutputFilePath;

import java.io.*;

public class EncryptionProcessor implements FileProcessor{
    private static final int KEY = 3;

    @Override
    public void processFile(String inputFileName) throws IOException{
        try (InputStream inputStream = new FileInputStream(inputFileName);
             OutputStream outputStream = new FileOutputStream(OutputFilePath.generateOutputFilePath(inputFileName, "encrypted"))) {

            byte[] buffer = new byte[ 1024 ];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {

                for (int i = 0; i < bytesRead; i++) {
                    buffer[ i ] = (byte) (buffer[ i ] + KEY);
                }
                outputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("File encrypted successfully!" + "\nFile Saved at: " + OutputFilePath.generateOutputFilePath(inputFileName, "encrypted"));

        }
    }
}

