public class Nokia extends Phone implements Connectivity{
    private final String nokiaFeature;
    private String nokiaMotto;

    public Nokia(String model, String osVersionType, double price, int speed, long storageCapacity, String nokiaFeature, String nokiaMotto){
        super(model, osVersionType, price, speed, storageCapacity);
        this.nokiaFeature = nokiaFeature;
        this.nokiaMotto = nokiaMotto;
    }
    public String getNokiaMotto(){
        return nokiaMotto;
    }
    public void setNokiaMotto(String nokiaMotto){
        this.nokiaMotto = nokiaMotto;
    }

    @Override
    public void displayPhoneSpecs(){
        super.displayPhoneSpecs();
        System.out.println("Unique Feature: "+nokiaFeature);
    }

    @Override
    public void showFeature(){
        System.out.println("Unique Feature: Video Call Effects");
        System.out.println("");
    }

    // using the connectsToWifi method from the interface connectivity
    @Override
    public void connectsToWifi() {
        System.out.println("The Nokia XR20 can connect to the Internet via .");
        System.out.println("This method is call connectsToWifi() and comes from the connectivity  interface");
    }

}