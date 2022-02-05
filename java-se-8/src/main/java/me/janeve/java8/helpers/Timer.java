package me.janeve.java8.helpers;

import com.google.common.base.Stopwatch;

import java.util.HashMap;
import java.util.Random;

public class Timer {

    private static final HashMap<String, Stopwatch> stopwatches = new HashMap<>();
    private static final Random randomizer = new Random();

    public static void start(String name) {
        if(stopwatches.get(name) != null) {
            throw new RuntimeException("Stopwatch exists");
        }
        Stopwatch stopwatch = Stopwatch.createUnstarted();
        System.out.println(name + " Starting.");
        stopwatches.put(name, stopwatch.start());
    }

    public static void stop(String name){
        Stopwatch stopwatch = stopwatches.get(name);
        if(stopwatch != null) {
            System.out.println(name + " Finished in " + stopwatch.stop().elapsed().toMillis() + "ms");
            stopwatches.remove(name);
        } else {
            throw new RuntimeException("Stopwatch missing " + name);
        }
    }

    public static void delay(Integer delayMinMillis, Integer delayMaxMillis){
        try {
            Thread.sleep(delayMinMillis + randomizer.nextInt(delayMaxMillis));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
