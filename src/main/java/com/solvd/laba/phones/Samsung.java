package com.solvd.laba.phones;

import com.solvd.laba.exceptions.*;


//this is a class defining variables
public class Samsung extends Phone {
    //defining two private instances variables
    // variable samsungFeature is final which means that it can't be change
    private final String samsungFeature;
    private final String samsungMotto;
    protected String origin;
    private final String brandName;

    //constructor method for phones.com.solvd.laba.Samsung, it takes several arguments
    public Samsung(String model, String osVersionType, double price, int speed,
                   long storageCapacity, String samsungFeature, String samsungMotto, String origin, String brandName) {
        // and sets the instances variables for class using "super" to call the constructor parent class
        // ,and we set the specific instance variables for phones.com.solvd.laba.Samsung class
        super(model, osVersionType, price, speed, storageCapacity);
        this.samsungFeature = samsungFeature;
        this.samsungMotto = samsungMotto;
        this.origin = origin;
        this.brandName = brandName;
    }

    //getters and setter methods for private instance variables
    public String getSamsungMotto() {
        return samsungMotto;
    }

    // Calling Concrete Method
    @Override
    public void displayPhoneSpecs(){
        super.displayPhoneSpecs();
        System.out.println("Unique Feature: "+ samsungFeature);
    }

    // this method overrides the 'toString' method of the parent class.
    @Override
    public String toString() {
        return "Samsung{" +
                "model='" + getModel() + '\'' +
                ", osVersionType='" + getOsVersionType() + '\'' +
                ", price=" + getPrice() +
                ", speed=" + getSpeed() +
                ", storageCapacity=" + getStorageCapacity() +
                '}';
    }

    //Overriding the abstract method 'showFeature' that is defined in our parent class.
    // which this abstract method simply prints out a message indicating uniqueness feature for Smartphone
    @Override
    public void showFeature(){
        System.out.println("Unique Feature: Video Call Effects; calling an abstract method");
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
    public String getOrigin(){
        return origin;
    }

    @Override
    public String getBrandName() {
        return brandName;
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
