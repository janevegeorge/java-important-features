package me.janeve.java5.scanner_class;

import java.util.Scanner;

public class ConsoleScannerExamples {
    private static final String IPv4_PATTERN = "((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

    public static void main(String[] args) {
        read();
    }

    static void read() {
        Scanner scanner = new Scanner(System.in);
        readString(scanner);
        readInt(scanner);
        readDouble(scanner);
        readPattern(scanner);
    }

    private static void readPattern(Scanner scanner) {
        System.out.println("Enter a single IPv4 address.");
        if(scanner.hasNext(IPv4_PATTERN)) {
            String ipAddress = scanner.next(IPv4_PATTERN);
            System.out.println("IPv4: " + ipAddress);
        } else {
            System.out.println("No IPv4 detected");
        }
    }

    private static void readDouble(Scanner scanner) {
        System.out.println("Enter a single double.");
        if(scanner.hasNextDouble()) {
            double inputDbl = scanner.nextDouble();
            System.out.println("double: " + inputDbl);
        } else {
            System.out.println("Not a double");
        }
    }

    private static void readInt(Scanner scanner) {
        System.out.println("Enter a single int.");
        if(scanner.hasNextInt()) {
            int inputInt = scanner.nextInt();
            System.out.println("int: " + inputInt);
        } else {
            System.out.println("Not an integer");
        }
    }

    private static void readString(Scanner scanner) {
        System.out.println("Enter a single string.");
        String inputStr = scanner.next();
        System.out.println("String: " + inputStr);
    }
}
