package me.janeve.java5.concurrent_package.atomic.references;

public class Node {

    private String data;
    private Node next;

    public Node(String data) {
        this(data, null);
    }

    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }

    public String getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data + "->" + next;
    }
}