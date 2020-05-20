package me.janeve.java8.concurrent_package.atomic.adders;

import java.util.ArrayList;
import java.util.List;

public class AtomicLongAdderExample {

    public static void main(String[] args) throws InterruptedException {
        List<AtomicRandomNumberAdderThread> threads = getRandomNumberAdderThreads();
        longSleep();
        signalAllThreads(threads);
        waitForAllThreads(threads);
        System.out.println(AtomicRandomNumberAdderThread.adder.sum());
    }

    private static List<AtomicRandomNumberAdderThread> getRandomNumberAdderThreads() {
        List<AtomicRandomNumberAdderThread> threads = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            AtomicRandomNumberAdderThread thread = new AtomicRandomNumberAdderThread("Adder-"+i);
            thread.start();
            threads.add(thread);
        }
        return threads;
    }

    private static void waitForAllThreads(List<AtomicRandomNumberAdderThread> threads) throws InterruptedException {
        for(AtomicRandomNumberAdderThread thread:threads) {
            thread.join();
        }
    }

    private static void signalAllThreads(List<AtomicRandomNumberAdderThread> threads) {
        for(AtomicRandomNumberAdderThread thread:threads) {
            thread.signalStop();
        }
    }

    private static void longSleep() throws InterruptedException {
        System.out.println("Running the adder threads for 10 second.");
        Thread.sleep(10000);
    }

}