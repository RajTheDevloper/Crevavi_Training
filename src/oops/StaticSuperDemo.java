/**
 * Package oops demonstrates Object-Oriented Programming (OOP) concepts in Java.
 * This example focuses on the usage of {@code static} and {@code super} keywords.
 */
package oops;

/**
 * The Parent class contains a static field and a method.
 */
class Boys {
    /**
     * Static variable shared across all instances.
     */
    static String familyName = "Smith";

    /**
     * Prints a message from the parent class.
     */
    void display() {
        System.out.println("Message from Parent class");
    }
}

/**
 * The Child class extends Parent.
 * It demonstrates the use of {@code super} to access parent members
 * and {@code static} to access class-level variables.
 */
class Boy extends Boys {
    /**
     * Prints a message from the child class and calls the parent method using {@code super}.
     */
    @Override
    void display() {
        System.out.println("Message from Child class");
        super.display(); // Calls Parent's display method
    }

    /**
     * Prints the family name using the static variable.
     */
    void showFamilyName() {
        System.out.println("Family Name: " + Boy.familyName);
    }
}

/**
 * The StaticSuperDemo class contains the main method.
 * It demonstrates the use of {@code static} and {@code super} keywords.
 */
public class StaticSuperDemo {
    public static void main(String[] args) {
        Boy c = new Boy();
        c.display();         // Calls overridden method and parent's method via super
        c.showFamilyName();  // Accesses static variable from Parent
    }
}
