package phones;

public class LG extends Phone implements Connectivity {
    private final String lgFeature;
    private final String lgMotto;

    public LG(String model, String osVersionType, double price, int speed, long storageCapacity, String lgFeature, String lgMotto){
        super(model, osVersionType, price, speed, storageCapacity);
        this.lgFeature = lgFeature;
        this.lgMotto = lgMotto;
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
    public void connectsToWifi() {
        System.out.println("The LG V60 ThinQ can connect to the Internet via Wifi.");
        System.out.println("This method is call connectsToWifi() and comes from the phones.Connectivity interface");
    }

    @Override
    public Phone findModel(String model) throws PhoneExceptions.ModelNotFoundException {
        if (!getModel().equals(model)) {
            throw new PhoneExceptions.ModelNotFoundException("Model not found: " + model);
        }
        return this;
    }
}