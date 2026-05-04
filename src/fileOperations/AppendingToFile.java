/**
 * The AppendingToFile class demonstrates how to append text to an existing file
 * using the java.io.FileWriter class in Java. Unlike overwriting, appending ensures
 * that new content is added at the end of the file without deleting existing data.
 *
 * This example illustrates basic file writing operations with append mode enabled.
 */
package fileOperations;

import java.io.FileWriter;
import java.io.IOException;

/**
 * A simple program to append text into "Simple.txt".
 */
public class AppendingToFile {

    /**
     * The main method is the entry point of the program.
     * It appends a line of text to "Simple.txt" and prints a confirmation message.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) throws IOException {
    	
    
    	
        try {
            // Create a FileWriter object with append mode enabled (true).
            // If the file does not exist, it will be created.
            // If it exists, new content will be added at the end.
            FileWriter writer = new FileWriter("C:\\Users\\Admin\\git\\Crevavi_Training\\files\\Simple.txt", true);

            // Append a line of text to the file
            writer.write("This line of text is appended to the existing file \n");

            // Close the FileWriter to save changes and release resources
            writer.close();

            // Print confirmation message to the console
            System.out.println("Append successful!!");

        } catch (IOException e) {
            // Handle any input/output exceptions (e.g., permission issues, disk errors)
            System.out.println("IOException occurred!");
            e.printStackTrace(); // Print detailed error information
        }
    }
    	
    
    }

