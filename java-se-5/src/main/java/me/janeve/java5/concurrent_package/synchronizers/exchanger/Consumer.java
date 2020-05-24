package me.janeve.java5.concurrent_package.synchronizers.exchanger;

import java.util.Arrays;
import java.util.concurrent.Exchanger;

public class Consumer extends Thread {
    private final Exchanger<int[]> exchanger;
    private boolean signalled;
    private int[] data;

    public Consumer(Exchanger<int[]> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (!signalled) {
            try {
                data = exchanger.exchange(new int[10]);
                System.out.println("Consumer - Got Data: " + Arrays.toString(data));
                sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void signal() {
        this.signalled = true;
    }
}
