package reflection;

import phones.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PhoneReflection {
    public static void main(String[] args) throws Exception {
        // Accessing class information using reflection
        Class<?> phoneClass = Samsung.class;

        // Getting information about constructors
        Constructor<?>[] constructors = phoneClass.getDeclaredConstructors();
        System.out.println("Constructors:");
        for (Constructor<?> constructor : constructors) {
            System.out.println("Constructor's Name: " + constructor.getName());
            System.out.println("Parameter Types: ");
            for (Class<?> parameterType : constructor.getParameterTypes()) {
                System.out.println(" - " + parameterType.getSimpleName());
            }
            System.out.println("Constructor Modifiers: " + constructor.getModifiers());
            System.out.println("--------------------");
        }

        // Getting information about fields
        Field[] fields = phoneClass.getDeclaredFields();
        System.out.println("Fields:");
        for (Field field : fields) {
            System.out.println("Field Name: " + field.getName());
            System.out.println("Field Type: " + field.getType().getSimpleName());
            System.out.println("Field Modifiers: " + field.getModifiers());
            System.out.println("--------------------");
        }

        // Getting information about methods
        Method[] methods = phoneClass.getDeclaredMethods();
        System.out.println("Methods:");
        for (Method method : methods) {
            System.out.println("Method Name: " + method.getName());
            System.out.println("Return Type: " + method.getReturnType().getSimpleName());
            System.out.println("Method Modifiers: " + method.getModifiers());
            System.out.println("--------------------");
        }

        // Creating an instance of Phone using reflection
        Phone phone = (Phone) phoneClass.getDeclaredConstructor().newInstance();
        System.out.println("Created Phone instance using reflection: " + phone);

        // Invoking a method using reflection
        Method setBrandNameMethod = phoneClass.getDeclaredMethod("setBrandName", String.class);
        setBrandNameMethod.invoke(phone, "Example Brand");
        System.out.println("Invoked setBrandName method using reflection. Brand Name: " + phone.getBrandName());
    }
}
