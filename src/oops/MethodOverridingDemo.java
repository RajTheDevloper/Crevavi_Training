/**
 * Package oops demonstrates Object-Oriented Programming (OOP) concepts in Java.
 * This example focuses on method overriding, where a subclass provides
 * its own implementation of a method defined in the superclass.
 */
package oops;

/**
 * The Animal class represents a generic animal.
 * It defines a {@code sound()} method that can be overridden.
 */
class Animal {
    /**
     * Prints a generic animal sound.
     */
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

/**
 * The Dog class extends Animal.
 * It overrides the {@code sound()} method to provide specific behavior.
 */
class Dog extends Animal {
    /**
     * Prints the sound of a dog.
     * Overrides the {@code sound()} method from Animal.
     */
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

/**
 * The MethodOverridingDemo class contains the main method.
 * It demonstrates method overriding by creating an Animal reference
 * that points to a Dog object and invoking the {@code sound()} method.
 */
public class MethodOverridingDemo {
    public static void main(String[] args) {
        Animal a = new Dog(); // Animal reference, Dog object
        a.sound();            // Calls Dog's overridden sound()
    }
}
