package Phones;

import Phones.*;

public class Nokia extends Phone implements Connectivity {
    private final String nokiaFeature;
    private final String nokiaMotto;

    public Nokia(String model, String osVersionType, double price, int speed, long storageCapacity, String nokiaFeature, String nokiaMotto){
        super(model, osVersionType, price, speed, storageCapacity);
        this.nokiaFeature = nokiaFeature;
        this.nokiaMotto = nokiaMotto;
    }
    public String getNokiaMotto(){
        return nokiaMotto;
    }

    @Override
    public void displayPhoneSpecs(){
        super.displayPhoneSpecs();
        System.out.println("Unique Feature: "+nokiaFeature);
    }

    @Override
    public void showFeature(){
        System.out.println("Unique Feature: Video Call Effects");
    }

    // using the connectsToWifi method from the interface connectivity
    @Override
    public void connectsToWifi() {
        System.out.println("The Nokia XR20 can connect to the Internet via .");
        System.out.println("This method is call connectsToWifi() and comes from the connectivity  interface");
    }

    @Override
    public Phone findModel(String model) throws PhoneExceptions.ModelNotFoundException {
        if (!getModel().equals(model)) {
            throw new PhoneExceptions.ModelNotFoundException("Model not found: " + model);
        }
        return this;
    }
}