import collections.*;

//Defining a class for phone market menu
public class PhoneMenu {

    //Defining the phone market menu method
    public static void PhoneDisplay() {
        // create a linked list to store the phone brands
        CustomLinkedList<String> phoneBrands = new CustomLinkedList<>();
        phoneBrands.add("Samsung");     // add phones.Phone Brands to the linked list
        phoneBrands.add("Apple");
        phoneBrands.add("Xiaomi");
        phoneBrands.add("Motorola");
        phoneBrands.add("Huawei");
        phoneBrands.add("LG");
        phoneBrands.add("Nokia");
        phoneBrands.add("Sony");

        System.out.println("Welcome to the phones.Phone Catalog!");    // print a welcome message
        System.out.println("Please select a brand of your choice for Specifications:"); // user selection
        for (int i = 0; i < phoneBrands.size(); i++){   //loop through the linked list
            System.out.println((i + 1)+". "+ phoneBrands.get(i));   // print each phone brand with corresponding number.
        }
    }
}
