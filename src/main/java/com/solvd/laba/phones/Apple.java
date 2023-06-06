package com.solvd.laba.phones;

import com.solvd.laba.exceptions.*;
import com.solvd.laba.interfaces.*;


public class Apple extends Phone implements Connectivity {
    //defining two private instances variables
    // variable samsungFeature is final which means that it can't be change
    private final String appleFeature;
    private final String appleMotto;
    protected String origin;
    private final String brandName;

    //constructor method for phones.com.solvd.laba.Samsung, it takes several arguments
    public Apple(String model, String osVersionType, double price, int speed,
                 long storageCapacity, String appleFeature, String appleMotto,String origin, String brandName){
        super(model, osVersionType, price, speed, storageCapacity);
        // and sets the instances variables for class using "super" to call the constructor parent class
        // ,and we set the specific instance variables for phones.com.solvd.laba.Samsung class
        this.appleFeature = appleFeature;
        this.appleMotto = appleMotto;
        this.origin = origin;
        this.brandName = brandName;
    }

    //getters and setter methods for private instance variables
    public String getAppleMotto(){
        return appleMotto;
    }

    //this method overrides the parent class method 'displayPhoneSpecs'
    // it calls the parents' method first and then prints out the 'appleFeature'.
    @Override
    public void displayPhoneSpecs(){
        super.displayPhoneSpecs();
        System.out.println("Unique Feature: "+appleFeature);
    }

    //Overriding the abstract method 'showFeature' that is defined in our parent class.
    // which this abstract method simply prints out a message indicating uniqueness feature for Smartphone
    @Override
    public void showFeature(){
        System.out.println("Unique Feature: Face ID feature");
    }

    //implementation of the connectsToWifi()
    @Override
    public void connectsToWifi() {
        System.out.println("The iPhone 14 Pro Max can connect to the Internet via WiFi.");
        System.out.println("This method is call connectsToWifi() and comes from the Connectivity interface");
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