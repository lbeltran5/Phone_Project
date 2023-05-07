package phones;

import exceptions.ModelNotFoundException;

public class Motorola extends Phone {
    private final String motorolaFeature;
    private final String motorolaMotto;


    public Motorola(String model, String osVersionType, double price, int speed, long storageCapacity, String motorolaFeature, String motorolaMotto){
        super(model, osVersionType, price, speed, storageCapacity);
        this.motorolaFeature = motorolaFeature;
        this.motorolaMotto = motorolaMotto;
    }

    public String getMotorolaMotto(){
        return motorolaMotto;
    }

    @Override
    public void displayPhoneSpecs(){
        super.displayPhoneSpecs();
        System.out.println("Unique Feature: "+motorolaFeature);
    }

    @Override
    public String toString() {
        return "Motorola{" +
                "model='" + getModel() + '\'' +
                ", osVersionType='" + getOsVersionType() + '\'' +
                ", price=" + getPrice() +
                ", speed=" + getSpeed() +
                ", storageCapacity=" + getStorageCapacity() +
                '}';
    }

    @Override
    public void showFeature(){
        System.out.println("Unique Feature: OLED Display; called the abstract method");
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