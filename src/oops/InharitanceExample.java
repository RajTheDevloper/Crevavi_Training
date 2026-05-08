/**
 * Package oops demonstrates Object-Oriented Programming (OOP) concepts in Java.
 * This example focuses on inheritance, showing how a child class can extend
 * a parent class and access its members using the {@code super} keyword.
 */
package oops;

/**
 * The Parent class represents a base class with a money field.
 * It initializes the money value in its constructor.
 */
class Parent {
    /**
     * Stores the amount of money the parent has.
     */
    double money;

    /**
     * Default constructor that initializes the parent's money to 1000.
     */
    Parent() {
        this.money = 1000;
    }
}

/**
 * The Child class extends the Parent class.
 * It has its own money field and demonstrates how to access
 * the parent's money using {@code super}.
 */
class Child extends Parent {
    /**
     * Stores the amount of money the child has.
     */
    double money;

    /**
     * Default constructor that initializes the child's money to 100.
     */
    Child() {
        this.money = 100;
    }

    /**
     * Prints a message about the child's need for money.
     * Also demonstrates accessing the parent's money using {@code super}.
     *
     * @param money the amount of money the child needs
     */
    public void getMoney(double money) {
        System.out.printf("I need %.1f if I don't have I'll ask it from my parents!! \n", money);
        System.out.println(super.money); // Access parent's money
    }
}

/**
 * The InharitanceExample class contains the main method.
 * It demonstrates how inheritance works by creating a Child object
 * and showing both the child's money and the parent's money.
 */
public class InharitanceExample {
    /**
     * The main method is the entry point of the program.
     * It creates a Child object, prints its money, and calls getMoney().
     *
     * @param args command-line arguments (not used here)
     */
    public static void main(String[] args) {
        Child raju = new Child(); // Create Child object
        System.out.println(raju.money); // Print child's money
        raju.getMoney(600f); // Demonstrate parent's money access
    }
}
