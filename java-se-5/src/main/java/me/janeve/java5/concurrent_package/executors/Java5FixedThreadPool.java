package me.janeve.java5.concurrent_package.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Java5FixedThreadPool {

    public static void main(String[] args) {
        // An Executor service that ensures only 10 threads are running at a time
        ExecutorService fixedThreadPoolExecutor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 50; i++) {
            fixedThreadPoolExecutor.execute(new RunnableTask(i));
        }

        // Signal the job is done.
        fixedThreadPoolExecutor.shutdown();

        // Wait for all the pending runnable tasks to complete.
        while (!fixedThreadPoolExecutor.isTerminated()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}