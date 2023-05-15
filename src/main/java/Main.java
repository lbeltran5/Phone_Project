// Importing necessary packages
import java.util.*;
import java.util.function.*;
import java.util.logging.Logger;
import collections.PhoneCollections;
import exceptions.*;
import interfaces.*;
import lambdafunctions.*;
import phones.*;
import enums.*;
import stream.*;

import java.util.ArrayList;
import java.util.List;

// Define a class for the main program
public class Main {

    //create a Logger object with the name "Main"
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static List<String> convertToPhoneNames(List<Phone> phones, Function<Phone, String> getNameFunction) {
        List<String> phoneNames = new ArrayList<>();    // Create a new list to store the phone names

        // To iterate over each phone in the list
        for (Phone phone : phones) {
            String name = getNameFunction.apply(phone); // Apply the getNameFunction to extract the name of the phone
            phoneNames.add(name);   // Add the extracted name to the list of phone names
        }
        return phoneNames;  // Return the list of phone names
    }

    public static void main(String[] args) {

        LOGGER.info("Main method initializing.");   // Log that the main method is starting

        ////////////////////////// Instantiation of objects used throughout the program //////////////////////////
        Samsung samsungPhone = new Samsung("Galaxy S23 Ultra", "Android 13", 1200,
                12, 1L, "Video Call Effects", "Together for tomorrow", "South Korea", "Samsung");
        Apple applePhone = new Apple("iPhone 14 Pro Max", "iOS 16", 1100,
                6, 1L, "Face ID feature", "Think different", "United States","Apple");
        Xiaomi xiaomiPhone = new Xiaomi("Xiaomi 13 Ultra", "Android 13", 1198,
                16, 1L, "thin and light screen", "Just for fans", "China", "Xiaomi");
        Motorola motorolaPhone = new Motorola("Motorola Edge 30 Ultra", "Android 12", 765,
                12, 512L, "OLED display", "Hello Moto!", "United States", "Motorola");
        Huawei huaweiPhone = new Huawei("Huawei P40 Pro", "Android 10", 650,
                8, 1L, "waterproof", "Building a Fully Connected, Intelligent World.", "China", "Huawei");
        LG lgPhone = new LG("LG V60 ThinQ", "Android 10", 800,
                8, 256L, "waterproof", "Life's Good","South Korea", "LG");
        Nokia nokiaPhone = new Nokia("Nokia XR20", "Android 11", 440,
                6, 128L, "Wireless Charging", "Connecting people","Finland", "Nokia");
        Sony sonyPhone = new Sony("Sony Xperia 5 IV", "Android 12", 998,
                8, 1L, "triple lens camera", "make.believe", "Japan","Sony");

        ////////////////////////// Unique Words in a Text File and Logging the Result //////////////////////////
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

        ////////////////////////// Displaying the Phone Menu catalog //////////////////////////
        PhoneMenu.PhoneDisplay();
        System.out.println("-----------------------------------------------------------");

        ////////////////////////// BrandFilter using the Predicate function //////////////////////////
        // Create a list of brands containing several phone brands names
        List<String> brands = Arrays.asList("Samsung", "Apple", "Sony", "Google", "Motorola");

        // Define the predicate to check if phone brands starts with "S"
        Predicate<String> startsWithSPredicate = brand -> brand.startsWith("S");

        // Will filter the brands using the provided predicate
        List<String> filteredBrands = BrandFilter.filterBrands(brands, startsWithSPredicate);

        // Print the filtered brands using System.out.println
        System.out.println("Filtered Brands using the Predicate lambda function:");
        for (String brand : filteredBrands) {
            System.out.println(brand);
        }

        System.out.println("-----------------------------------------------------------");

        ////////////////////////// PhoneNameConverter using the Function lambda function //////////////////////////

        // Create an instance of PhoneNameConverter
        PhoneNameConverter nameConverter = new PhoneNameConverter();

        // Convert the list of phones to a list of phone names
        List<String> phoneNames = convertToPhoneNames(Arrays.asList(samsungPhone, applePhone, xiaomiPhone,
                motorolaPhone, huaweiPhone, lgPhone, nokiaPhone, sonyPhone), nameConverter);

        // Print the phone names
        System.out.println("Phone brands converted into their phone model name using Function lambda function: ");
        System.out.println("Phone models: " + phoneNames);

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

        ////////////////////////// CustomLambdaPhoneCarrier with Generics  //////////////////////////

        CustomLambdaPhoneCarrier<String> carrier = new CustomLambdaPhoneCarrier<>("Verizon, T-Mobile, AT&T, Sprint, Google FI");
        String carrierName = carrier.get();
        System.out.println("Top Phone Services using a Custom Lambda Function ''Supplier'' with Generics:  ");
        System.out.println("Phone Carrier: " + carrierName);


        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

        ////////////////////////// CustomLambdaPhoneOrigin with Generics  //////////////////////////

        CustomLambdaPredicate<String> phoneOrigin = (origin) -> origin.equals("United States");

        List<Phone> brandOrigin = new ArrayList<>();
        brandOrigin.add(samsungPhone);
        brandOrigin.add(applePhone);
        brandOrigin.add(xiaomiPhone);
        brandOrigin.add(motorolaPhone);
        brandOrigin.add(huaweiPhone);
        brandOrigin.add(lgPhone);
        brandOrigin.add(nokiaPhone);
        brandOrigin.add(sonyPhone);

        List<Phone> selectedPhoneBrands = new ArrayList<>();
        for (Phone brand : brandOrigin){
            if (phoneOrigin.test(brand.getOrigin())){
                selectedPhoneBrands.add(brand);
            }
        }

        System.out.println("Phone brands with origin in the United States using Custom Lambda Predicate with Generics: ");
        for (Phone brand : selectedPhoneBrands) {
            System.out.println(brand.getBrandName());
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

        ////////////////////////// Enums to be used in the program  //////////////////////////
        System.out.println("Enums used for Camera Type, Display Type, and Phone Colors: ");

        // Using CameraTypeEnum
        CameraTypeEnum cameraType = CameraTypeEnum.FRONT;
        System.out.println("Camera Type: " + cameraType.getDescription());

        CameraTypeEnum.takePhoto(cameraType);
        CameraTypeEnum.recordVideo(CameraTypeEnum.REAR);

        System.out.println();

        // Using DisplayTypeEnum
        DisplayTypeEnum displayType = DisplayTypeEnum.OLED;
        System.out.println("Display Type: " + displayType.getDescription());

        DisplayTypeEnum.showContent(displayType);
        DisplayTypeEnum.adjustBrightness(DisplayTypeEnum.AMOLED, 5);

        System.out.println();

        // Using PhoneColorEnum
        PhoneColorEnum color1 = PhoneColorEnum.BLACK;
        System.out.println("Colors available in: " + color1.getColorName());

        PhoneColorEnum color2 = PhoneColorEnum.GOLD;
        System.out.println("Colors available in: " + color2.getColorName());

        PhoneColorEnum color3 = PhoneColorEnum.RED;

        color3.printColorInfo();

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

        ////////////////////////// Streams Collections //////////////////////////
        AnyMatchPhones anyMatchPhones = new AnyMatchPhones();
        CollectPhones collectPhones = new CollectPhones();


        // Check if any phone is expensive
        boolean hasExpensivePhone = anyMatchPhones.hasExpensivePhone(brandOrigin);
        System.out.println("Stream Collection 'anyMatch' use to return expensive phone model if true: ");
        System.out.println("Has expensive phone: " + hasExpensivePhone);

        // Get a list of expensive phones
        List<Phone> expensivePhonesList = anyMatchPhones.getExpensivePhones(brandOrigin);
        for (Phone phone : expensivePhonesList) {
            System.out.println(anyMatchPhones.getPhoneDetails(phone));
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

        double totalPrice = collectPhones.calculateTotalPrice(brandOrigin);
        System.out.println("Using Stream 'collect' to calculate total price of all phones: ");
        System.out.printf("Total Price: $%,.2f dlls%n", totalPrice);

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

        long ramCount = CountPhones.countPhonesWith8GBRAM(brandOrigin);
        System.out.println("Using the stream terminal operation 'count' to count the phones with 8GB RAM speed");
        System.out.println("Number of phones with 8GB RAM:" + ramCount);

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

        int minCapacity = 32; // Minimum storage capacity to filter by
        List<Phone> filteredPhones = FilterStoragePhones.filterPhonesByStorageCapacity(brandOrigin,minCapacity);
        System.out.println("Using the stream non-terminal operation 'filter' to filter out storage capacity of phone models");
        for (Phone phone : filteredPhones) {
            System.out.println(FilterStoragePhones.getStorageDetails(phone));
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

        Optional<Phone> phoneInRange = FindAnyPhones.findPhoneByPriceRange(brandOrigin, 300.0, 700.0);
        System.out.println("Using 'findAny' terminal operation to have a phone price within $300 and $700");
        if (phoneInRange.isPresent()) {
            System.out.println("Phone within price range found: " + phoneInRange.get().getModel());
        } else {
            System.out.println("No phone found within the price range.");
        }


        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

        List<String> brandsUpperCase = MapPhonesUpperCase.mapPhoneBrandsToUpperCase(brandOrigin);
        System.out.println("Phone brands in uppercase using the map non-terminal operation:");
        brandsUpperCase.forEach(System.out::println);


        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

        List<Phone> sortedPhones = SortPhonePrices.sortPhonePricesDescending(brandOrigin);
        System.out.println("Phone prices in descending order using the non-terminal sort operation:");

        sortedPhones.forEach(phone -> {
            String formattedPrice = String.format("%.2f", phone.getPrice());
            System.out.println(phone.getBrandName() + " - $" + formattedPrice + " dlls.");
        });

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

        ////////////////////////// Scanner and Exceptions for InvalidSelectionException //////////////////////////
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
            LOGGER.info("User selected Phone Brand: " + BrandSelection);

            // declaring and initializing string variables with slogans and different phones brands the slogan is obtained by calling a method on an object
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

            // ********** PhoneNumberGenerator using the Supplier function ***************

            // To call successfully the PhoneNumberGenerator to the main class
            String samsungPhoneNumber = PhoneNumberGenerator.generateSamsungPhoneNumber();

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

                    LOGGER.info("Generated Samsung phone number: " + samsungPhoneNumber);
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

                    /*LOGGER.info("** Nokia Specifications using concrete method **");
                    nokiaPhone.displayPhoneSpecs();*/

                    // Create a consumer to display phone specifications
                    Consumer<Nokia> displaySpecs= phone -> {
                        LOGGER.info("** Nokia Specifications using the Consumer lambda function **");
                        phone.displayPhoneSpecs();
                    };

                    // Process the nokiaPhone object using the PhoneProcessor and the consumer function
                    PhoneProcessor.processPhone(nokiaPhone, displaySpecs);

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

        // The scanner will be automatically closed at the end of the try block
        // When block completes the Scanner object is automatically closed
        // try-with-resources statement must implement "AutoClosable" interface.
        // Scanner class has this "AutoClosable"

    }

}