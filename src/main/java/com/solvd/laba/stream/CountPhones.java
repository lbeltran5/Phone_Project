package com.solvd.laba.stream;

import com.solvd.laba.phones.*;


import java.util.*;

//Count the number of phones with 8GB ram (terminal operation)
public class CountPhones {

    // To count the number of phones with 8GB RAM in the list
    public static long countPhonesWith8GBRAM(List<Phone> phones) {
        return phones.stream()
                .filter(phone -> phone.getSpeed() == 8)     //Filter phones with 8GB RAM
                .count();       // to count the number of filtered phones
    }
}