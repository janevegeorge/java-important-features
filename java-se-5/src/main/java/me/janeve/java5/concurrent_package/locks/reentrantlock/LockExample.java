package me.janeve.java5.concurrent_package.locks.reentrantlock;

import java.util.ArrayList;
import java.util.List;

public class LockExample {

    public static void main(String[] args) {
        ConcurrentList<Integer> sharedList = new ConcurrentList<Integer>(303, 281, 286, 199, 300, 329);
        List<SingledThread> threads = new ArrayList<SingledThread>();
        threads.addAll( spawnPublishers(sharedList) );
        threads.addAll( spawnSubscribers(sharedList) );
        sleep();
        signalAllThreads(threads);
        waitForAllThreads(threads);
        System.out.println("Final list count: " + sharedList.size());
    }

    private static List<SingledThread> spawnPublishers(ConcurrentList<Integer> sharedList) {
        List<SingledThread> threads = new ArrayList<SingledThread>();
        for (int i = 0; i < 5; i++) {
            Publisher thread = new Publisher("Publisher-" + i, sharedList);
            threads.add(thread);
            thread.start();
        }
        return threads;
    }

    private static List<SingledThread> spawnSubscribers(ConcurrentList<Integer> sharedList) {
        List<SingledThread> threads = new ArrayList<SingledThread>();
        for (int i = 0; i < 10; i++) {
            Subscriber thread = new Subscriber("Subscriber" + i, sharedList);
            threads.add(thread);
            thread.start();
        }
        return threads;
    }

    private static void signalAllThreads(List<SingledThread> threads) {
        for(SingledThread thread:threads) {
            thread.signal();
        }
    }

    private static void waitForAllThreads(List<SingledThread> threads) {
        for(SingledThread thread:threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException ie ) { ie.printStackTrace(); }
    }

}