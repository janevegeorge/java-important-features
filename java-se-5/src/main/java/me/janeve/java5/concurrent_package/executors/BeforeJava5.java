package me.janeve.java5.concurrent_package.executors;

public class BeforeJava5 {

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            Thread aNewThread = new Thread(new RunnableTask(i));
            aNewThread.start();
        }
    }

}