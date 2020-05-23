package me.janeve.java8.concurrent_package.executors;

import java.util.Random;

public class RunnableTask implements Runnable{

    private int id;
    private Random randomGenerator;

    public RunnableTask() {
        this(1);
    }

    public RunnableTask(int id) {
        this.id = id;
        this.randomGenerator = new Random(id);
    }

    @Override
    public void run() {
        System.out.println(id + ": " + "Started");
        try {
            long seconds = 1000L + randomGenerator.nextInt(4000);
            Thread.sleep(seconds);  // Imitates a slow running method.
        } catch (InterruptedException e) {
            // Do nothing
        }
        System.out.println(id + ": " + "Ended");
    }
}