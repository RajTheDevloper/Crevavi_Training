package collecitonAPI;

import java.util.HashSet;

/**
 * The MyHashSet class demonstrates the usage of Java's HashSet collection.
 * It shows how to:
 * <ul>
 *   <li>Create a HashSet</li>
 *   <li>Add elements (duplicates are ignored)</li>
 *   <li>Check for membership using contains()</li>
 *   <li>Clear the set</li>
 *   <li>Iterate through elements with conditional checks</li>
 * </ul>
 */
public class MyHashSet {
    
    /**
     * The entry point of the program. Demonstrates adding elements to a HashSet,
     * checking membership, clearing the set, and calling a helper method to
     * perform number lookups.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        
        // No duplicates are allowed & elements are not sorted
        HashSet<String> cars = new HashSet<>();
        
        // Add elements to the set
        cars.add("MBW");
        cars.add("MBW"); // Duplicate, will be ignored
        cars.add("MBW1");
        cars.add("MBW2");
        
        // Print the set (unordered)
        System.out.println(cars);
        
        // Check if a specific element exists
        System.out.println(cars.contains("Supraa"));
        
        // Clear all elements from the set
        cars.clear();
        
        // Call helper method to demonstrate number lookups
        numers();
    }
    
    /**
     * Demonstrates using a HashSet to store numbers and check for membership.
     * Iterates through numbers 0–9 and prints whether each number is present in the set.
     * Uses formatted output to distinguish matches and non-matches.
     */
    public static void numers() {
        var num = new HashSet<>();
        num.add(4);
        num.add(6);
        num.add(9);
        
        for (int i = 0; i < 10; i++) {
            if (num.contains(i)) {
                System.out.printf("%n %d We got the number that you was looking for😁😁😁", i);
            } else {
                System.err.printf("%n Sorry the number %d was not in the set😢😢😢", i);
            }
        }
    }
}
