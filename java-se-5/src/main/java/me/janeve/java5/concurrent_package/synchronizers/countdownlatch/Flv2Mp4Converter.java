package me.janeve.java5.concurrent_package.synchronizers.countdownlatch;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Flv2Mp4Converter {

    private static final int PROCESSING_CHUNK_DURATION = 120;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Enter the duration of the video file in seconds (E.g: 1200)");
        Scanner inputScanner = new Scanner(System.in);

        double totalDuration = inputScanner.nextDouble();
        int totalOperations = (int) Math.ceil(totalDuration/PROCESSING_CHUNK_DURATION);

        CountDownLatch latch = new CountDownLatch(totalOperations);
        for (int i = 0; i < totalOperations; i++) {
            new Flv2Mp4ConversionOperation("Chunk-"+i, latch).start();
        }
        latch.await();
        performPostOperation();
    }

    private static void performPostOperation() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ":\t\tStarting post operation.");
        // Mimicking slow process
        long duration = new Random().nextInt(3000);
        Thread.sleep(duration);
        System.out.println(Thread.currentThread().getName() + ":\t\tCompleted conversion operation(" + duration + "ms).");
    }
}