package phones;

//this is a class defining variables
public class Samsung extends Phone {
    //defining two private instances variables
    // variable samsungFeature is final which means that it can't be change
    private final String samsungFeature;
    private final String samsungMotto;

    //constructor method for phones.Samsung, it takes several arguments
    public Samsung(String model, String osVersionType, double price, int speed,
                   long storageCapacity, String samsungFeature, String samsungMotto) {
        // and sets the instances variables for class using "super" to call the constructor parent class
        // ,and we set the specific instance variables for phones.Samsung class
        super(model, osVersionType, price, speed, storageCapacity);
        this.samsungFeature = samsungFeature;
        this.samsungMotto = samsungMotto;
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
    public Phone findModel(String model) throws PhoneExceptions.ModelNotFoundException {
        if (!getModel().equals(model)) {
            throw new PhoneExceptions.ModelNotFoundException("Model not found: " + model);
        }
        return this;
    }
}
