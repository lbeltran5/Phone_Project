package com.solvd.laba.stream;

import com.solvd.laba.phones.Phone;

import java.util.List;
import java.util.Optional;

// Using 'findAny' operation to get any phone within a certain price range (terminal operation)
public class FindAnyPhones {

    // These will find any phone within a given price range
    public static Optional<Phone> findPhoneByPriceRange(List<Phone> phones, double minPrice, double maxPrice) {
        return phones.stream()
                .filter(phone -> phone.getPrice() >= minPrice && phone.getPrice() <= maxPrice) // Filter phones within the specified price range
                .findAny(); // Find and return any phone from the filtered list
    }
}