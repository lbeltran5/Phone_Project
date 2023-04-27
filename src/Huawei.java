public class Huawei extends Phone{
        //Declaring private fields
        private final String huaweiFeature;
        private final String huaweiMotto;
        private static int count;

        //static block to initialize static variable
        // to keep track of objects in class
        static {
            count = 0;
        }

        //Custom constructor with several arguments
        public Huawei(String model, String osVersionType, double price, int speed, long storageCapacity, String huaweiFeature, String huaweiMotto){
            //calls constructor parent
            super(model, osVersionType, price, speed, storageCapacity);
            //initializing the instance variables
            this.huaweiFeature = huaweiFeature;
            this.huaweiMotto = huaweiMotto;
            //incrementing count in the Huawei constructor
            count++;
        }

        // A static method to retrieve the current count value
        public static int getCount(){return count;}

        // getter method to retrieve private field
        public String getHuaweiMotto(){
            return huaweiMotto;
        }

        @Override
        public void displayPhoneSpecs(){
            super.displayPhoneSpecs();
            System.out.println("Unique Feature: "+ huaweiFeature);
        }

        //Overriding abstract method to call its unique feature
        @Override
        public void showFeature(){
            System.out.println("Unique Feature: Waterproof");
        }

        //checking if the current phone model matches the model argument if not,
        // it throws the custom exception

        //equals() method here is used to compare the current phone model, if not equal to
        //it throws the ModelNotFound
        @Override
        public Phone findModel(String model) throws PhoneExceptions.ModelNotFoundException {
        if (!getModel().equals(model)) {
            throw new PhoneExceptions.ModelNotFoundException("Model not found: " + model);
        }
        return this;
        }
    }