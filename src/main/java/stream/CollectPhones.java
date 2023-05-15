package stream;

import phones.*;

import java.util.*;

// collect operation to calculate the total price of all phones (terminal operation)
public class CollectPhones {
    public double calculateTotalPrice(List<Phone> phones) {
        double totalPrice = phones.stream()
                .mapToDouble(Phone::getPrice)
                .sum();

        return totalPrice;
    }
}
