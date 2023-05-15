package stream;

import phones.*;

import java.util.*;

//Count the number of phones with 8GB ram (terminal operation)
public class CountPhones {
    public static long countPhonesWith8GBRAM(List<Phone> phones) {
        return phones.stream()
                .filter(phone -> phone.getSpeed() == 8)
                .count();
    }
}
