# Phone_Project
Create a class hierarchy. Topic for your hierarchy will be provided by your mentors.
please request it in your chat with a mentor.

<sup>Home Task Requirements #3 #4 #5 #6 #7 #8 #9 #10 #11 #12 </sup>


                                            SUBJECT: Phone

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
| Use polymorphism with the abstract class and interface from the hierarchy. | connectToWifi() -> Apple -> Phone -> interfaces.com.solvd.laba.Connectivity  |
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
| Use polymorphism with the abstract class and interface from the hierarchy | connectToWifi() -> Apple -> Phone -> interfaces.com.solvd.laba.Connectivity  |
| Create custom implementation of LinkedList with generic and use it in your project | Added the generic class CustomLinkedList and use it to implement a LinkedList in the com.solvd.laba.PhoneMenu class  |

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
| com.solvd.laba.Main requirement is: using StringUtils and FileUtils to implement it with minimum lines of code | <ul><li>com.solvd.laba.UniqueWordCounter StringUtils and FileUtils</li><li>StringUtils is used to split the content of the input file into wordsli><li>FileUtils to read the input file contents into a string & write number of unique words in a file</li></ul>
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
| Create Connection Pool. Use collection from java.util.concurrent package. Connection class may be mocked. The pool should be threadsafe and lazy initialized. | ConnectionPool has a size of 5 and uses singlenton thread |
| Initialize Connection Pool object of size 5. Load Connection Pool using single threads and Java Thread Pool (7 threads in total) | Connection class and also created the DemoConnectionPool class to demonstrate usage |
| 5 threads should be able to get the connection. 2 Threads should wait for the next available connection. The program should wait as well | Connection class and also created the DemoConnectionPool class to demonstrate usage |
| Implement previous point but with interfaces Future and CompletableStage | ConnectionPool class as well as DemoConnectionPool class implement all three tasks on Connection pool, refer to comments in both classes |

</details>


<details>

<summary>Home Task #13</summary>

### Requirements for Home task #13

| **Requirements**  | **Implementation** |
| -- | ------------- |
| Build hierarchy for Schema from the below course | DAO and Model hierarchy classes have been created |
| Create DAO classes with necessary interfaces, abstract classes, and Generics.  DAO should be scalable and flexible to support another framework and another database as well. All CRUD operations should be supported using JDBC. Use connection pool from the below block | dao, model, and services packages; dao contains jdbc package with DAO implementaion class with a generic DAO interface, model package contains all Model classes, and services contains implementations package has well has Generic Services |
| Implement Service layer with necessary abstraction to be able to switch between databases and frameworks | Service package -> Generic Services interface & implementation package with Services for classes. |

</details>


<details>

<summary>Home Task #14</summary>

### Requirements for Home task #14

| **Requirements**  | **Implementation** |
| -- | ------------- |
| Create one XML file and XSD schema for at least 5 classes from the below hierarchy | Added XML and XSD that contains 5 classes: Brands,Countries,OperatingSystem,Phones,and UserAccounts|
| Validate XML file using XSD schema and assigned parser | Used validateXMLAgainstXSD, SchemaFactory, and the validator classes to perform the validation process |
| Parse XML file using one of the parsers from the title | The com.solvd.laba.ParserRunner clas parsers the XML file using the DocumentBuilder class. |

</details>


<details>

<summary>Home Task #15</summary>

### Requirements for Home task #15

| **Requirements**  | **Implementation** |
| -- | ------------- |
| Add JAXB annotations to the hierarchy. Date, List, and complex objects should be covered | Added JAXB annotations to the model hierarchy date is being handle by Brand Model as Phone Brand Foundation Date and list is handle by Phone Model for Phone Features every other complex objects is from other classes |
| Parse XML using JAXB | The JAXBParserRunner class uses the JAXBContext class to create a JAXB context for the PhoneData class: JAXBContext and other methods such as unmarshall; Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();|

</details>

<details>

<summary>Home Task #16</summary>

### Requirements for Home task #16

| **Requirements**  | **Implementation** |
| -- | ------------- |
| Create one Json file for at least 5 classes from the hierarchy. | Implementation here |
| Add Jackson’s annotation to the hierarchy. Date, List, and complex objects should be covered. | Implementation here |
| Parse JSON using Jackson | Implementation here |

</details>

<details>

<summary>Home Task #17</summary>

### Requirements for Home task #17

| **Requirements**  | **Implementation** |
| -- | ------------- |
| Add MyBatis DAOs to the existing hierarchy with the same requirements. Choose any XML or interface mapping. | Implementation here |
| Switch service classes to MyBatis. | Implementation here |

</details>

This is an attempt by Ella to make minor changes and perform a pull 
request. Please make sure the changes are visible on your side, and merge 
if no conflicts


