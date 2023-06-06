package com.solvd.laba.threads;

public class PhoneRunnable implements Runnable{
    private final String runnableThreadName;

    public PhoneRunnable(String name){
        this.runnableThreadName = name;
    }

    @Override
    public void run() {
        // Code to be executed in the thread
        System.out.println("Thread " + runnableThreadName + " is running from Runnable interface");

        // Code to be executed using runnable thread
        System.out.println("Thread " + runnableThreadName + " finished");
    }
}
