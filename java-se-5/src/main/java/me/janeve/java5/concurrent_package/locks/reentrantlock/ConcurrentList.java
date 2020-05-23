package me.janeve.java5.concurrent_package.locks.reentrantlock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentList<E> {

    private final List<E> list = new ArrayList<E>();
    private Lock lock = new ReentrantLock();

    public ConcurrentList(E... initialItems) {
        list.addAll(Arrays.asList(initialItems));
    }

    public void add(E item) {
        lock.lock();
        try {
            list.add(item);
        } finally {
            lock.unlock();
        }
    }

    public E get(int index) {
        lock.lock();
        try {
            return list.remove(index);
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return list.size();
        } finally {
            lock.unlock();
        }
    }

}