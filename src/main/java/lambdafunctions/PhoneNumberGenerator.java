package lambdafunctions;

// Will use the LAMBDA FUNCTIONS SUPPLIER to generate a random phone number

// ***** DEFINITION OF THE LAMBDA FUNCTION SUPPLIER *****
// Supplier: A function that takes no input and returns a value.
// For example, you can create a supplier that generates a random integer:

import java.util.Random;
import java.util.function.Supplier;

public class PhoneNumberGenerator {

    // Creating a random object to generate random numbers
    private static final Random random = new Random();

    // Static method to generate the random Samsung phone number
    public static String generateSamsungPhoneNumber() {

        // Creating the Supplier to generate the phone number using lambda expression
        Supplier<String> samsungPhoneNumberGenerator = () -> {
            String prefix = "+1-760-SAMSUNG-";  // Set the prefix of the phone number
            String suffix = String.format("%04d", random.nextInt(10000)); // Generate 4-digit random #
            return prefix + suffix; // combine the prefix and suffix to form the newly random phone number
        };

        // Return the method on the supplier to generate the Samsung Phone Number
        return samsungPhoneNumberGenerator.get();
    }
}
