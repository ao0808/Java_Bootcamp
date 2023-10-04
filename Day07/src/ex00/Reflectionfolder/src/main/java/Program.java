package ex00.Reflectionfolder.src.main.java;

import ex00.Reflectionfolder.src.main.java.classes.Car;
import ex00.Reflectionfolder.src.main.java.classes.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Program {
    static Class classUser;
    static Class classCar;

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        classUser = new User().getClass();
        classCar = new Car().getClass();
        startPrint();
        Scanner scanner = new Scanner(System.in);
        String inputClassName = CheckInputClass(scanner);
        Class className = converter(inputClassName);
        classPrint(className);
        Object objectClass = createObject(className, scanner);
        objectClass = refactorObject(objectClass, scanner);
    }
    public static String CheckInputClass(Scanner scanner){
        int flag = 0;
        String inputClassName = null;
        while (flag != 1){
            inputClassName = scanner.nextLine();
            if (inputClassName.equals("User") || inputClassName.equals("Car")){
                flag = 1;
            } else {
                System.out.println("Error class with that name does not exist");
                startPrint();
            }
        }
        return inputClassName;
    }
    public static Class converter(String inputClassName){
        try {
        Class<?> className = null;
        String NewInputClassName = "ex00.Reflectionfolder.src.main.java.classes." + inputClassName;
        className = Class.forName(NewInputClassName);
        return className;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void startPrint(){
        System.out.println("Classes:");
        System.out.println(classUser.getSimpleName());
        System.out.println(classCar.getSimpleName());
        System.out.println("---------------");
        System.out.println("Enter class name");
    }
    public static void classPrint(Class className){
            System.out.println("fields");
                Field[] fields = className.getDeclaredFields();
                for (Field field : fields) {
                    String fieldName = field.getName();
                    String fieldType = field.getType().getSimpleName();
                    System.out.println("    " + fieldType + " " + fieldName);
                }
                System.out.println("methods");
                Method[] methods = className.getDeclaredMethods();
                for (Method method : methods) {
                    String methodName = method.getName();
                    String methodReturnType = method.getReturnType().getName();
                    System.out.println("    " + methodReturnType + " " + methodName);
                }
                System.out.println("---------------");
            }
    public static Object createObject(Class className, Scanner scanner) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("Let s create an object.");
        Object objectClass = null;
        if (className.getSimpleName().equals("User")){
            objectClass = createObjectUser(scanner);
        } else {
            objectClass = createObjectCar(scanner);
        }
        return objectClass;
    }

    public static Object createObjectUser(Scanner scanner) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Field[] fields = classUser.getDeclaredFields();
        System.out.println(fields[0].getName());
        String firstName = scanner.nextLine();
        System.out.println(fields[1].getName());
        String lastName = scanner.nextLine();
        System.out.println(fields[2].getName());
        Integer hide = Integer.valueOf(scanner.next());
        Constructor constructor = classUser.getConstructor(String.class, String.class, Integer.class);
        Object objectClassUser = constructor.newInstance(firstName, lastName, hide);
        System.out.printf("Object created: %s\n", objectClassUser);
        System.out.println("----------------------------");
        return objectClassUser;
    }

    public static Object createObjectCar(Scanner scanner) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Field[] fields = classCar.getDeclaredFields();
        System.out.println(fields[0].getName());
        String brandCar = scanner.nextLine();
        System.out.println(fields[1].getName());
        String modelCar = scanner.nextLine();
        System.out.println(fields[2].getName());
        Integer mileage = Integer.valueOf(scanner.next());
        System.out.println(fields[3].getName());
        Integer age = Integer.valueOf(scanner.next());
        Constructor constructor = classCar.getConstructor(String.class, String.class, Integer.class, Integer.class);
        Object objectClassCar = constructor.newInstance(brandCar, modelCar, mileage, age);
        System.out.printf("Object created: %s\n", objectClassCar);
        System.out.println("----------------------------");
        return objectClassCar;
    }

    public static Object refactorObject(Object objectClass, Scanner scanner) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Enter name of the method for call");
        scanner.nextLine();
        String methodIn = scanner.nextLine();
        Method[] methods = objectClass.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (methodIn.equals(method.getName() + "(" + method.getReturnType().getName() + ")")) {
                Class<?>[] parametersTypes = method.getParameterTypes();
                if (parametersTypes.length > 0) {
                    Object[] params = new Object[parametersTypes.length];
                    for (int i = 0; i < parametersTypes.length; i++) {
                        System.out.printf("Enter %s value:\n", parametersTypes[i].getSimpleName());
                        if (!scanner.hasNext()) {
                            System.err.println("Illegal argument!");
                            System.exit(-1);
                        }
                      //  System.out.printf(parametersTypes[i].getSimpleName());
                        if (parametersTypes[i].getSimpleName().equals("int")) {
                            params[i] = scanner.nextInt();
                        } else if (parametersTypes[i].getSimpleName().equals("String")) {
                            params[i] = scanner.next();
                        } else if (parametersTypes[i].getSimpleName().equals("Long")) {
                            params[i] = scanner.nextLong();
                        } else {
                            System.err.println("No such parameter");
                            System.exit(-1);
                        }
                    }
                    System.out.println("Method returned:");
                    System.out.println(method.invoke(objectClass, params));
                }
            }
        }
        return objectClass;
    }
}
