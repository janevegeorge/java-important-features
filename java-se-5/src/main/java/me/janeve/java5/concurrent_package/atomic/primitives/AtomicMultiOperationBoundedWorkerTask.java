package me.janeve.java5.concurrent_package.atomic.primitives;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicMultiOperationBoundedWorkerTask extends Thread {

    private static final int BOUND = 40;
    private static AtomicIntegerArray currentRunningThreads = new AtomicIntegerArray(new int[] {0, 0, 0, 0, 0});

    public AtomicMultiOperationBoundedWorkerTask(String name) {
        super(name);
    }

    @Override
    public void run() {
        runOperation(0);
        runOperation(1);
        runOperation(2);
        runOperation(3);
        runOperation(4);
    }

    private void runOperation(int num) {
        while (currentRunningThreads.get(num) >= BOUND) {
            sleep(100);
        }
        System.out.println(getName() + "\t\t Pending before operation " + num + ": " + Arrays.toString(getCurrentRunningThreads()));
        currentRunningThreads.getAndIncrement(num);
        sleep(new Random().nextInt(100));
        currentRunningThreads.decrementAndGet(num);
        System.out.println(getName() + "\t\t Pending after operations " + num + ": " + Arrays.toString(getCurrentRunningThreads()));
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int[] getCurrentRunningThreads() {
        int[] result = new int[currentRunningThreads.length()];
        for (int i = 0; i < currentRunningThreads.length(); i++) {
            result[i] = currentRunningThreads.get(i);
        }
        return result;
    }
}