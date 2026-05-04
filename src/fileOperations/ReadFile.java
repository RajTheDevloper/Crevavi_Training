/**
 * The ReadFile class demonstrates how to read text from a file
 * using two different approaches in Java:
 * 1. Scanner class (line-by-line reading).
 * 2. BufferedReader class (efficient buffered reading).
 *
 * This example shows basic file reading operations and exception handling.
 */
package fileOperations;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;

/**
 * A simple program to read text from "Simple.txt" using Scanner
 * and from "Simplee.txt" using BufferedReader.
 */
public class ReadFile {

    /**
     * The main method is the entry point of the program.
     * It first reads a file using Scanner, then calls another method
     * to read a file using BufferedReader.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        try {
            // Create a File object representing "Simple.txt"
            File file = new File("C:\\Users\\Admin\\git\\Crevavi_Training\\files\\Simple.txt");

            // Create a Scanner to read the file
            Scanner reader = new Scanner(file);

            // Loop through each line until no more lines exist
            while (reader.hasNextLine()) { // checks whether the file has next line
                String data = reader.nextLine(); // reads line by line
                System.out.println(data);        // prints each line to console
                // Optional: pause between lines (commented out)
                // try { Thread.sleep(1000); } catch (Exception e) {}
            }

            // Close the Scanner to release resources
            reader.close();

        } catch (FileNotFoundException e) {
            // Handle case where "Simple.txt" is not found
            System.out.println("FileNotFoundException occurred!!");
            e.printStackTrace(); // Print detailed error information
        }

        // Call method to read file using BufferedReader
        readUsingBuffReader();
    }

    /**
     * Reads text from "Simplee.txt" using BufferedReader.
     * BufferedReader is more efficient for large files.
     */
    public static void readUsingBuffReader() {
        try {
            // Create a BufferedReader to read from "Simplee.txt"
            BufferedReader br = new BufferedReader(new FileReader("Simplee.txt"));
            String line;

            System.out.println("\n\nThis read by BufferedReader:");

            // Read each line until end of file (null)
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            // Close the BufferedReader to release resources
            br.close();

        } catch (Exception e) {
            // Handle any exceptions (e.g., file not found, IO errors)
            System.out.println("Got an exception!");
            e.printStackTrace(); // Print detailed error information
        } finally {
            // This block always executes, even if an exception occurs
            System.out.println("BufferedReader finished here.");
        }
    }
}
