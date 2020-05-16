package me.janeve.java5.concurrent_package.synchronizers.semaphore;

import java.util.Scanner;

public class BuildManager {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("How many build jobs to run?");
        Scanner inputScanner = new Scanner(System.in);

        BuildManager buildManager = new BuildManager();
        int N = inputScanner.nextInt();

        for (int i = 0; i < N; i++) {
            buildManager.buildJob(i);
        }
    }

    private synchronized void buildJob(int num) throws InterruptedException {
        BuildJob server = new BuildJob("BuildJob-" + num);
        server.start();
    }
}