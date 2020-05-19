package me.janeve.java5.concurrent_package.atomic.primitives;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AtomicMultiOperationTaskBuilder {

    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads = new ArrayList<Thread>();

        for (int i = 0; i < 500; i++) {
            AtomicMultiOperationBoundedWorkerTask boundedWorkerTask = new AtomicMultiOperationBoundedWorkerTask("Task-"+i);
            boundedWorkerTask.start();
            threads.add(boundedWorkerTask);
        }

        for(Thread t: threads) {
            t.join();
        }

        System.out.println("Pending count: " + Arrays.toString(AtomicMultiOperationBoundedWorkerTask.getCurrentRunningThreads()));
    }

}