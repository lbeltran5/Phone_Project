package com.solvd.laba;

import com.solvd.laba.lambdafunctions.BrandFilter;
import com.solvd.laba.lambdafunctions.CustomLambdaPhoneCarrier;
import com.solvd.laba.lambdafunctions.PhoneNameConverter;
import com.solvd.laba.phones.*;
import com.solvd.laba.stream.*;
import com.solvd.laba.enums.*;
import com.solvd.laba.interfaces.*;
import com.solvd.laba.threads.*;

import java.util.*;
import java.util.function.*;
import java.util.logging.*;

public class LambdaMain {

    public static List<String> convertToPhoneNames(List<Phone> phones, Function<Phone, String> nameConverter) {
        List<String> phoneNames = new ArrayList<>();
        for (Phone phone : phones) {
            String name = nameConverter.apply(phone);
            phoneNames.add(name);
        }
        return phoneNames;
    }

    private static final Logger LOGGER = Logger.getLogger(LambdaMain.class.getName());

    public static void main(String[] args){

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
                8, 1L, "Waterproof", "Building a Fully Connected, Intelligent World.", "China", "Huawei");
        LG lgPhone = new LG("LG V60 ThinQ", "Android 10", 800,
                8, 256L, "waterproof", "Life's Good","South Korea", "LG");
        Nokia nokiaPhone = new Nokia("Nokia XR20", "Android 11", 440,
                6, 128L, "Wireless Charging", "Connecting people","Finland", "Nokia");
        Sony sonyPhone = new Sony("Sony Xperia 5 IV", "Android 12", 998,
                8, 1L, "triple lens camera", "make.believe", "Japan","Sony");


        ////////////////////////// BrandFilter using the Predicate function //////////////////////////
        // Create a list of brands containing several phone brands names
        List<String> brands = Arrays.asList("Samsung", "Apple", "Sony", "Google", "Motorola");

        // Define the predicate to check if phone brands starts with "S"
        Predicate<String> startsWithSPredicate = brand -> brand.startsWith("S");

        // Will filter the brands using the provided predicate
        List<String> filteredBrands = BrandFilter.filterBrands(brands, startsWithSPredicate);

        // Print the filtered brands using System.out.println
        LOGGER.info("Filtered Brands using the Predicate lambda function:");
        for (String brand : filteredBrands) {
            LOGGER.info(brand);
        }

        ////////////////////////// PhoneNameConverter using the Function lambda function //////////////////////////

        // Create an instance of PhoneNameConverter
        PhoneNameConverter nameConverter = new PhoneNameConverter();

        // Convert the list of phones to a list of phone names
        List<String> phoneNames = convertToPhoneNames(Arrays.asList(samsungPhone, applePhone, xiaomiPhone,
                motorolaPhone, huaweiPhone, lgPhone, nokiaPhone, sonyPhone), nameConverter);

        // Print the phone names
        LOGGER.info("Phone brands converted into their phone model name using Function lambda function: ");
        LOGGER.info("Phone models: " + phoneNames);

        ////////////////////////// CustomLambdaPhoneCarrier with Generics  //////////////////////////

        CustomLambdaPhoneCarrier<String> carrier = new CustomLambdaPhoneCarrier<>("Verizon, T-Mobile, AT&T, Sprint, Google FI");
        String carrierName = carrier.get();
        LOGGER.info("Top Phone Services using a Custom Lambda Function ''Supplier'' with Generics:  ");
        LOGGER.info("Phone Carrier: " + carrierName);

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

        LOGGER.info("Phone brands with origin in the United States using Custom Lambda Predicate with Generics: ");
        for (Phone brand : selectedPhoneBrands) {
            LOGGER.info(brand.getBrandName());
        }

        ////////////////////////// Enums to be used in the program  //////////////////////////
        LOGGER.info("Enums used for Camera Type, Display Type, and Phone Colors: ");

        // Using CameraTypeEnum
        CameraTypeEnum cameraType = CameraTypeEnum.FRONT;
        LOGGER.info("Camera Type: " + cameraType.getDescription());

        CameraTypeEnum.takePhoto(cameraType);
        CameraTypeEnum.recordVideo(CameraTypeEnum.REAR);

        // Using DisplayTypeEnum
        DisplayTypeEnum displayType = DisplayTypeEnum.OLED;
        LOGGER.info("Display Type: " + displayType.getDescription());

        DisplayTypeEnum.showContent(displayType);
        DisplayTypeEnum.adjustBrightness(DisplayTypeEnum.AMOLED, 5);

        // Using PhoneColorEnum
        PhoneColorEnum color1 = PhoneColorEnum.BLACK;
        LOGGER.info("Colors available in: " + color1.getColorName());

        PhoneColorEnum color2 = PhoneColorEnum.GOLD;
        LOGGER.info("Colors available in: " + color2.getColorName());

        PhoneColorEnum color3 = PhoneColorEnum.RED;
        color3.printColorInfo();


        ////////////////////////// Streams Collections //////////////////////////
        AnyMatchPhones anyMatchPhones = new AnyMatchPhones();
        CollectPhones collectPhones = new CollectPhones();


        // Check if any phone is expensive
        boolean hasExpensivePhone = anyMatchPhones.hasExpensivePhone(brandOrigin);
        LOGGER.info("Stream Collection 'anyMatch' use to return expensive phone model if true: ");
        LOGGER.info("Has expensive phone: " + hasExpensivePhone);

        // Get a list of expensive phones
        List<Phone> expensivePhonesList = anyMatchPhones.getExpensivePhones(brandOrigin);
        for (Phone phone : expensivePhonesList) {
            System.out.println(anyMatchPhones.getPhoneDetails(phone));
        }

        double totalPrice = collectPhones.calculateTotalPrice(brandOrigin);
        LOGGER.info("Using Stream 'collect' to calculate total price of all phones: ");
        LOGGER.info("Total Price: $" + String.format("%.2f", totalPrice) + " dlls");

        long ramCount = CountPhones.countPhonesWith8GBRAM(brandOrigin);
        LOGGER.info("Using the stream terminal operation 'count' to count the phones with 8GB RAM speed");
        LOGGER.info("Number of phones with 8GB RAM: " + ramCount);

        int minCapacity = 32; // Minimum storage capacity to filter by
        List<Phone> filteredPhones = FilterStoragePhones.filterPhonesByStorageCapacity(brandOrigin, minCapacity);
        LOGGER.info("Using the stream non-terminal operation 'filter' to filter out storage capacity of phone models");
        for (Phone phone : filteredPhones) {
            LOGGER.info(FilterStoragePhones.getStorageDetails(phone));
        }

        Optional<Phone> phoneInRange = FindAnyPhones.findPhoneByPriceRange(brandOrigin, 300.0, 700.0);
        LOGGER.info("Using 'findAny' terminal operation to have a phone price within $300 and $700");
        if (phoneInRange.isPresent()) {
            LOGGER.info("Phone within price range found: " + phoneInRange.get().getModel());
        } else {
            LOGGER.info("No phone found within the price range.");
        }

        List<String> brandsUpperCase = MapPhonesUpperCase.mapPhoneBrandsToUpperCase(brandOrigin);
        LOGGER.info("Phone brands in uppercase using the map non-terminal operation:");
        brandsUpperCase.forEach(LOGGER::info);

        List<Phone> sortedPhones = SortPhonePrices.sortPhonePricesDescending(brandOrigin);
        LOGGER.info("Phone prices in descending order using the non-terminal sort operation:");

        sortedPhones.forEach(phone -> {
            String formattedPrice = String.format("%.2f", phone.getPrice());
            LOGGER.info(phone.getBrandName() + " - $" + formattedPrice + " dlls.");
        });

        ////////////////////////// THREADS //////////////////////////

        //// **** ***** **** *** Thread **** ***** **** *** ////

        //Instance of PhoneThread
        PhoneThread phoneThread = new PhoneThread();

        // starting the thread
        phoneThread.start();

        // Code to the main thread
        LOGGER.info("com.solvd.laba.Main Thread is running");

        //// **** ***** **** *** Runnable **** ***** **** *** ////

        // Create instances of PhoneRunnable
        PhoneRunnable runnable1 = new PhoneRunnable("from PhoneRunnable");

        // Create Thread objects, passing the PhoneRunnable instances as parameters
        Thread thread1 = new Thread(runnable1);

        // Start the threads
        thread1.start();
    }
}
