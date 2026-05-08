/**
 * Package oops demonstrates Object-Oriented Programming (OOP) concepts in Java.
 * This example focuses on multiple inheritance using interfaces,
 * since Java does not support multiple inheritance with classes.
 */
package oops;

/**
 * The InterfaceA defines a contract with method {@code methodA()}.
 */
interface InterfaceA {
    /**
     * Method to be implemented by classes that inherit InterfaceA.
     */
    void methodA();
}

/**
 * The InterfaceB defines a contract with method {@code methodB()}.
 */
interface InterfaceB {
    /**
     * Method to be implemented by classes that inherit InterfaceB.
     */
    void methodB();
}

/**
 * The MultiClass implements both InterfaceA and InterfaceB,
 * demonstrating multiple inheritance in Java through interfaces.
 */
class MultiClass implements InterfaceA, InterfaceB {
    /**
     * Implementation of {@code methodA()} from InterfaceA.
     */
    @Override
    public void methodA() {
        System.out.println("Method A implemented");
    }

    /**
     * Implementation of {@code methodB()} from InterfaceB.
     */
    @Override
    public void methodB() {
        System.out.println("Method B implemented");
    }
}

/**
 * The MultipleInheritanceDemo class contains the main method.
 * It demonstrates multiple inheritance by creating an object
 * of MultiClass and calling methods from both interfaces.
 */
public class MultipleInheritanceDemo {
    public static void main(String[] args) {
        MultiClass obj = new MultiClass();
        obj.methodA();
        obj.methodB();
    }
}
