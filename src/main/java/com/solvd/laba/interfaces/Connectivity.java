package com.solvd.laba.interfaces;

//created an interface to interface the phone class and its child classes
public interface Connectivity {
    //creating the connectsToWifi() method to use it.
    void connectsToWifi();
    void missedCall();
    void messageSMS();
    void videoCall();
    void voiceMail();
}