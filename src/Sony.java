public class Sony extends Phone implements Connectivity{
    private final String sonyFeature;
    private String sonyMotto;

    public Sony(String model, String osVersionType, double price, int speed, long storageCapacity, String sonyFeature, String sonyMotto){
        super(model, osVersionType, price, speed, storageCapacity);
        this.sonyFeature = sonyFeature;
        this.sonyMotto = sonyMotto;
    }

    public String getSonyMotto(){
        return sonyMotto;
    }

    public void setSonyMotto(String sonyMotto){
        this.sonyMotto = sonyMotto;
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
    public Phone findModel(String model) throws PhoneExceptions.ModelNotFoundException {
        if (!getModel().equals(model)) {
            throw new PhoneExceptions.ModelNotFoundException("Model not found: " + model);
        }
        return this;
    }
}