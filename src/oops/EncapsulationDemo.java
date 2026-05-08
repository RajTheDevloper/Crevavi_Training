package oops;

/**
 * The Student class demonstrates encapsulation in Java.
 * It keeps the 'name' field private and provides public
 * getter and setter methods to access and modify it.
 */
class Students {
    /**
     * Stores the name of the student.
     * This field is private to enforce encapsulation.
     */
    private String name;

    /**
     * Retrieves the student's name.
     *
     * @return the current value of the student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the student's name.
     *
     * @param name the new name to assign to the student
     */
    public void setName(String name) {
        this.name = name;
    }
}

/**
 * The Main class contains the entry point of the program.
 * It demonstrates how to use the Student class by creating
 * an object, setting its name, and retrieving it.
 */
public class EncapsulationDemo {
    /**
     * The main method is the entry point of the program.
     *
     * @param args command-line arguments (not used here)
     */
    public static void main(String[] args) {
        // Create a Student object
        Students s = new Students();

        // Set the student's name using the setter
        s.setName("Alice");

        // Print the student's name using the getter
        System.out.println("Student name: " + s.getName());
    }
}
