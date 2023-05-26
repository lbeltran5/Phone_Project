package stream;

import phones.*;
import java.util.List;
import java.util.stream.Collectors;

// Check if any phone has price greater than 1000 dlls (Terminal operation)

public class AnyMatchPhones {
    public String getPhoneDetails(Phone phone) {
        return "Expensive Phone Model: " + phone.getModel() + ", Price: $" + phone.getPrice();
    }

    // To check if any phone has a price greater than 1199 dollars
    public boolean hasExpensivePhone(List<Phone> phones) {
        return phones.stream()
                .anyMatch(phone -> phone.getPrice() > 1199);
    }

    // To get a list of phone with a price greater than 1199 dollars
    public List<Phone> getExpensivePhones(List<Phone> phones) {
        return phones.stream()
                .filter(phone -> phone.getPrice() > 1199)
                .collect(Collectors.toList());
    }
}