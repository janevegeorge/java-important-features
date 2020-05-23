package me.janeve.java5.concurrent_package.atomic.reflections;

import java.util.Random;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicBoundedWorkerTask extends Thread {

    private static final int BOUND = 40;
    private static final AtomicIntegerFieldUpdater<ExecutionDetails>
            atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(ExecutionDetails.class, "currentRunningThreads" );

    private static final ExecutionDetails executionDetails = new ExecutionDetails();

    public AtomicBoundedWorkerTask(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (atomicIntegerFieldUpdater.get(executionDetails) >= BOUND) {
            sleep(100);
        }
        System.out.println(getName() + ":\tStarted along with " + atomicIntegerFieldUpdater.getAndIncrement(executionDetails));
        sleep(new Random().nextInt(100));
        System.out.println(getName() + ":\tCompleted, pending " + atomicIntegerFieldUpdater.decrementAndGet(executionDetails));
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int getCurrentRunningThreads() {
        return atomicIntegerFieldUpdater.get(executionDetails);
    }
}