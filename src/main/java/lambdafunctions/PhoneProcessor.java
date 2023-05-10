package lambdafunctions;


// Will use the LAMBDA FUNCTIONS Consumer to display phone specifications on the Nokia phone brand

// Definition for the Consumer lambda function
// Consumer: A function that takes an input and performs some action on it,
// without returning anything. NOT RETURNING BUT PRINTING OUT STRING TO CONSOLE

import phones.*;
import java.util.function.Consumer;

public class PhoneProcessor {

    private PhoneProcessor() {
        //private constructor to prevent instantiation
    }

 /*
     * Processes a Nokia phone using the specified consumer function.
     *
     * @param phone         The Nokia phone object to process.
     * @param phoneConsumer The consumer function to apply on the Nokia phone.
*/
    public static void processPhone(Nokia phone, Consumer<Nokia> phoneConsumer) {

        // Apply the consumer function on the Nokia phone
        phoneConsumer.accept(phone);
    }
}
