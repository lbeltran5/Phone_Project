# Phone_Project
Home Task Requirements #3 #4 #5 #6 #7

Create a class hierarchy. Topic for your hierarchy will be provided by your mentors.
           please request it in your chat with a mentor.

                            **** SUBJECT: phones.Phone ****

Requirements for task #3:
- At least 10 classes
- **Different types of brands**
- All classes must contain properties (minimum 1)
- **Each phone brand contains unique feature**
- At least 5 private properties (in total, in any classes)
- **Each phone brand has private variable phoneMotto for brand slogan **
- All private variables must have getters and setters.
- **All classes contain getters and setter methods**
- All classes should have at least one custom constructor
- **Constructors for each class call different variables**
- Create separate class with main() which will instantiate objects of implemented classes.
 
Requirements for task #4
- Use polymorphism with at least one abstract class.
- ****Where: PhoneBrands.phones.Apple class with phones.Phone class multiple methods****
- Create and override at least one abstract method.
- ****Where: method showFeature() is abstract and overrides on phones.Samsung****
- Use at protected modifier at least 5
- ****Where: phones.Phone class uses 5 protected modifiers in its variables****
- Override methods from class Object (toString(), hashcode(), equals()) for at least 3 classes from the hierarchy.
- ****Where: Classes phones.Samsung, phones.Xiaomi, PhoneBrands.phones.Motorola uses the toString() to override a method****
 
Requirements for task #5
- Add 5 interfaces to the existing hierarchy.
- ****Where: apple, lg, nokia, sony, & phone****
- Use polymorphism with the abstract class and interface from the hierarchy.
- ****Where: connectToWifi() - PhoneBrands.phones.Apple - phones.Phone - phones.Connectivity****
- Create final class, method, variable.
- ****Where: phones.Xiaomi****
- Create a static block, method, variable.
- ****Where: PhoneBrands.phones.Huawei****

Requirements for task #6
- Create 5 custom exceptions.
- ***Created a PhoneException class with 5 custom exceptions***
- Handle exceptions in 2 ways.
- ***1. InputSelectionException is handle by try catch block in BrandSelection for user input***
- ***2. ModelNotFoundException is handle by throws keyword on phones.Phone class***
- Use try-catch with resources.
- ***Used the InputSelectionException and try-with-resources to end program***
- Log messages to the console, file.
- ***Used LOGGER.info.severe.warning to prompt multiple statements***

Requirements for task #7

- Add 5 collections to the hierarchy.
- ***Created a class PhoneCollections and used it to prompt the different child classes phone specs***
- ***Map,List and Set collections used for Apple, LG, Sony***
- Create custom implementation of LinkedList with generic and use it in your project.
- ***Added the generic class collections.CustomLinkedList and use it to implement a LinkedList in the PhoneMenu class***