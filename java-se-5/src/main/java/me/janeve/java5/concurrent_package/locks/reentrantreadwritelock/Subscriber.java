package me.janeve.java5.concurrent_package.locks.reentrantreadwritelock;

import java.util.Random;

public class Subscriber extends SingledThread {
    private ConcurrentList<Integer> sharedList;
    private Random random = new Random();

    public Subscriber(String name, ConcurrentList<Integer> sharedList) {
        super(name);
        this.sharedList = sharedList;
    }

    public void process() {
        int index = random.nextInt(sharedList.size());
        Integer number = sharedList.get(index);
        System.out.println(getName() + "\t: Got " + number + ", Remaining: " + sharedList.size());
        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(300 + random.nextInt(200));
        } catch (InterruptedException ie ) { ie.printStackTrace(); }
    }
}
