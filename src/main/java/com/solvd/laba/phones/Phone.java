package com.solvd.laba.phones;

import com.solvd.laba.exceptions.*;
import com.solvd.laba.interfaces.*;

public abstract class Phone implements Connectivity {
    // Fields
    protected String model;
    protected String osVersionType;
    protected double price;
    protected int speed;
    protected long storageCapacity;

    // Constructors
    public Phone(String model, String osVersionType, double price,
                 int speed, long storageCapacity){
        this.model = model;
        this.osVersionType = osVersionType;
        this.price = price;
        this.speed = speed;
        this.storageCapacity = storageCapacity;
    }

    // Concrete method
    public void displayPhoneSpecs(){
        System.out.println("Model: " + model);
        System.out.println("OS Version/Type: " + osVersionType);
        System.out.println("Price: $" + price);
        System.out.println("Speed: " + speed + " GHz");
        System.out.println("Storage Capacity: " + storageCapacity + " GB");
    }

    //** Getters and Setters methods for protected fields **//

    // for Model
    public String getModel(){
        return model;
    }
/*
    public void setModel(String model){
        this.model = model;
    }
*/

    public abstract String getOrigin();

    public abstract String getBrandName();
    // for OS Version and Type
    public String getOsVersionType(){
        return osVersionType;
    }
/*
    public void setOsVersionType(String osVersionType){
        this.osVersionType = osVersionType;
    }
*/

    //for Price
    public double getPrice(){
        return price;
    }
/*
    public void setPrice(double price){
        this.price = price;
    }
*/

    // for Speed
    public int getSpeed(){
        return speed;
    }
/*
    public void setSpeed(int speed){
        this.speed = speed;
    }
*/

    //for Storage Capacity
    public long getStorageCapacity() {
        return storageCapacity;
    }
/*
    public void setStorageCapacity(long storageCapacity) {
        this.storageCapacity = storageCapacity;
    }
*/

    // Abstract method
    public abstract void showFeature();

    public abstract Phone findModel(String model) throws ModelNotFoundException;

    @Override
    public void connectsToWifi() {
        }

    // Added getName() method
    public String getName() {
        return model; // Assuming the model name represents the phone name
    }

}

