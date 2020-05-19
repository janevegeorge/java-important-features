package me.janeve.java5.concurrent_package.atomic.references;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class SimpleAlphaNumericListProcessor extends Thread {

    public static Node top;
    private static Node currentNode;
    private List<String> dataProcessedByMe = new ArrayList<String>();

    public SimpleAlphaNumericListProcessor(String name) {
        super(name);
        init();
    }

    private synchronized void init() {
        if(currentNode == null) {
            currentNode = top;
        }
    }

    @Override
    public void run() {
        while (currentNode != null){
            Node myNode;
            synchronized (SimpleAlphaNumericListProcessor.class) {
                myNode = currentNode;
                currentNode = myNode.getNext();
            }

            System.out.println(getName() + ": Processing " + myNode.getData());
            dataProcessedByMe.add(myNode.getData());
            verySlowTask();
        }
    }

    private void verySlowTask() {
        try {
            sleep(2000 + new Random().nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printMyData() {
        System.out.println(getName() + ": My Data - " + dataProcessedByMe);
    }
}