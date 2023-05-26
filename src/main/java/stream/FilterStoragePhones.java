package stream;

import phones.Phone;
import java.util.List;
import java.util.stream.Collectors;

// Filter phones by storage capacity (non-terminal operation)
public class FilterStoragePhones {

    // To get storage details from a phone brand
    public static String getStorageDetails(Phone phone) {
        long storageCapacity = phone.getStorageCapacity();
        String brand = phone.getBrandName();
        String storageDetails;

        if (storageCapacity >= 512) {
            storageDetails = brand + " has High storage capacity phone models of: " + storageCapacity + " GB";
        } else if (storageCapacity >= 256) {
            storageDetails = brand + " has Medium storage capacity phone models of: " + storageCapacity + " GB";
        } else {
            storageDetails = brand + " has Low storage capacity phone models of: " + storageCapacity + " GB";
        }

        return storageDetails;
    }

    // To filter phones by storage capacity
    public static List<Phone> filterPhonesByStorageCapacity(List<Phone> phones, int minCapacity) {
        return phones.stream()
                .filter(phone -> phone.getStorageCapacity() >= minCapacity)
                .collect(Collectors.toList());
    }
}