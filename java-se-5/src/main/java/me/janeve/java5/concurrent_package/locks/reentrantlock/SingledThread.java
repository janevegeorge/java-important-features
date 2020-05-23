package me.janeve.java5.concurrent_package.locks.reentrantlock;

public abstract class SingledThread extends Thread {
    protected boolean signalled = false;

    public SingledThread(String name) {
        super(name);
    }

    public void run() {
        while (!signalled) {
            process();
        }
    }

    protected abstract void process();

    public void signal(){
        signalled = true;
    }
}
