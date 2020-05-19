package me.janeve.java5.concurrent_package.atomic.references;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicAlphaNumericListProcessor extends Thread {

    public static Node top;
    private static AtomicReference<Node> currentNode;
    private List<String> dataProcessedByMe = new ArrayList<String>();

    public AtomicAlphaNumericListProcessor(String name) {
        super(name);
        init();
    }

    private synchronized void init() {
        if(currentNode == null) {
            currentNode = new AtomicReference<Node>(top);
        }
    }

    @Override
    public void run() {
        while (currentNode.get() != null){
            Node myNode = currentNode.get();
            while (!currentNode.compareAndSet(myNode, myNode.getNext())) {
                myNode = currentNode.get();
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