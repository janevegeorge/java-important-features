package me.janeve.java5.concurrent_package.atomic.primitives;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicBoundedWorkerTask extends Thread {

    private static final int BOUND = 40;
    private static AtomicInteger currentRunningThreads = new AtomicInteger(0);

    public AtomicBoundedWorkerTask(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (currentRunningThreads.get() >= BOUND) {
            sleep(100);
        }
        System.out.println(getName() + ":\tStarted along with " + currentRunningThreads.getAndIncrement());
        sleep(new Random().nextInt(100));
        System.out.println(getName() + ":\tCompleted, pending " + currentRunningThreads.decrementAndGet());
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int getCurrentRunningThreads() {
        return currentRunningThreads.get();
    }
}