package me.janeve.java8.concurrent_package.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkStealingPoolExample {

    public static void main(String[] args) {
        workStealingPool();
    }

    private static void workStealingPool() {
        // A work-stealing thread pool with parallelism based on the running system's available processors.
        ExecutorService workStealingPool = Executors.newWorkStealingPool();
        workStealingPool.submit(new RunnableTask());

        // A work-stealing thread pool with a parallelism at 4 processors.
        ExecutorService workStealingPoolWithParallelism = Executors.newWorkStealingPool(4);
        workStealingPoolWithParallelism.submit(new RunnableTask());
    }

}