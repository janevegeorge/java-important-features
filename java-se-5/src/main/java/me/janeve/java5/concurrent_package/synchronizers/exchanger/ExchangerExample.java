package me.janeve.java5.concurrent_package.synchronizers.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerExample {

    public static void main(String[] args) {
        Exchanger<int[]> exchanger = new Exchanger<int[]>();
        Publisher publisher = new Publisher(exchanger);
        Consumer consumer = new Consumer(exchanger);

        publisher.start();
        consumer.start();

        sleep();

        publisher.signal();
        consumer.signal();

        try {
            publisher.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}