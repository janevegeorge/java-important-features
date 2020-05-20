package me.janeve.java8.concurrent_package.atomic.adders;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class AtomicRandomNumberAdderThread extends Thread {

    public static final LongAdder adder = new LongAdder();
    private final Random randomNumberGenerator = new Random();

    private List<Long> myNumbers = new ArrayList<>();

    private boolean stopSignalled;

    public AtomicRandomNumberAdderThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (!stopSignalled) {
            long number = randomNumberGenerator.nextInt(50);
            myNumbers.add(number);
            adder.add(number);
            sleep();
        }
        long mySum = 0;
        for(long number:myNumbers){
            mySum += number;
        }

        System.out.println(getName() + ":\t" + mySum + " <= " + myNumbers);
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void signalStop() {
        this.stopSignalled = true;
    }
}
