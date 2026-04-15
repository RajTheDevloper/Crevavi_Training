/**
 * The ReadCSVFile class demonstrates how to read data from a CSV file
 * using BufferedReader in Java. It reads the file line by line, splits
 * each line into values, and prints them to the console.
 *
 * This example illustrates basic CSV file handling and exception management.
 */
package fileOperations;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * A simple program to read text from "Simple.csv" and print its contents.
 */
public class ReadCSVFile {

    /**
     * The main method is the entry point of the program.
     * It reads "Simple.csv" line by line and prints each value.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        // Use try-with-resources to ensure BufferedReader is closed automatically
        try (BufferedReader br = new BufferedReader(new FileReader("Simple.csv"))) {
            String line;
            String splitBy = "\n"; // delimiter used for splitting (currently newline)

            // Read each line until end of file
            while ((line = br.readLine()) != null) {
                // Split the line into values based on the delimiter and store it in an array
                String[] values = line.split(splitBy);

                // Print each value from the line
                for (String value : values) {
                    System.out.println(value);
                }
            }

        } catch (Exception e) {
            // Handle exceptions (e.g., file not found, IO errors)
            e.printStackTrace(); // Print detailed error information
            System.out.println("Exception occurred!! " + e.getMessage());
        }
    }
}
