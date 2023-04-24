/*
 * (Practical #3) Create a class hierarchy. Topic for your hierarchy will be provided by your mentors.
 *          please request it in your chat with a mentor.
 *
 *                           *** SUBJECT: Phone ***
 *
 *  Requirements for task #3:
 *  - At least 10 classes **CHECK** Different types of brands **CHECK**
 *  - All classes must contain properties (minimum 1) **CHECK**
 *  - At least 5 private properties (in total, in any classes) **CHECK**
 *  - All private variables must have getters and setters. **CHECK**
 *  - All classes should have at least one custom constructor **CHECK**
 *  - Create separate class with main() which will instantiate objects of implemented classes. **CHECK**
 *
 *  Requirements for task #4
 *  - Use polymorphism with at least one abstract class. **CHECK**
 *  - Create and override at least one abstract method. **CHECK**
 *  - Use at protected modifier at least 5  **CHECK**
 *  - Override methods from class Object (toString(), hashcode(), equals())
 *    for at least 3 classes from the hierarchy. **CHECK**
 *
 *  Requirements for task #5
 *  - Add 5 interfaces to the existing hierarchy.
            Where: apple,lg,nokia,sony, & phone ***CHECK***
 *  - Use polymorphism with the abstract class and interface from the hierarchy.
            Where: connectToWifi() - Apple - Phone - Connectivity *****CHECk*****
 *  - Create final class, method, variable.
            Where: Xiaomi ****CHECK****
 *  - Create a static block, method, variable.
 *          Where: Huawei ****CHECK****
 */

// Importing scanner for user input
import java.util.Scanner;

// Define a class for the main program
public class Main {

    public static void main(String[] args) {
        //Display the phone menu
        PhoneMenu.PhoneDisplay();

        // Creating a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Take the user selection input
        System.out.println("Enter the phone brand of your choice (1-8): ");
        int BrandSelection = scanner.nextInt();

        // Instantiate objects of implemented classes based on user input
        Samsung samsungPhone = new Samsung("Galaxy S23 Ultra", "Android 13", 1200,
                12,1L, "Video Call Effects", "Together for tomorrow");
        Apple applePhone = new Apple("iPhone 14 Pro Max", "iOS 16", 1100,
                6,1L, "Face ID feature", "Think different");
        Xiaomi xiaomiPhone = new Xiaomi("Xiaomi 13 Ultra", "Android 13", 1200,
                16,1L, "thin and light screen", "Just for fans");
        Motorola motorolaPhone = new Motorola("Motorola Edge 30 Ultra", "Android 12", 765,
                12,512L, "OLED display", "Hello Moto!");
        Huawei huaweiPhone = new Huawei("Huawei P40 Pro", "Android 10", 650,
                8,256L,"waterproof", "Building a Fully Connected, Intelligent World.");
        LG lgPhone = new LG("LG V60 ThinQ", "Android 10", 800,
                8,256L,"waterproof", "Life's Good");
        Nokia nokiaPhone = new Nokia("Nokia XR20", "Android 11", 440,
                6,128L,"Wireless Charging", "Connecting people");
        Sony sonyPhone = new Sony("Sony Xperia 5 IV", "Android 12", 998,
                8,256L,"triple lens camera", "make.believe");

        // appleCell is instance of the Apple class which is subclass of Phone
        // This allows appleCell to be treated as Phone object and use methods and properties
        //Phone appleCell = new Apple("iPhone 14 Pro Max", "iOS 16", 1100,
                //6,1L, "Face ID feature", "Think different");
        //Polymorphism with abstract class
        //appleCell.displayPhoneSpecs();

        //Polymorphism with the interface
        //Connectivity appleConnectivity = new Apple("iPhone 14 Pro Max", "iOS 16", 1100,
                //6,1L, "Face ID feature", "Think different");
        //appleConnectivity.connectsToWifi();


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

        // Using switch statements for user selection
        if (BrandSelection == 1) {
            System.out.println();
            //printing out the brand slogan by getting Samsung Motto method from Samsung Class
            System.out.println("Samsung Slogan:" + samsungSlogan);
            System.out.println();
            //printing out the title of specs
            System.out.println("** SmartPhone Specifications **");
            //displaying the phone specs by using the concrete method
            samsungPhone.displayPhoneSpecs();
            System.out.println();
            //displaying the override method using toString();
            //System.out.println(samsungPhone.toString());

            //displaying the brands feature by using the abstract method which is overridden from phone's class
            samsungPhone.showFeature();
        } else if (BrandSelection == 2) {
            System.out.println();
            System.out.println("Apple Slogan:" + appleSlogan);
            System.out.println();
            System.out.println("** SmartPhone Specifications **");
            applePhone.displayPhoneSpecs();
            System.out.println();

            //we are using the object "applePhone" to call the methods below which comes from
            // the Connectivity interfaces.
            applePhone.connectsToWifi();
        } else if (BrandSelection == 3) {
            System.out.println();
            System.out.println("Xiaomi Slogan:" + xiaomiSlogan);
            System.out.println();
            System.out.println("** SmartPhone Specifications **");
            xiaomiPhone.displayPhoneSpecs();
            xiaomiPhone.showFeature();
            //print out a toString
            //System.out.println(xiaomiPhone.toString());

            //final class, method, variable
            xiaomiPhone.xiaomiFinalMethod();
        } else if (BrandSelection == 4) {
            System.out.println();
            System.out.println("Motorola Slogan:" + motorolaSlogan);
            System.out.println();
            System.out.println("** SmartPhone Specifications **");
            motorolaPhone.displayPhoneSpecs();
            System.out.println();
            System.out.println(motorolaPhone.toString());
        } else if (BrandSelection == 5) {
            System.out.println();
            System.out.println("Huawei Slogan:" + huaweiSlogan);
            System.out.println();
            System.out.println("** SmartPhone Specifications **");
            huaweiPhone.displayPhoneSpecs();

            //static class, method, variable
            int count = Huawei.getCount();
            System.out.println("This is the static method for Huawei it counts the number of phones or objects created: " + count);
            System.out.println("Huawei has a static block, method, and static variable 'count'");
        } else if (BrandSelection == 6) {
            System.out.println();
            System.out.println("LG Slogan:" + lgSlogan);
            System.out.println();
            System.out.println("** SmartPhone Specifications **");
            lgPhone.displayPhoneSpecs();

            //calling the interface method and printing out its message.
            System.out.println();
            lgPhone.connectsToWifi();
        } else if (BrandSelection == 7) {
            System.out.println();
            System.out.println("Nokia Slogan:" + nokiaSlogan);
            System.out.println();
            System.out.println("** SmartPhone Specifications **");
            nokiaPhone.displayPhoneSpecs();

            //calling the interface method and printing out its message.
            System.out.println();
            nokiaPhone.connectsToWifi();
        } else if (BrandSelection == 8) {
            System.out.println();
            System.out.println("Sony Slogan:" + sonySlogan);
            System.out.println();
            System.out.println("** SmartPhone Specifications **");
            sonyPhone.displayPhoneSpecs();

            //calling the interface method and printing out its message.
            System.out.println();
            sonyPhone.connectsToWifi();
        } else {
            System.out.println("Invalid selection. Please try again.");
        }
/*        private void doSomething(Phone Samsung){
            Samsung.showFeature();
        }*/
    }
}


