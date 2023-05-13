package phones;

import exceptions.*;
import interfaces.*;

import java.util.function.*;

public class Nokia extends Phone implements Connectivity {
    private final String nokiaFeature;
    private final String nokiaMotto;
    protected String origin;
    private final String brandName;

    public Nokia(String model, String osVersionType, double price, int speed, long storageCapacity, String nokiaFeature, String nokiaMotto, String origin, String brandName){
        super(model, osVersionType, price, speed, storageCapacity);
        this.nokiaFeature = nokiaFeature;
        this.nokiaMotto = nokiaMotto;
        this.origin = origin;
        this.brandName = brandName;
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

    public void process(Consumer<Nokia> consumer){
        consumer.accept(this);
    }
}