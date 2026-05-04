/*
 * ERRORs 
 * 1) Compile time error: Spelling mistake (syntactical error)
 * 2) Run time error: execution of the program will stop for example file not found exception
 * 3) logical error: (bugs) error in the logic that we write 
 * 
 * In order to over come run time error we need handle several exceptions
 * 
 * arithmeticException Extends RunTimeExeption Extends Exception Extends Throwable (Hierarchy of the exception) 
 */
package testPreparation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionHandling {
	public static void main(String[] args) {
//		singleException(); // is for handling single exception
//		multipleException(); // is for handling multiple exception
//		throwUsage(); //is for throwing customized exceptions
//		userDefinedException(); // calling for user defined exceptions

		try { // always use try catch block in main method rather throws keyword
			ThrowsDemo();
		} catch (Exception e) {
			System.out.println("this is the demonstration of the throws keyword! ");
			e.printStackTrace();
		}

		try { // user input accepting using BufferedReader and InputStreamReader class
			userInput();
		} catch (IOException e) {
			System.out.println("handle the IOexception " + e.getMessage());
			e.printStackTrace();
		}
		
		try {
			finallyDemo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


//	This is the demonstration of the arithmetic exception using single try catch block
	public static void singleException() {
		int num1 = 10;
		int num2 = 0;

		try {

			int rel = num1 / num2;
			System.out.println(rel);

		} catch (Exception e) {
			System.out.println("you got an excception!! " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("END OF THE PROGRAM");
	}

//	This is the demonstration of the multiple exception using single try and multiple catch blocks
	public static void multipleException() {

		int numbers[] = new int[5]; // array creation with static size
		String name = null;
		try {

			File file = new File("Simple.txt");
			FileReader fr = new FileReader(file); // Trying to access the file that doesn't exist

			System.out.println(numbers[4]); // try to get the value from the array index which is not present

			System.out.println(name.length()); // getting the length from the null variable

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("watch out the index!" + e.getMessage());
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Assign the value first " + e.getMessage());
			e.printStackTrace();
			// This will handle all the other exceptions which are not specified above
		} catch (Exception e) {
			System.out.println("new exception occured!! check out " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("END OF THE PROGRAM");
	}

//This is the demonstration of the Throw keyword: used to throw the user defined exception so that catch block can catch it
	public static void throwUsage() {
		int num1 = 10;
		int num2 = 15;

		try {

			int rel = num1 / num2;
			System.out.println(rel);
			if (num2 > num1)
				throw new ArithmeticException("let's make the num2 less than num1 ");

		} catch (Exception e) {
			System.out.println("you got an excception!! " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("END OF THE PROGRAM");
	}

//	This is the demonstration of the user defined exception: it can be achieved by making the custom class to extend Exception class
	public static void userDefinedException() {
		int num1 = 10;
		int num2 = 20;

		try {

			int rel = num1 / num2;
			System.out.println(rel);
			if (num2 > num1)
				throw new RajuException("This is Raju's exception ");

		} catch (RajuException e) {
			System.out.println("you got an excception!! " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("END OF THE PROGRAM");
	}

// thorws demonstration: always used with checked exception and the throws statement is written in the method declaration avoid using in the main method as it is directly run by the JVM.
	public static void ThrowsDemo() throws Exception {

		Class.forName("demo");
	}

//	BufferedReader for taking user input IOOperation
	public static void userInput() throws IOException {
		System.out.println("Enter your name : ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine(); // checked exception it might throw an error handle it

		System.out.println(name);
	}

	public static void finallyDemo() throws IOException {
		// while using finally block we can skip the catch block if there is no need of
		// it
		// finally block is basically used for closing the resources that we have used
		BufferedReader br = null;

		try {
			System.out.print("give me a message to pass it to someone : ");
			br = new BufferedReader(new InputStreamReader(System.in));
			String message = br.readLine();
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("exception occured! " + e.getMessage());
		} finally {
			System.out.println("this is the finally block statement ");
			br.close();
		}

	}

//	this is the method that shows how the try block can be used with resources and the main advantage of using it is it will automatically close the used resources.
	void tryWithResourcedemo() {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			
			
			String number = br.readLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("resouces are closed automatically by the try block");
		}
	}
}

//user defined exception class
class RajuException extends Exception {

	public RajuException(String message) {
		super(message);
	}
}
