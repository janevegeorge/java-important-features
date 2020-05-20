package me.janeve.java8.concurrent_package.atomic.adders;

import java.util.ArrayList;
import java.util.List;

public class SimpleLongAdderExample {

    public static void main(String[] args) throws InterruptedException {
        List<SimpleRandomNumberAdderThread> threads = getRandomNumberAdderThreads();
        sleep();
        signalAllThreads(threads);
        waitForAllThreads(threads);
        System.out.println(SimpleRandomNumberAdderThread.sum);
    }

    private static List<SimpleRandomNumberAdderThread> getRandomNumberAdderThreads() {
        List<SimpleRandomNumberAdderThread> threads = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            SimpleRandomNumberAdderThread thread = new SimpleRandomNumberAdderThread("Adder-"+i);
            thread.start();
            threads.add(thread);
        }
        return threads;
    }

    private static void waitForAllThreads(List<SimpleRandomNumberAdderThread> threads) throws InterruptedException {
        for(SimpleRandomNumberAdderThread thread:threads) {
            thread.join();
        }
    }

    private static void signalAllThreads(List<SimpleRandomNumberAdderThread> threads) {
        for(SimpleRandomNumberAdderThread thread:threads) {
            thread.signalStop();
        }
    }

    private static void sleep() throws InterruptedException {
        System.out.println("Running the adder threads for 10 seconds.");
        Thread.sleep(10000);
    }

}