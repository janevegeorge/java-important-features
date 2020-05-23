package me.janeve.java5.concurrent_package.atomic.reflections;

import java.util.ArrayList;
import java.util.List;

public class AtomicTaskBuilder {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<Thread>();

        for (int i = 0; i < 500; i++) {
            AtomicBoundedWorkerTask boundedWorkerTask = new AtomicBoundedWorkerTask("Task-"+i);
            boundedWorkerTask.start();
            threads.add(boundedWorkerTask);
        }

        for(Thread t: threads) {
            t.join();
        }

        System.out.println("Pending count: " + AtomicBoundedWorkerTask.getCurrentRunningThreads());
    }

}