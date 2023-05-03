package Collections;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class PhoneCollections{
    private final Map<String, String> appleMap; // defining instance variables for collections
    private final  List<String> lgList;     // with private and final
    private final Set<String> sonySet;      // private only access within class and final cannot change once initialized

    public PhoneCollections(){
        appleMap = new HashMap<>();     // Creating the collections
        lgList = new LinkedList<>();
        sonySet = new HashSet<>();

        // Populating the map with String
        appleMap.put("Phone Model: ", "iPhone 14 Pro Max");
        appleMap.put("Operating System: ", "iOS 16");
        appleMap.put("Price: ", "$1100 USD");
        appleMap.put("Processor Speed: ", "6 GB");
        appleMap.put("Storage Capacity: ", "1 TB");

        // Populating the List and ArrayList with Phones.LG information
        lgList.add("Phone Model: LG V60 ThinQ");
        lgList.add("Operating System: Android 10");
        lgList.add("Price: $800 USD");
        lgList.add("Processor Speed: 8 GB");
        lgList.add("Storage Capacity: 256 GB");

        // Populating the ArrayList and ArrayList with Phones.Nokia Specs
        sonySet.add("Phone Model: Sony Xperia 5 IV");
        sonySet.add("Operating System: Android 12");
        sonySet.add("Price: $998 USD");
        sonySet.add("Processor Speed: 8 GB");
        sonySet.add("Storage Capacity: 256 GB");
    }

    // GETTERS for the collections
    public Map<String, String> getAppleMap() {
        return appleMap;
    }

    public List<String> getLgList(){
        return lgList;
    }

    public Set<String> getSonySet() {
        return sonySet;
    }

}