package collecitonAPI;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The MyArrayList class demonstrates the usage of Java's ArrayList
 * and the Collections utility class. It shows how to:
 * <ul>
 *   <li>Create an ArrayList</li>
 *   <li>Add elements to it</li>
 *   <li>Sort the list using Collections.sort()</li>
 *   <li>Iterate through the list using different techniques</li>
 * </ul>
 */
public class MyArrayList {
    
    /**
     * The entry point of the program. Creates an ArrayList of car names,
     * sorts them, and prints the sorted list using a for-each loop.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        // Allow duplicates & sorted demonstration
        
        // Example using var (Java 10+)
        // var cars = new ArrayList<>();
        
        // Using ArrayList explicitly
        ArrayList<String> cars = new ArrayList<>();
        cars.add("Supraa");
        cars.add("BMW");
        cars.add("Benz");
        
        // Sorting the ArrayList alphabetically
        Collections.sort(cars);
        
        // Different ways to iterate through the ArrayList:
        
        // 1. Using Iterator (commented out)
        // Iterator<String> it = cars.iterator();
        // while(it.hasNext()) {
        //     System.out.println(it.next());
        // }
        
        // 2. Using traditional for loop (commented out)
        // for(int i = 0; i < cars.size(); i++) {
        //     System.out.println(cars.get(i));
        // }
        
        // 3. Using enhanced for-each loop (active)
        for(String car : cars) {
            System.out.println(car);
        }
    }
}
