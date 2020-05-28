package me.janeve.java7.concurrent_package.phaser;

import java.util.concurrent.Phaser;

public class BuildJob extends Thread {

    private Phaser ph;

    public BuildJob(String name, Phaser ph){
        super(name);
        this.ph = ph;
        ph.register();
    }

    @Override
    public void run() {
        System.out.println(getName() + ":\t Phasers:" + ph.getPhase() );
        ph.arriveAndAwaitAdvance();
        System.out.println(getName() + ":\t arrived." );
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ph.arriveAndDeregister();
        System.out.println(getName() + ":\t de-registered." );
    }

}