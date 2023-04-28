//Defining a class for phone market menu
public class PhoneMenu {

    //Defining the phone market menu method
    public static void PhoneDisplay() {
        CustomLinkedList<String> phoneBrands = new CustomLinkedList<>();
        phoneBrands.add("Samsung");
        phoneBrands.add("Apple");
        phoneBrands.add("Xiaomi");
        phoneBrands.add("Motorola");
        phoneBrands.add("Huawei");
        phoneBrands.add("LG");
        phoneBrands.add("Nokia");
        phoneBrands.add("Sony");

        System.out.println("Welcome to the Phone Catalog!");
        System.out.println("Please select a brand of your choice for Specifications:");
        for (int i = 0; i < phoneBrands.size(); i++){
            System.out.println((i + 1)+". "+ phoneBrands.get(i));
        }
    }
}
