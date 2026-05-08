package oops;

/**
 * The Vehicle class is an abstract class that represents
 * the concept of a generic vehicle. It enforces abstraction
 * by requiring subclasses to implement the {@code start()} method.
 */
abstract class Vehicle {
    /**
     * Abstract method to start the vehicle.
     * Subclasses must provide their own implementation.
     */
    abstract void start();
}

/**
 * The Bike class is a concrete subclass of Vehicle.
 * It provides its own implementation of the {@code start()} method.
 */
class Bike extends Vehicle {
    /**
     * Starts the bike with a kick.
     * Overrides the abstract method from Vehicle.
     */
    @Override
    void start() {
        System.out.println("Bike starts with a kick");
    }
}

/**
 * The Abstraction class contains the main method
 * and demonstrates how abstraction works in Java.
 * It shows how an abstract class can be used through
 * its concrete subclass.
 */
public class Abstraction {
    /**
     * The main method is the entry point of the program.
     * It creates a Bike object but references it as a Vehicle,
     * demonstrating abstraction and polymorphism.
     *
     * @param args command-line arguments (not used here)
     */
    public static void main(String[] args) {
        Vehicle v = new Bike(); // Vehicle reference, Bike object
        v.start();              // Calls overridden method in Bike
    }
}
