/**
 * The CreateFile class demonstrates how to create a new file in Java
 * using the java.io.File class. It checks if the file already exists,
 * and either creates a new one or reports that it already exists.
 *
 * This example shows basic file handling with exception management.
 */
package fileOperations;

import java.io.File;

/**
 * A simple program to create a file named "Simple.txt" in the project directory.
 */
public class CreateFile {

    /**
     * The main method is the entry point of the program.
     * It attempts to create a new file and prints the result.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        // Create a File object representing "Simple.txt"
        File file = new File("C:\\Users\\Admin\\git\\Crevavi_Training\\files\\Simple.txt");

        try {
            // Attempt to create the file
            if (file.createNewFile()) {
                // If the file does not exist, it will be created and display it's name
                System.out.println("File created! : " + file.getName());
            } else {
                // If the file already exists, notify the user
                System.out.println("File already exists!");
            }
        } catch (Exception e) {
            // Handle any exceptions (e.g., IO errors, permission issues)
            System.out.println("Got an exception");
            e.printStackTrace(); // Print detailed error information
        }
    }
}
