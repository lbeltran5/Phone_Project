package stream;

import phones.Phone;

import java.util.List;
import java.util.stream.Collectors;

// Map phones name to uppercase (non-terminal operation)
public class MapPhonesUpperCase {
    public static List<String> mapPhoneBrandsToUpperCase(List<Phone> phones) {
        return phones.stream()
                .map(phone -> phone.getBrandName().toUpperCase())
                .collect(Collectors.toList());
    }
}
