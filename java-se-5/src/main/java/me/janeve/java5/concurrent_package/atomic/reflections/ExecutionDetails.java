package me.janeve.java5.concurrent_package.atomic.reflections;

public class ExecutionDetails {

    volatile int currentRunningThreads = 0;

    public int getCurrentRunningThreads() {
        return currentRunningThreads;
    }

    public void setCurrentRunningThreads(int currentRunningThreads) {
        this.currentRunningThreads = currentRunningThreads;
    }

}