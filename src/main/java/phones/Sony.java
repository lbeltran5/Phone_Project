package phones;

import exceptions.*;
import interfaces.*;

public class Sony extends Phone implements Connectivity {
    private final String sonyFeature;
    private final String sonyMotto;

    public Sony(String model, String osVersionType, double price, int speed, long storageCapacity, String sonyFeature, String sonyMotto){
        super(model, osVersionType, price, speed, storageCapacity);
        this.sonyFeature = sonyFeature;
        this.sonyMotto = sonyMotto;
    }

    //getter method for variable sonyMotto
    public String getSonyMotto(){
        return sonyMotto;
    }

    @Override
    public void displayPhoneSpecs(){
        super.displayPhoneSpecs();
        System.out.println("Unique Feature: "+sonyFeature);
    }

    @Override
    public void showFeature(){
        System.out.println("Unique Feature: Video Call Effects");
    }

    @Override
    public void connectsToWifi() {
        System.out.println("The Sony Xperia 5 IV can connect to the Internet via wifi.");
        System.out.println("This method is call connectsToWifi() and it comes from the Connectivity interface");
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