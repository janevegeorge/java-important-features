package me.janeve.java5.scanner_class;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketStreamScanner {

    public static void main(String[] args) {
        read();
    }

    public static void read() {
        System.out.println("Enter a port number.");
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextInt()){
            int port = scanner.nextInt();
            acceptAndReadFromSocket(port);
        } else {
            System.err.println("Invalid Port Number");
        }
    }

    private static void acceptAndReadFromSocket(int port) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("telnet to 127.0.0.1 " + serverSocket.getLocalPort());

            socket = serverSocket.accept();
            System.out.println("Client connection established.\nType 'exit' to close the connection.");

            Scanner scanner = new Scanner(socket.getInputStream());
            String socketData = scanner.nextLine();
            while (!socketData.equalsIgnoreCase("exit")) {
                System.out.println("RCVD: " + socketData);
                socketData = scanner.nextLine();
            }

        } catch (IOException e) {
            System.err.println("Error opening server socket: " + e.getMessage());
        } finally {
            System.out.println("Bye!");
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {}
            }

            if(serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {}
            }
        }
    }
}