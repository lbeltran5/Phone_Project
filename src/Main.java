// Importing scanner for user input
import java.util.*;
import java.util.logging.Logger;

// Define a class for the main program
public class Main {

    //
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        //
        LOGGER.info("Starting the main method.");
        //Display the phone menu
        PhoneMenu.PhoneDisplay();

        // Creating a scanner object to read user input
        try (Scanner scanner = new Scanner(System.in)) {
            //
            LOGGER.info("Scanner object created.");
            // Take the user selection input
            System.out.println("Enter the phone brand of your choice (1-8): ");
            int BrandSelection = 0;

            try {
                BrandSelection = scanner.nextInt();
                if (BrandSelection < 1 || BrandSelection > 8) {
                    throw new PhoneExceptions.InvalidSelectionException("Invalid selection. Please enter a number between 1 and 8." + " throws InvalidSelectionException");
                }
            } catch (InputMismatchException e) {
                LOGGER.warning(("Invalid input, this comes from LOGGER.warning."));
                System.out.println("Invalid input. Please enter a number between 1 and 8." + " InputMismatchException");
                scanner.next(); // clear the scanner buffer
                return;
            } catch (PhoneExceptions.InvalidSelectionException e) {
                LOGGER.warning(e.getMessage());
                System.out.println(e.getMessage());
                return;
            }

            //
            LOGGER.info("User selected Phone Brand: " + BrandSelection);

            // The scanner will be automatically closed at the end of the try block
            // When block completes the Scanner object is automatically closed
            // try-with-resources statement must implement "AutoClosable" interface.
            // Scanner class has this

            // Instantiate objects of implemented classes based on user input
            Samsung samsungPhone = new Samsung("Galaxy S23 Ultra", "Android 13", 1200,
                    12, 1L, "Video Call Effects", "Together for tomorrow");
            Apple applePhone = new Apple("iPhone 14 Pro Max", "iOS 16", 1100,
                    6, 1L, "Face ID feature", "Think different");
            Xiaomi xiaomiPhone = new Xiaomi("Xiaomi 13 Ultra", "Android 13", 1200,
                    16, 1L, "thin and light screen", "Just for fans");
            Motorola motorolaPhone = new Motorola("Motorola Edge 30 Ultra", "Android 12", 765,
                    12, 512L, "OLED display", "Hello Moto!");
            Huawei huaweiPhone = new Huawei("Huawei P40 Pro", "Android 10", 650,
                    8, 256L, "waterproof", "Building a Fully Connected, Intelligent World.");
            LG lgPhone = new LG("LG V60 ThinQ", "Android 10", 800,
                    8, 256L, "waterproof", "Life's Good");
            Nokia nokiaPhone = new Nokia("Nokia XR20", "Android 11", 440,
                    6, 128L, "Wireless Charging", "Connecting people");
            Sony sonyPhone = new Sony("Sony Xperia 5 IV", "Android 12", 998,
                    8, 256L, "triple lens camera", "make.believe");

            // declaring and initializing string variables with slogans and different phones brands
            // the slogan is obtained by calling a method on an object
            // EXAMPLE: The method getSamsungMotto() is called on an object samsungPhone of the
            //          Samsung class to obtain the motto of Samsung.
            String samsungSlogan = samsungPhone.getSamsungMotto();
            String appleSlogan = applePhone.getAppleMotto();
            String xiaomiSlogan = xiaomiPhone.getXiaomiMotto();
            String motorolaSlogan = motorolaPhone.getMotorolaMotto();
            String huaweiSlogan = huaweiPhone.getHuaweiMotto();
            String lgSlogan = lgPhone.getLgMotto();
            String nokiaSlogan = nokiaPhone.getNokiaMotto();
            String sonySlogan = sonyPhone.getSonyMotto();

            // Using if, else if, and else statements for user selection
            if (BrandSelection == 1) {
                //printing out the brand slogan by getting Samsung Motto method from Samsung Class
                System.out.println("Samsung Slogan:" + samsungSlogan);
                System.out.println();

                //printing out the title of specs
                System.out.println("*** SmartPhone Specifications using toString() ***");
                //displaying the override method using toString();
                System.out.println(samsungPhone.toString());

                //displaying the brands feature by using the abstract method which is overridden from phone's class
                samsungPhone.showFeature();

            } else if (BrandSelection == 2) {
                System.out.println("Apple Slogan:" + appleSlogan);
                System.out.println();

                System.out.println("** SmartPhone Specifications **");
                //displaying the phone specs by using the concrete method
                applePhone.displayPhoneSpecs();
                System.out.println();

                //we are using the object "applePhone" to call the methods below which comes from
                // the Connectivity interfaces.
                applePhone.connectsToWifi();

            } else if (BrandSelection == 3) {
                System.out.println("Xiaomi Slogan:" + xiaomiSlogan);
                System.out.println();

                //title for the specs on toString() method
                System.out.println("*** SmartPhone Specifications using toString() ***");
                System.out.println(xiaomiPhone.toString());

                //calling an abstract method "showFeature()"
                xiaomiPhone.showFeature();

                //final class, method, variable
                xiaomiPhone.xiaomiFinalMethod();

            } else if (BrandSelection == 4) {
                System.out.println("Motorola Slogan:" + motorolaSlogan);
                System.out.println();

                //title for the specs on toString() method
                System.out.println("*** SmartPhone Specifications using toString() ***");
                System.out.println(motorolaPhone.toString());
                System.out.println("");

                //calling an abstract method
                motorolaPhone.showFeature();
                System.out.println("");

                try {
                    //calling the findModel() method
                    Phone motorolaCell = motorolaPhone.findModel("Moto G");
                    String model = motorolaCell.getModel();

                    //printing the result
                    System.out.println("The model is: " + model);
                } catch (PhoneExceptions.ModelNotFoundException e) {
                    //if the model is not found, print the error message
                    System.out.println("Error: " + e.getMessage() + ". ModelNotFoundException handle with throw keyword.");
                }


            } else if (BrandSelection == 5) {
                System.out.println("Huawei Slogan:" + huaweiSlogan);
                System.out.println();

                System.out.println("** SmartPhone Specifications **");
                huaweiPhone.displayPhoneSpecs();

                //static class, method, variable
                int count = Huawei.getCount();
                System.out.println("This is the static method for Huawei it counts the number of phones or objects created: " + count);
                System.out.println("Huawei has a static block, method, and static variable 'count'");
            } else if (BrandSelection == 6) {
                System.out.println("LG Slogan:" + lgSlogan);
                System.out.println();

                System.out.println("** SmartPhone Specifications **");
                lgPhone.displayPhoneSpecs();

                //calling the interface method and printing out its message.
                System.out.println();
                lgPhone.connectsToWifi();

            } else if (BrandSelection == 7) {
                System.out.println("Nokia Slogan:" + nokiaSlogan);
                System.out.println();

                System.out.println("** SmartPhone Specifications **");
                nokiaPhone.displayPhoneSpecs();

                //calling the interface method and printing out its message.
                System.out.println();
                nokiaPhone.connectsToWifi();

            } else if (BrandSelection == 8) {
                System.out.println("Sony Slogan:" + sonySlogan);
                System.out.println();

                System.out.println("** SmartPhone Specifications **");
                sonyPhone.displayPhoneSpecs();

                //calling the interface method and printing out its message.
                System.out.println();
                sonyPhone.connectsToWifi();

            }

        } catch (Exception e) {
            LOGGER.severe("Error occurred in the main method: " + e.getMessage() + "LOGGER.severe");
            e.printStackTrace();
        }
    }
}

