/**
 * The WriteToFile class demonstrates how to write text into a file
 * using the java.io.FileWriter class. It shows how to create or overwrite
 * a file, write multiple lines of text, and handle exceptions properly.
 *
 * This example illustrates basic file writing operations in Java.
 */
package fileOperations;

import java.io.FileWriter;
import java.io.IOException;

/**
 * A simple program to write text into a file named "Simple.txt".
 */
public class WriteToFile {

    /**
     * The main method is the entry point of the program.
     * It writes text into "Simple.txt" and prints a confirmation message.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        try {
            // Create a FileWriter object to write to "Simple.txt"
            // If the file does not exist, it will be created.
            // If it exists, its contents will be overwritten.
            FileWriter writer = new FileWriter("C:\\Users\\Admin\\git\\Crevavi_Training\\files\\Simple.txt");

            // Write the first line of text into the file
            writer.write("This is a simple text added to the Simple.txt file!\n");

            // Write another line of text into the file
            writer.write("Here whatever we want we can write, no problem.\n");

            // Close the FileWriter to save changes and release resources
            writer.close();

            // Print confirmation message to the console
            System.out.println("Writing is over!");

        } catch (IOException e) {
            // Handle any input/output exceptions (e.g., permission issues, disk errors)
            System.out.println("Got an exception!!");
            e.printStackTrace(); // Print detailed error information
        }
    }
}
