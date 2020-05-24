package me.janeve.java5.concurrent_package.synchronizers.exchanger;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class Publisher extends Thread {
    private final Exchanger<int[]> exchanger;
    private boolean signalled;

    private int[] data = new int[10];
    private static final Random randomGenerator = new Random();

    public Publisher(Exchanger<int[]> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (!signalled) {
            buildData(data);
            try {
                data = exchanger.exchange(data);
                System.out.println("Publisher - Got Data: " + Arrays.toString(data));
                sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void buildData(int[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = randomGenerator.nextInt(1000);
        }
    }

    public void signal() {
        this.signalled = true;
    }
}
