package me.janeve.java5.scanner_class;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScannerExamples {

    public static void main(String[] args) {
        read();
    }

    public static void read() {
        System.out.println("Enter a file path to read.");
        String filePath = new Scanner(System.in).nextLine();
        scanFile(filePath);
    }

    private static void scanFile(String filePath) {
        try {
            Scanner fileScanner = new Scanner(new File(filePath));
            int noOfLines = 0;
            while (fileScanner.hasNextLine()) {
                noOfLines++;
                System.out.println("Line no " + noOfLines + " has " + countWordsPerLine(fileScanner.nextLine()) + " words.");
            }

            System.out.println("File '" +filePath+ "' has " + noOfLines + " lines.");

        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

    private static int countWordsPerLine(String line) {
        Scanner lineScanner = new Scanner(line);
        int noOfWords = 0;
        while (lineScanner.hasNext()){
            noOfWords++;
            lineScanner.next();
        }
        return noOfWords;
    }
}