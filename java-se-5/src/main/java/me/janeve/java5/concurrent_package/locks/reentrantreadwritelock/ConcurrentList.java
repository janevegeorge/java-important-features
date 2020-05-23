package me.janeve.java5.concurrent_package.locks.reentrantreadwritelock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentList<E> {

    private final List<E> list = new ArrayList<E>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public ConcurrentList(E... initialItems) {
        list.addAll(Arrays.asList(initialItems));
    }

    public void add(E item) {
        Lock writeLock = lock.writeLock();
        writeLock.lock();
        try {
            list.add(item);
        } finally {
            writeLock.unlock();
        }
    }

    public E get(int index) {
        Lock readLock = lock.readLock();
        readLock.lock();
        try {
            return list.remove(index);
        } finally {
            readLock.unlock();
        }
    }

    public int size() {
        Lock readLock = lock.readLock();
        readLock.lock();
        try {
            return list.size();
        } finally {
            readLock.unlock();
        }
    }

}