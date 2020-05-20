package me.janeve.java8.concurrent_package.atomic.accumulators;

import java.util.ArrayList;
import java.util.List;

public class LongAccumulatorExample {

    public static void main(String[] args) throws InterruptedException {
        List<AtomicLongAccumulatorThread> threads = getRandomNumberAccumulatorThreads();
        longSleep();
        signalAllThreads(threads);
        waitForAllThreads(threads);
        System.out.println(AtomicLongAccumulatorThread.MAX_ACCUMULATOR.get());
    }

    private static List<AtomicLongAccumulatorThread> getRandomNumberAccumulatorThreads() {
        List<AtomicLongAccumulatorThread> threads = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            AtomicLongAccumulatorThread thread = new AtomicLongAccumulatorThread("Adder-"+i);
            thread.start();
            threads.add(thread);
        }
        return threads;
    }

    private static void waitForAllThreads(List<AtomicLongAccumulatorThread> threads) throws InterruptedException {
        for(AtomicLongAccumulatorThread thread:threads) {
            thread.join();
        }
    }

    private static void signalAllThreads(List<AtomicLongAccumulatorThread> threads) {
        for(AtomicLongAccumulatorThread thread:threads) {
            thread.signalStop();
        }
    }

    private static void longSleep() throws InterruptedException {
        System.out.println("Running the adder threads for 10 second.");
        Thread.sleep(10000);
    }

}