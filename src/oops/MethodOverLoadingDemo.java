/**
 * Package oops demonstrates Object-Oriented Programming (OOP) concepts in Java.
 * This example focuses on method overloading, where multiple methods
 * share the same name but differ in parameter lists.
 */
package oops;

/**
 * The Calculator class demonstrates method overloading.
 * It provides multiple versions of the {@code add()} method
 * with different parameter types and counts.
 */
class Calculator {
    /**
     * Adds two integers.
     *
     * @param a first integer
     * @param b second integer
     * @return sum of a and b
     */
    int add(int a, int b) {
        return a + b;
    }

    /**
     * Adds three integers.
     *
     * @param a first integer
     * @param b second integer
     * @param c third integer
     * @return sum of a, b, and c
     */
    int add(int a, int b, int c) {
        return a + b + c;
    }

    /**
     * Adds two double values.
     *
     * @param a first double
     * @param b second double
     * @return sum of a and b
     */
    double add(double a, double b) {
        return a + b;
    }
}

/**
 * The MethodOverloadingDemo class contains the main method.
 * It demonstrates method overloading by calling different versions
 * of the {@code add()} method.
 */
public class MethodOverLoadingDemo {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(2, 3));       // Calls int add(int, int)
        System.out.println(calc.add(2, 3, 4));    // Calls int add(int, int, int)
        System.out.println(calc.add(2.5, 3.5));   // Calls double add(double, double)
    }
}

