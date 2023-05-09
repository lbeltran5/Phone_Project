// Importing necessary packages
import java.util.*;
import java.util.logging.Logger;
import collections.PhoneCollections;
import exceptions.*;
import phones.*;


// Define a class for the main program
public class Main {

    //create a Logger object with the name "Main"
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        //Log that the main method is starting
        LOGGER.info("Main method initializing.");

        // input & output paths variables
        String inputFilePath = "phone_Information.txt";
        String outputFilePath = "phone_colors_unique_words.txt";

        // Call the "countUniqueWords" method from the "UniqueWordCounter" class and pass
        // the input and output file paths as parameters. This method counts the number
        // of unique words in the input file and writes them to the output file.
        int uniqueWordCount = UniqueWordCounter.countUniqueWords(inputFilePath, outputFilePath);

        // Print the number of unique words counted by the "countUniqueWords" method
        // to the console.
        LOGGER.info("Unique word count in text file: " + uniqueWordCount);

        ////////////////////////// *********************** //////////////////////////

        //Display the phone menu
        PhoneMenu.PhoneDisplay();

        // Creating a scanner object to read user input
        try (Scanner scanner = new Scanner(System.in)) {
            // Log that the scanner object has been created
            LOGGER.info("Scanner object created.");
            // Take the user selection input
            System.out.println("Enter the phone brand of your choice (1-8): ");
            int BrandSelection;

            try {
                // Read the user input and validate it
                BrandSelection = scanner.nextInt();
                if (BrandSelection < 1 || BrandSelection > 8) {
                    // Throw an exception if the selection is Invalid
                    throw new InvalidSelectionException("Invalid selection. Please enter a number between 1 and 8." + " throws InvalidSelectionException");
                }
            } catch (InputMismatchException e) {
                // Log a warning if the user input is invalid
                LOGGER.warning(("Invalid input, this comes from LOGGER.warning."));
                System.out.println("Invalid input. Please enter a number between 1 and 8." + " InputMismatchException");
                scanner.next(); // clear the scanner buffer
                return;
            } catch (InvalidSelectionException e) {
                // Log a warning and print the error message if the Selection is Invalid.
                LOGGER.warning(e.getMessage());
                System.out.println(e.getMessage());
                return;
            }

            // Log the phone brand selected by the user
            LOGGER.info("User selected phones.Phone Brand: " + BrandSelection);

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
            //          phones.Samsung class to obtain the motto of samsung.
            String samsungSlogan = samsungPhone.getSamsungMotto();
            String appleSlogan = applePhone.getAppleMotto();
            String xiaomiSlogan = xiaomiPhone.getXiaomiMotto();
            String motorolaSlogan = motorolaPhone.getMotorolaMotto();
            String huaweiSlogan = huaweiPhone.getHuaweiMotto();
            String lgSlogan = lgPhone.getLgMotto();
            String nokiaSlogan = nokiaPhone.getNokiaMotto();
            String sonySlogan = sonyPhone.getSonyMotto();

            // Create a new instance of the PhoneCollection class
            PhoneCollections phoneCollections = new PhoneCollections();

            // Get the collections from the PhoneCollection object
            Map<String, String> mapApple = phoneCollections.getAppleMap();
            List<String> lgList = phoneCollections.getLgList();
            Set<String> sonySet = phoneCollections.getSonySet();

            // Switch statement for user selection
            switch (BrandSelection) {
                case 1:
                    //printing out the brand slogan using LOGGER
                    LOGGER.info("Samsung Slogan: " + samsungSlogan);

                    //printing out the title of specs
                    LOGGER.info("*** Samsung Specifications using toString() ***");
                    LOGGER.info(samsungPhone.toString());

                    LOGGER.info("Calling showFeature() method...");
                    samsungPhone.showFeature(); // calling the abstract method "showFeature()"
                    break;
                case 2:
                    LOGGER.info("Apple Slogan: " + appleSlogan);

                    LOGGER.info("** Apple Specifications using Map Collection **");

                    // iterate over the entries in the map
                    for (Map.Entry<String, String> entry : mapApple.entrySet()){
                        String key = entry.getKey();
                        String value = entry.getValue();
                        LOGGER.info(key + value);
                    }

                    LOGGER.info("Calling showFeature() method & Interface method...");
                    applePhone.showFeature();   // calling abstract method

                    applePhone.connectsToWifi(); // calling the connectsToWifi method from interface
                    break;
                case 3:
                    LOGGER.info("Xiaomi Slogan: " + xiaomiSlogan);

                    //title for the specs on toString() method
                    LOGGER.info("*** Xiaomi Specifications using toString() ***");
                    LOGGER.info(xiaomiPhone.toString());

                    LOGGER.info("Calling showFeature() method & Final method...");
                    //calling an abstract method "showFeature()"
                    xiaomiPhone.showFeature();

                    //final class, method, variable
                    xiaomiPhone.xiaomiFinalMethod();
                    break;
                case 4:
                    LOGGER.info("Motorola Slogan: " + motorolaSlogan);

                    //title for the specs on toString() method
                    LOGGER.info("*** Motorola Specifications using toString() ***");
                    LOGGER.info(motorolaPhone.toString());

                    // try-catch for the Exception for ModelNotFound
                    try {
                        //calling the findModel() method
                        Phone motorolaCell = motorolaPhone.findModel("Moto G");
                        String model = motorolaCell.getModel();

                        //printing the result
                        LOGGER.info("The model is: " + model);
                    } catch (ModelNotFoundException e) {
                        //if the model is not found, print the error message
                        LOGGER.info("Error: " + e.getMessage() + ". ModelNotFoundException handle with throw keyword.");
                    }
                    break;
                case 5:
                    LOGGER.info("Huawei Slogan: " + huaweiSlogan);

                    LOGGER.info("** Huawei Specifications using concrete method **");
                    huaweiPhone.displayPhoneSpecs();

                    //static class, method, variable
                    int count = Huawei.getCount();
                    LOGGER.info("This is the static method for Huawei it counts the number of phones or objects created: " + count);
                    LOGGER.info("Huawei has a static block, method, and static variable 'count'");
                    break;
                case 6:
                    LOGGER.info("LG Slogan: " + lgSlogan);

                    System.out.println("** LG Specifications using List Collection **");
                    // list collection to print out lg specs
                    for (String element: lgList){
                        LOGGER.info(element);
                    }

                    LOGGER.info("Calling showFeature() method & Interface method...");
                    lgPhone.showFeature(); // calling abstract method from Child class

                    //calling the interface method and printing out its message.
                    lgPhone.connectsToWifi();
                    break;
                case 7:
                    LOGGER.info("Nokia Slogan: " + nokiaSlogan);

                    LOGGER.info("** Nokia Specifications using concrete method **");
                    nokiaPhone.displayPhoneSpecs();

                    //calling the interface method and printing out its message.
                    nokiaPhone.connectsToWifi();
                    break;
                case 8:
                    LOGGER.info("Sony Slogan: " + sonySlogan);

                    LOGGER.info("** Sony Specifications using Set Collection **");

                    // printing out the set collection for phones.Sony Specs
                    for(String element: sonySet){
                        System.out.println(element);
                    }

                    LOGGER.info("Calling showFeature() method & Interface method...");
                    sonyPhone.showFeature();

                    //calling the interface method and printing out its message.
                    sonyPhone.connectsToWifi();
                    break;
                default:
                    // throw and exception if input doesn't match any of the cases
                    throw new IllegalArgumentException("Invalid input: " + BrandSelection);
            }
        } catch (Exception e) {
            // log the error message with the LOGGER object
            LOGGER.severe("Error occurred in the main method: " + e.getMessage() + "LOGGER.severe");
            // print the stack trace to the console for debugging purposes
            e.printStackTrace();
        }
    }
}