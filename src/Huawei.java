public class Huawei extends Phone{
        private final String huaweiFeature;
        private String huaweiMotto;
        private static int count;

        //static block to initialize static variable
        // to keep track of objects in class
        static {
            count = 0;
        }

        public Huawei(String model, String osVersionType, double price, int speed, long storageCapacity, String huaweiFeature, String huaweiMotto){
            super(model, osVersionType, price, speed, storageCapacity);
            this.huaweiFeature = huaweiFeature;
            this.huaweiMotto = huaweiMotto;
            //incrementing count in the Huawei constructor
            count++;
        }

        // A static method to retrieve the current count value
        public static int getCount(){return count;}
        public String getHuaweiMotto(){
            return huaweiMotto;
        }
        public void setHuaweiMotto(String huaweiMotto){
            this.huaweiMotto = huaweiMotto;
        }

        @Override

        public void displayPhoneSpecs(){
            super.displayPhoneSpecs();
            System.out.println("Unique Feature: "+ huaweiFeature);
            System.out.println("");
        }



        @Override
        public void showFeature(){
            System.out.println("Unique Feature: Waterproof");
        }

    @Override
    public Phone findModel(String model) throws PhoneExceptions.ModelNotFoundException {
        if (!getModel().equals(model)) {
            throw new PhoneExceptions.ModelNotFoundException("Model not found: " + model);
        }
        return this;
    }
    }