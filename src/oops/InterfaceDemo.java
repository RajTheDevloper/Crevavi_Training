/**
 * Package oops demonstrates Object-Oriented Programming (OOP) concepts in Java.
 * This example focuses on the use of interfaces, showing how a class can
 * implement an interface and provide its own behavior for the defined methods.
 */
package oops;

/**
 * The Payment interface defines a contract for payment operations.
 * Any class that implements this interface must provide an implementation
 * for the {@code pay()} method.
 */
interface Payment {
    /**
     * Performs a payment operation.
     * Classes implementing this interface must define the behavior.
     */
    void pay();
}

/**
 * The CreditCard class implements the Payment interface.
 * It provides a specific implementation of the {@code pay()} method,
 * simulating a payment done using a credit card.
 */
class CreditCard implements Payment {
    /**
     * Executes a payment using a credit card.
     * Overrides the {@code pay()} method from the Payment interface.
     */
    @Override
    public void pay() {
        System.out.println("Payment done using Credit Card");
    }
}

/**
 * The InterfaceDemo class contains the main method.
 * It demonstrates how interfaces work by creating a Payment reference
 * and assigning it to a CreditCard object, then invoking the {@code pay()} method.
 */
public class InterfaceDemo {
    /**
     * The main method is the entry point of the program.
     * It creates a CreditCard object and calls the {@code pay()} method
     * through the Payment interface reference.
     *
     * @param args command-line arguments (not used here)
     */
    public static void main(String[] args) {
        Payment p = new CreditCard(); // Interface reference, CreditCard object
        p.pay();                      // Calls implementation in CreditCard
    }
}
