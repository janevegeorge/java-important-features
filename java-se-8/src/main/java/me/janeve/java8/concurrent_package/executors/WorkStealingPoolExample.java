package me.janeve.java8.concurrent_package.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class WorkStealingPoolExample {

    public static void main(String[] args) {
        workStealingPool();
    }

    private static void workStealingPool() {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        ExecutorService workStealingPool = Executors.newWorkStealingPool();
        ExecutorService workStealingPoolWithParallelism = Executors.newWorkStealingPool(8);
    }

}