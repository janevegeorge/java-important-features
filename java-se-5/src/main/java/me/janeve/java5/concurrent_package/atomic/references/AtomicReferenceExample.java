package me.janeve.java5.concurrent_package.atomic.references;

import java.util.ArrayList;
import java.util.List;

public class AtomicReferenceExample {

    public static void main(String[] args) throws InterruptedException {
        AtomicAlphaNumericListProcessor.top = buildAlphaNumericLinkedList();

        List<AtomicAlphaNumericListProcessor> threads = new ArrayList<AtomicAlphaNumericListProcessor>();
        for (int i = 0; i < 5; i++) {
            AtomicAlphaNumericListProcessor processor = new AtomicAlphaNumericListProcessor("Processor-" + i);
            processor.start();
            threads.add(processor);
        }

        for(AtomicAlphaNumericListProcessor thread: threads) {
            thread.join();
            thread.printMyData();
        }
    }

    private static Node buildAlphaNumericLinkedList() {
        String[] alphanumerics = new String[]{
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
        };

        Node top = null;
        Node builder = top;
        for (String data: alphanumerics){
            if(top == null) {
                top = new Node(data);
                builder = top;
                continue;
            }
            builder.setNext(new Node(data));
            builder = builder.getNext();
        }
        return top;
    }

}