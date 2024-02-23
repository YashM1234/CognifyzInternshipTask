package com.cognifyz.level2.task3.util;

import java.io.File;

public class OutputFilePath {
    public static String generateOutputFilePath(String inputFileName, String operation) {
        File inputFile = new File(inputFileName);
        String fileNameWithoutExtension = inputFile.getName().replaceFirst("[.][^.]+$", "");

        String extension = "";
        if (inputFileName.lastIndexOf(".") > 0) {
            extension = inputFileName.substring(inputFileName.lastIndexOf("."));
        }

        String outputFileName = fileNameWithoutExtension + "_" + operation + extension;
        return inputFile.getParent() + File.separator + outputFileName;
    }
}
