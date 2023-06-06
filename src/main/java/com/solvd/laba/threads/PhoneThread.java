package com.solvd.laba.threads;

public class PhoneThread extends Thread{

    @Override
    public void run() {
        System.out.println("PhoneThread is running from extending Thread");
    }
}