package me.janeve.java5.concurrent_package.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AllExamples {


    public static void main(String[] args) {
        fixedThreadPool();
        cachedThreadPool();
        scheduledThreadPool();
        // See me.janeve.java8.concurrent_package.executors.WorkStealingPoolExample for Work Stealing Pool Example
    }

    private static void scheduledThreadPool() {
        // A scheduled thread pool with a core pool size of 10. It will keep 10 threads in the pool, even if they are idle
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);

        // A scheduled thread pool with a core pool size of 1. It will keep one thread in the pool.
        ScheduledExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();

        // Submits a task that runs immediately.
        scheduledThreadPool.submit(new RunnableTask());

        // Submits a task that runs after the given delay (2 seconds here).
        scheduledThreadPool.schedule(new RunnableTask(), 2, TimeUnit.SECONDS);

        // Submits a task that runs after the given delay (2 seconds here).
        // It periodically repeats the task (5 seconds here).
        scheduledThreadPool.scheduleAtFixedRate(new RunnableTask(), 2, 5, TimeUnit.SECONDS);

        // Submits a task that runs after the given delay (2 seconds here).
        // When the first task is completed, the commencement of the next task is delayed. (5 seconds here)
        scheduledThreadPool.scheduleWithFixedDelay(new RunnableTask(), 2, 5, TimeUnit.SECONDS);
    }

    private static void fixedThreadPool() {
        // Ensures only 10 threads are running at a time
        ExecutorService fixedThreadPoolExecutor = Executors.newFixedThreadPool(10);
        fixedThreadPoolExecutor.submit(new RunnableTask());

        // An Executor service that ensures only 1 thread is running at a time
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.submit(new RunnableTask());
    }

    private static void cachedThreadPool() {
        // Tries to reuse any idle threads to run. If no idle threads are available, a new thread is created.
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.submit(new RunnableTask());
    }

}