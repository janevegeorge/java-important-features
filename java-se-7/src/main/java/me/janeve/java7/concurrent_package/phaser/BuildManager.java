package me.janeve.java7.concurrent_package.phaser;

import java.util.Scanner;
import java.util.concurrent.Phaser;

public class BuildManager {

    public static void main(String[] args) {
        System.out.println("How many build jobs to run?");
        Scanner inputScanner = new Scanner(System.in);
        int N = inputScanner.nextInt();

        Phaser ph = new Phaser();
        ph.register();
        BuildManager buildManager = new BuildManager();
        for (int i = 0; i < N; i++) {
            buildManager.buildJob(i, ph);
        }
        ph.arriveAndDeregister();
    }

    private synchronized void buildJob(int num, Phaser ph) {
        BuildJob server = new BuildJob("BuildJob-" + num, ph);
        server.start();
    }

}