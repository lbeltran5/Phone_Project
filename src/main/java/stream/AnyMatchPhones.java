package stream;

import phones.*;

import java.util.List;
import java.util.stream.Collectors;

// Check if any phone has price greater than 1000 dlls (Terminal operation)

public class AnyMatchPhones {
    public String getPhoneDetails(Phone phone) {
        return "Expensive Phone Model: " + phone.getModel() + ", Price: $" + phone.getPrice();
    }
    public boolean hasExpensivePhone(List<Phone> phones) {
        return phones.stream()
                .anyMatch(phone -> phone.getPrice() > 1199);
    }

    public List<Phone> getExpensivePhones(List<Phone> phones) {
        return phones.stream()
                .filter(phone -> phone.getPrice() > 1199)
                .collect(Collectors.toList());
    }
}
