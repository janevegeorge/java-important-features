package me.janeve.java5.concurrent_package.atomic.primitives;

import java.util.Random;

public class BoundedWorkerTask extends Thread {

    private static final int BOUND = 40;
    private static int currentRunningThreads = 0;

    public BoundedWorkerTask(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (currentRunningThreads >= BOUND) {
            sleep(100);
        }
        System.out.println(getName() + ":\tStarted along with " + currentRunningThreads);
        currentRunningThreads++;
        // Mimicking a slow running process
        sleep(new Random().nextInt(100));
        currentRunningThreads--;
        System.out.println(getName() + ":\tCompleted, pending " + currentRunningThreads);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int getCurrentRunningThreads() {
        return currentRunningThreads;
    }
}