package arrayListPractice;

import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayList {
	public static void main(String[] args) {
		//create an array list of string
		ArrayList<String> cars = new ArrayList<>(); 
		cars.add("Polo");
		cars.add("Supra");
		cars.add("Benz");
		cars.add("BMW");
		
//		System.out.println(cars);
		// loop through the Iterator 
		Iterator<String> it = cars.iterator();
		
		while(it.hasNext()) {
			
			System.out.println(it.next());
		}
	}
}
