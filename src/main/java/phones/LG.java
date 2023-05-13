package phones;

import exceptions.*;
import interfaces.*;

public class LG extends Phone implements Connectivity {
    private final String lgFeature;
    private final String lgMotto;
    protected String origin;
    private final String brandName;

    public LG(String model, String osVersionType, double price, int speed, long storageCapacity, String lgFeature, String lgMotto, String origin, String brandName){
        super(model, osVersionType, price, speed, storageCapacity);
        this.lgFeature = lgFeature;
        this.lgMotto = lgMotto;
        this.origin = origin;
        this.brandName = brandName;
    }
    public String getLgMotto(){
        return lgMotto;
    }

    @Override
    public void displayPhoneSpecs(){
        super.displayPhoneSpecs();
        System.out.println("Unique Feature: "+ lgFeature);
    }

    @Override
    public void showFeature(){
        System.out.println("Unique Feature: Waterproof");
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
    public void connectsToWifi() {
        System.out.println("The LG V60 ThinQ can connect to the Internet via Wifi.");
        System.out.println("This method is call connectsToWifi() and comes from the interfaces.Connectivity interface");
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