public class LG extends Phone implements Connectivity{
    private final String lgFeature;
    private String lgMotto;

    public LG(String model, String osVersionType, double price, int speed, long storageCapacity, String lgFeature, String lgMotto){
        super(model, osVersionType, price, speed, storageCapacity);
        this.lgFeature = lgFeature;
        this.lgMotto = lgMotto;
    }
    public String getLgMotto(){
        return lgMotto;
    }
    public void setLgMotto(String lgMotto){
        this.lgMotto = lgMotto;
    }

    @Override
    public void displayPhoneSpecs(){
        super.displayPhoneSpecs();
        System.out.println("Unique Feature: "+lgFeature);
    }

    @Override
    public void showFeature(){
        System.out.println("Unique Feature: Video Call Effects");
    }

    @Override
    public void connectsToWifi() {
        System.out.println("The LG V60 ThinQ can connect to the Internet via Wifi.");
        System.out.println("This method is call connectsToWifi() and comes from the Connectivity interface");
    }

}