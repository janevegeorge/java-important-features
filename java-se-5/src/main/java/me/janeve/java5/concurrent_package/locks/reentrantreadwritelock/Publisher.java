package me.janeve.java5.concurrent_package.locks.reentrantreadwritelock;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Publisher extends SingledThread {

    private ConcurrentList<Integer> sharedList;
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Random random = new Random();

    public Publisher(String name, ConcurrentList<Integer> sharedList) {
        super(name);
        this.sharedList = sharedList;
    }

    public void process() {
        int number = random.nextInt(500);
        sharedList.add(number);
        System.out.println(getName() + "\t: Added " + number + ", Size: " + sharedList.size());
        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(100 + random.nextInt(100));
        } catch (InterruptedException ie ) { ie.printStackTrace(); }
    }

}