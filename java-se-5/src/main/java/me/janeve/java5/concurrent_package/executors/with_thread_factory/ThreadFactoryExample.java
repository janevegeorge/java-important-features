package me.janeve.java5.concurrent_package.executors.with_thread_factory;

import me.janeve.java5.concurrent_package.executors.RunnableTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadFactoryExample {

    public static void main(String[] args) {
        // An Executor service that ensures only 10 threads are running at a time
        ExecutorService fixedThreadPoolExecutor = Executors.newFixedThreadPool(10, new MyThreadFactory());

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

 class MyThread extends Thread {
     public MyThread(Runnable runnable) {
         super(runnable);
     }

     @Override
     public void run() {
         System.out.println("MyThread object with additional capabilities.");
     }
 }

class MyThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable runnable) {
        return new MyThread(runnable);
    }
}