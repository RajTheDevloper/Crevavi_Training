/**
 * Package oops demonstrates Object-Oriented Programming (OOP) concepts in Java.
 * This example focuses on constructor overloading, where multiple constructors
 * are defined with different parameter lists.
 */
package oops;

/**
 * The Student class demonstrates constructor overloading.
 * It provides multiple constructors to initialize objects
 * in different ways.
 */
class Person {
    private String name;
    private int age;

    /**
     * Default constructor initializes with default values.
     */
    Person() {
        this.name = "Unknown";
        this.age = 0;
    }

    /**
     * Constructor that initializes only the name.
     *
     * @param name student's name
     */
    Person(String name) {
        this.name = name;
        this.age = 0;
    }

    /**
     * Constructor that initializes both name and age.
     *
     * @param name student's name
     * @param age student's age
     */
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Displays student details.
     */
    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

/**
 * The ConstructorOverloadingDemo class contains the main method.
 * It demonstrates constructor overloading by creating Student objects
 * using different constructors.
 */
public class ConstructorOverLoadingDemo {
    public static void main(String[] args) {
        Person s1 = new Person();
        Person s2 = new Person("Alice");
        Person s3 = new Person("Bob", 20);

        s1.display();
        s2.display();
        s3.display();
    }
}
