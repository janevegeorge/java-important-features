package me.janeve.java5.concurrent_package.synchronizers.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class BuildJob extends Thread {

    private static final int MAX_SERVERS = 3;
    private static final Semaphore PERMITS = new Semaphore(MAX_SERVERS, false);

    public BuildJob(String name){
        super(name);
    }

    @Override
    public void run() {
        try {
            PERMITS.acquire();
            System.out.println(getName() + ":\t Permit acquired." );
            build();
            PERMITS.release();
            System.out.println(getName() + ":\t Permit released." );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void build() throws InterruptedException {
        System.out.println(getName() + ":\t Running Build job.");
        // To mimic a slow running process on a shared resource
        long duration = new Random().nextInt(3000);
        Thread.sleep(duration);
        System.out.println(getName() + ":\t Build Job Completed in " + duration + "ms");
    }
}