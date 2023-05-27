# Phone_Project
Create a class hierarchy. Topic for your hierarchy will be provided by your mentors.
please request it in your chat with a mentor.

<sup>Home Task Requirements #3 #4 #5 #6 #7 #8 #9 #10 #11 #12 </sup>


                                            #SUBJECT: Phone

<details>

<summary>Home Task #3</summary>

### Requirements for Home task #3

| **Requirements**  | **Implementation** |
| -- | ------------- |
| Create at least 10 classes | Created different types of phone brands  |
| All classes must contain properties | Each phone brand contains unique feature  |
| Create at least 10 classes | Created different types of phone brands  |
| At least 5 private properties | Each phone brand has private variables ex: phoneMotto for brand slogan  |
| All private variable must have getters and setter methods | All classes contain getters and setters methods  |
| All classes should have at least one custom constructor | Constructors for each class call different variables  |

Create separate class with main() which will instantiate objects of implemented classes.

</details>

<details>

<summary>Home Task #4</summary>

### Requirements for Home task #4

| **Requirements**  | **Implementation** |
| -- | ------------- |
| Use polymorphism with at least one abstract class | Apple class with Phone class multiple methods  |
| Create and override at least one abstract method | method showFeature() is abstract and overrides on Samsung  |
| Use protected modifier at least 5 | Phone class uses 5 protected modifiers in its variables  |
| Override methods from class Object (toString(), hashcode(), equals()) for at least 3 classes from the hierarchy. | Classes Samsung, Xiaomi, Motorola uses the toString() to override a method |

</details>

<details>

<summary>Home Task #5</summary>

### Requirements for Home task #5

| **Requirements**  | **Implementation** |
| -- | ------------- |
| Add 5 interfaces to the existing hierarchy | apple, lg, nokia, sony, & phone classes  |
| Use polymorphism with the abstract class and interface from the hierarchy. | connectToWifi() -> Apple -> Phone -> interfaces.Connectivity  |
| Create final class, method, variable | Xiaomi class  |
| Create a static block, method, variable | Huawei class |

</details>

<details>

<summary>Home Task #6</summary>

### Requirements for Home task #6

| **Requirements**  | **Implementation** |
| -- | ------------- |
| Create 5 custom exceptions | Created a PhoneExceptions class with 5 custom exceptions under exceptions package  |
| Handle exceptions in 2 ways | <ul><li>1. InputSelectionException is handle by try catch block in BrandSelection for user input</li><li>2. ModelNotFoundException is handle by throws keyword on Phone class</li></ul> |
| Use try-catch with resources | Used the InputSelectionException and try-with-resources to end program  |
| Log messages to the console, file | Used LOGGER.info.severe.warning to prompt multiple statements |

</details>

<details>

<summary>Home Task #7</summary>

### Requirements for Home task #7

| **Requirements**  | **Implementation** |
| -- | ------------- |
| Add 5 collections to the hierarchy | <ul><li>Created a class PhoneCollections and used it to prompt the different child classes phone specs</li><li>Map,List and Set collections used for Apple, LG, Sony</li></ul>  |
| Use polymorphism with the abstract class and interface from the hierarchy | connectToWifi() -> Apple -> Phone -> interfaces.Connectivity  |
| Create custom implementation of LinkedList with generic and use it in your project | Added the generic class CustomLinkedList and use it to implement a LinkedList in the PhoneMenu class  |

</details>


<details>

<summary>Home Task #8</summary>

### Requirements for Home task #8

| **Requirements**  | **Implementation** |
| -- | ------------- |
| Move all projects to Maven | moved project into maven repository  |
| Build jar file and deploy to the local repository | SNAPSHOT.jar file in the target folder  |
| Add and use 2 Plugins | Added log4j-core & log4j-api and then commons-lang3 & commons-io  |
| Run mvn for different phases from the Maven lifecycle. Check the result. | Used clean, validate and deploy |

</details>

<details>

<summary>Home Task #9</summary>

### Requirements for Home task #9

| **Requirements**  | **Implementation** |
| -- | ------------- |
| Read text from the file and calculate the numbers of the unique words | Created a text file phone_Information.txt |
| Write the result to the file | Output file is called phone_colors_unique_words.txt  |
| Main requirement is: using StringUtils and FileUtils to implement it with minimum lines of code | <ul><li>UniqueWordCounter StringUtils and FileUtils</li><li>StringUtils is used to split the content of the input file into wordsli><li>FileUtils to read the input file contents into a string & write number of unique words in a file</li></ul>
|

</details>

<details>

<summary>Home Task #10</summary>

### Requirements for Home task #10

| **Requirements**  | **Implementation** |
| -- | ------------- |
| Use at least 5 lambda functions from the java.util.function package | <ul><li>Used Consumer in the PhoneProcessor</li><li>Used Function in the PhoneNameConverter class</li><li>Used Predicate in the BandFilter class</li><li>Used Supplier in the PhoneNumberGenerator</li></ul> |
| Create 3 custom Lambda functions with generics | <ul><li>CustomLambdaSupplier -> CustomLambdaPhoneCarrier</li><li>CustomLambdaPredicate -> CustomLambdaOrigin</li></ul>|
| Create 5 complex Enums(with fields, methods, blocks | <ul><li>Created 3 complex Enums with field variables, methods and block</li><li>CameraTypeEnum, DisplayTypeEnum, PhoneColorEnum</li></ul> |

</details>

<details>

<summary>Home Task #11</summary>

### Requirements for Home task #11

| **Requirements**  | **Implementation** |
| -- | ------------- |
| Add 7 collection streaming in the hierarchy with terminal and non-terminal operations | <ul><li>Package Stream added it contains 7 classes with terminal and non-terminal operations to used in the program</li><li>Terminal Operation: collect, count, anyMatch, findAny</li><li>Non-Terminal Operations: filter, map, sorted</li></ul> |
| Handle exceptions in 2 ways | <ul><li>1. InputSelectionException is handle by try catch block in BrandSelection for user input</li><li>2. ModelNotFoundException is handle by throws keyword on Phone class</li></ul> |
| Using reflection extract information(modifiers, return types, parameters, etc) about fields, constructors, methods. Create object and call method using the only reflection | Created a reflection class PhoneReflection to extract information from constructors fields and methods from Samsung class  |
| Log messages to the console, file | Used LOGGER.info.severe.warning to prompt multiple statements |

</details>

<details>

<summary>Home Task #12</summary>

### Requirements for Home task #12

| **Requirements**  | **Implementation** |
| -- | ------------- |
| Create 2 Threads using Runnable and Thread | Package thread 2 threads PhoneThread and PhoneRunnable to implement threads |
| Create Connection Pool. Use collection from java.util.concurrent package. Connection class may be mocked. The pool should be threadsafe and lazy initialized. | Implementation here |
| Initialize Connection Pool object of size 5. Load Connection Pool using single threads and Java Thread Pool (7 threads in total) | Implementation here |
| 5 threads should be able to get the connection. 2 Threads should wait for the next available connection. The program should wait as well | Implementation here |
| Implement previous point but with interfaces Future and CompletableStage | Implementation here |

</details>
