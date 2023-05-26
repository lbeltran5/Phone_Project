package stream;

import phones.*;
import java.util.*;

// collect operation to calculate the total price of all phones (terminal operation)
public class CollectPhones {

    // Calculate the total price of all phones in the list
    public double calculateTotalPrice(List<Phone> phones) {
        return phones.stream()
                .mapToDouble(Phone::getPrice)   //  Convert Phone object to their prices
                .sum();     // Sum up all the prices
    }
}
