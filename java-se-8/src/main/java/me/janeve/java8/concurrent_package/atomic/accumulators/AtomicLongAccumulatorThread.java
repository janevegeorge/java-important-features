package me.janeve.java8.concurrent_package.atomic.accumulators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.LongAccumulator;

public class AtomicLongAccumulatorThread extends Thread {

    public static final LongAccumulator MAX_ACCUMULATOR = new LongAccumulator(Math::max, 0L);
    private final Random randomNumberGenerator = new Random();

    private List<Long> myNumbers = new ArrayList<>();

    private boolean stopSignalled;

    public AtomicLongAccumulatorThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (!stopSignalled) {
            long number = 1000 + randomNumberGenerator.nextInt(1000000);
            myNumbers.add(number);
            MAX_ACCUMULATOR.accumulate(number);
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
