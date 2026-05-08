package oops;

public class ClassesAndObj {
	public static void main(String[] args) {
		Student raju = new Student(13, "Raju", 23.3f);  // raju is a object of the Student class
	
		
 		//System.out.println(raju.marks + raju.name + raju.rollNumber);
		
		//Garbage collection finalize() method demonstration
		
		Student ram;
		for(int i = 0; i < 10000000; i++) {
			ram = new Student("something");
		}
	}
}

class Student {

	// these are all local variables
	int rollNumber;
	String name;
	float marks;
	
	Student(String name){
		this.name = name;// raju.name
	}

	// here the "this" keyword will replace the place with the object of the class itself: this = raju.
	Student(int rollNumber, String name, float marks) {
		// these are instance variable.
		this.rollNumber = rollNumber; // raju.rollNumber
		this.name = name; // raju.name
		this.marks = marks; // raju.marks


	}

	
	//finalize() is a method which is called before whenever an object is going to destroyed 
	@Override
	protected void finalize() throws Throwable {
		System.out.println("the object got destroyed");
	}

}