package stream;

import phones.Phone;

import java.util.List;
import java.util.Optional;

// Using 'findAny' to get any phone within a price range (terminal operation)
public class FindAnyPhones {
    public static Optional<Phone> findPhoneByPriceRange(List<Phone> phones, double minPrice, double maxPrice) {
        return phones.stream()
                .filter(phone -> phone.getPrice() >= minPrice && phone.getPrice() <= maxPrice)
                .findAny();
    }
}
