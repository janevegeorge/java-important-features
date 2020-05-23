package me.janeve.java5.concurrent_package.synchronizers.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Flv2Mp4ConversionOperation extends Thread {

    private final CountDownLatch latch;

    public Flv2Mp4ConversionOperation(String name, CountDownLatch latch){
        super(name);
        this.latch = latch;
    }

    @Override
    public void run() {
        convert();
        latch.countDown();
        cleanup();
    }

    private void convert() {
        try {
            System.out.println(getName() + ":\t\tStarting conversion operation.");
            // Mimicking slow process
            long duration = new Random().nextInt(4000);
            Thread.sleep(duration);
            System.out.println(getName() + ":\t\tCompleted conversion operation(" + duration + "ms).");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void cleanup() {
        try {
            System.out.println(getName() + ":\t\tStarting cleanup operation.");
            // Mimicking slow process
            long duration = new Random().nextInt(4000);
            Thread.sleep(duration);
            System.out.println(getName() + ":\t\tCompleted cleanup operation(" + duration + "ms).");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}