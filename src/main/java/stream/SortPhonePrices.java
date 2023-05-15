package stream;

import phones.Phone;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Sort phone prices in descending order (non-terminal operation)
public class SortPhonePrices {
    public static List<Phone> sortPhonePricesDescending(List<Phone> phones) {
        return phones.stream()
                .sorted(Comparator.comparingDouble(Phone::getPrice).reversed())
                .collect(Collectors.toList());
    }
}
