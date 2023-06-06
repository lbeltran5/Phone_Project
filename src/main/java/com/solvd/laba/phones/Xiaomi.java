package com.solvd.laba.phones;

import com.solvd.laba.exceptions.*;

public final class Xiaomi extends Phone {
    private final String xiaomiFeature;
    private final String xiaomiMotto;
    private final String origin;
    private final String brandName;

    public Xiaomi(String model, String osVersionType, double price, int speed, long storageCapacity, String xiaomiFeature, String xiaomiMotto,String origin, String brandName){
        super(model, osVersionType, price, speed, storageCapacity);
        this.xiaomiFeature = xiaomiFeature;
        this.xiaomiMotto = xiaomiMotto;
        this.origin = origin;
        this.brandName = brandName;
    }
    public String getXiaomiMotto(){
        return xiaomiMotto;
    }

    @Override
    public void displayPhoneSpecs(){
        super.displayPhoneSpecs();
        System.out.println("Unique Feature: " + xiaomiFeature);
    }

    @Override
    public void showFeature(){
        System.out.println("Unique Feature: thin and light screen; this is an abstract method");
    }

    @Override
            public String toString() {
                return "Xiaomi{" +
                        "model='" + getModel() + '\'' +
                        ", osVersionType='" + getOsVersionType() + '\'' +
                        ", price=" + getPrice() +
                        ", speed=" + getSpeed() +
                        ", storageCapacity=" + getStorageCapacity() +
                        '}';
            }

    public void xiaomiFinalMethod(){
        System.out.println("This is a final method for Xiaomi! ");
        System.out.print("Xiaomi is my final class, it has a final variable 'xiaomiFeature', and final method");
    }


    @Override
    public void missedCall(){
        System.out.println("Missed Call");
    }

    @Override
    public void messageSMS(){
        System.out.println("Message SMS");
    }

    @Override
    public void videoCall(){
        System.out.println("Video Call");
    }

    @Override
    public String getOrigin(){
        return origin;
    }

    @Override
    public String getBrandName() {
        return brandName;
    }

    @Override
    public void voiceMail(){
        System.out.println("Voice Mail");
    }

    @Override
    public Phone findModel(String model) throws ModelNotFoundException {
        if (!getModel().equals(model)) {
            throw new ModelNotFoundException("Model not found: " + model);
        }
        return this;
    }
}