/**
 * Package oops demonstrates Object-Oriented Programming (OOP) concepts in Java.
 * This example focuses on polymorphism, showing how a superclass reference
 * can point to different subclass objects and invoke overridden methods.
 */
package oops;

/**
 * The Shape class represents a generic shape.
 * It provides a default implementation of the {@code draw()} method.
 */
class Shape {
    /**
     * Draws a generic shape.
     * This method can be overridden by subclasses to provide specific behavior.
     */
    void draw() {
        System.out.println("Drawing a shape");
    }
}

/**
 * The Circle class extends Shape.
 * It overrides the {@code draw()} method to provide behavior specific to circles.
 */
class Circle extends Shape {
    /**
     * Draws a circle.
     * Overrides the {@code draw()} method from Shape.
     */
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

/**
 * The Square class extends Shape.
 * It overrides the {@code draw()} method to provide behavior specific to squares.
 */
class Square extends Shape {
    /**
     * Draws a square.
     * Overrides the {@code draw()} method from Shape.
     */
    @Override
    void draw() {
        System.out.println("Drawing a square");
    }
}

/**
 * The PolyMorphism class contains the main method.
 * It demonstrates polymorphism by creating Shape references
 * that point to Circle and Square objects, then invoking their {@code draw()} methods.
 */
public class PolyMorphism {
    /**
     * The main method is the entry point of the program.
     * It shows how polymorphism allows different subclass implementations
     * to be called through a common superclass reference.
     *
     * @param args command-line arguments (not used here)
     */
    public static void main(String[] args) {
        Shape s1 = new Circle(); // Shape reference, Circle object
        Shape s2 = new Square(); // Shape reference, Square object

        s1.draw(); // Calls Circle's draw()
        s2.draw(); // Calls Square's draw()
    }
}
