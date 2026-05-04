package collecitonAPI;

import java.util.HashMap;

/**
 * The MyHashMap class demonstrates the usage of Java's HashMap collection.
 * It shows how to:
 * <ul>
 *   <li>Create a HashMap</li>
 *   <li>Add key-value pairs using put()</li>
 *   <li>Iterate through keys and retrieve values</li>
 * </ul>
 */
public class MyHashMap {
    
    /**
     * The entry point of the program. Creates a HashMap of student IDs and names,
     * then iterates through the keys to print each key-value pair.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        // Example using var (Java 10+)
        // var cars = new HashMap<>();
        
        // Create a HashMap with student IDs as keys and names as values
        HashMap<String, String> student = new HashMap<>();
        student.put("EWIT1", "Raju");
        student.put("EWIT2", "Koushalya");
        
        // Example of iterating with a for loop (commented out)
        // for(int i = 0; i < student.size(); i++) {
        //     System.out.println(i);
        // }
        
        // Iterate through the keys and print key-value pairs
        for (String i : student.keySet()) {
            System.out.println(i + " " + student.get(i));
        }
    }
}
