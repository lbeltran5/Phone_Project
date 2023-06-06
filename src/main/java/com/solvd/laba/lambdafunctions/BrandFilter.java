package com.solvd.laba.lambdafunctions;

// Will use the LAMBDA FUNCTIONS PREDICATE to filter phone brands with starting letter "S"

// ***** DEFINITION OF THE LAMBDA FUNCTION PREDICATE *****
// The Predicate<String> interface to represent the filtering condition for brands.
// It leverages the test method of the Predicate interface to evaluate the condition for each brand in the list,
// allowing the filterBrands method to filter and return a new list of brands that satisfy the condition.

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BrandFilter {

    // This method will be used for filtering brands based on predicate
    public static List<String> filterBrands(List<String> brands, Predicate<String> predicate) {
        List<String> filteredList = new ArrayList<>();

        // Iterate over each brand in the input list
        for (String brand : brands) {
            // Check if the phone brand satisfy the provided predicate
            if (predicate.test(brand)) {
                // If so, add it to the filtered list
                filteredList.add(brand);
            }
        }

        // Return the filtered list of brands
        return filteredList;
    }
}
