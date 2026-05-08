package oops;
/*
 * Single ton class is the one which as only one instance and don't allow to create multiple objects of that class.
 * for that we have to make the constructor as private.
 * For more look at the code and it's documentation.
 */

class Singleton {
	// private constructor
	private Singleton() {

	}

	// single object of this class and it should be static
	private static Singleton instance;

	// should have a public static method so that the objects can refer to the same
	// instance.
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
			System.out.println(instance);
		} else {
//			System.out.println("Object is already created!" + instance);
		}

		return instance;
	}

}

//main method for the singleton class.
public class SingletonMain {
	public static void main(String[] args) {
//		SingleTon obj1 = new SingleTon(); // give you an error you cannot create the object using private constructor

		Singleton obj = Singleton.getInstance(); // creating the object using static method
		Singleton obj1 = Singleton.getInstance();
		System.out.println(obj); // referring to the same object/instance
		System.out.println(obj1); // referring to the same object/instance

		/*
		 * This is how you will get the output and the main thing is that all the objects that are created are referring to the same memory location.
		 * oops.Singleton@c4437c4 
		 * oops.Singleton@c4437c4 
		 * oops.Singleton@c4437c4
		 */

	}
}
