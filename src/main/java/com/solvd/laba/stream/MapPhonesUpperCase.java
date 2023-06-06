package com.solvd.laba.stream;

import com.solvd.laba.phones.Phone;

import java.util.List;
import java.util.stream.Collectors;

// Map phones name to uppercase (non-terminal operation)
public class MapPhonesUpperCase {

    //To map phones brands to uppercase
    public static List<String> mapPhoneBrandsToUpperCase(List<Phone> phones) {
        return phones.stream()
                .map(phone -> phone.getBrandName().toUpperCase()) // Map each phone's brand name to uppercase
                .collect(Collectors.toList());  // Collect the mapped brand names into a list
    }
}
