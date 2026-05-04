/*
 *  Definition: Threads are the smallest executing part of the process in a program.
 *
 * Threads can be created in two ways 
	1) By extending Thread class.
	2) By implementing runnable interface.
 * Thread should have run() method in it always
 *  
 * Threads work with the **schedulers** which will decides which thread to be executed first which resides in OS.
 *  
 *  setPriority(Thread.MAX_PRIORITY); this method is used for setting up the priorities for the threads
 *  Thread.sleep(10); here we can make a thread to wait for the specific time that we mention in mili_seconds, and this method may through exception(InterruptedException) so we have to handle exception here.
 *  
 *  Thread safe : this is phenomenon where two threads get collisions while executing. The solution is "synchronized" keyword in the method declaration.
 *  
 *  Thread life cycle
 *  - new ->[start()] runnable -> [run()] running -> [sleep(), wait()] waiting -> [stop()] dead
 */

package testPreparation;


//class written using extending Thread class 
class Greet1 extends Thread {

	public void run() {
		for (int i = 0; i < 5; i++) {

			System.out.println("Hey this is Thread1");

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.out.println(e.getLocalizedMessage());
				e.fillInStackTrace();
			}

		}
	}
}

//class written using extending Thread class 
class Greet2 extends Thread {

	public void run() {
		for (int i = 0; i < 5; i++) {

			System.out.println("Hey this is Thread2");

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.out.println(e.getLocalizedMessage());
				e.fillInStackTrace();
			}

		}
	}
}

// here is the code for the Thread creation using runnable interface:

//Class written implementing Runnable interface 
class Race1 implements Runnable {

	public void run() {
		int num = 0;

		while (num < 10) {

			System.out.println("I came first!");
			num += 1;

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

//Class written implementing Runnable interface 
class Race2 implements Runnable {

	public void run() {
		int num = 0;

		while (num < 10) {
			System.out.println("I came second!");
			num += 1;

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


// Thread safe concept demonstration here
class Counter{
	
	int count;
	
	public synchronized void increment() {
		count++;
	}
}


// Main class with main method where the program execution starts
public class ThreadPractice {
	public static void main(String[] args) throws InterruptedException {

		Thread greet1 = new Greet1();
		Thread greet2 = new Greet2();

//		greet1.start();
//		greet2.start();

//		object of runnable interface classes are here

		Runnable race1 = new Race1();
		Runnable race2 = new Race2();

//		these are thread objects for Race1 and Race2 classes
		Thread t1 = new Thread(race1);
		Thread t2 = new Thread(race2);
		

//		t1.start();
//		t2.start();
		
//		Here the concept of anonymous class is used
		
		//creating anonymous class
		Runnable race3 = new Runnable() {
			public void run() {
				System.out.println("this is anonymous class thread!");
			}
		};
		
		
//		Lambda Expression example
		// up_to the method name except () we can remove code and put an arrow ->
//		Runnable race5 = () -> { business code for the method}; this is the lambda expression syntax
		Runnable race4 = () -> {
				System.out.println("this is Lambda expression thread!");
		};
		
//		these are thread objects for anonymous & lambda expression
		Thread t3 = new Thread(race3);
		Thread t4 = new Thread(race4);
//		t3.start();
//		t4.start();
		
		
//--------------------------------------------------------------------------------------------------------------	
		
//		thread safe concepts  
		
		Counter c = new Counter();
		
		
		Runnable i = () -> {
			for(int j = 1; j < 2000; j++) {				
				
				c.increment();
			}
		};
		
		Runnable i1 = () -> {
			for(int j = 1; j < 2000; j++) {				
				c.increment();
			
			}
		};
		
		Thread t = new Thread(i);
		Thread tt = new Thread(i1);
		
		t.start();
		tt.start();
		
		t.join(); //this will make the main thread to wait for the other threads to complete it's job
		tt.join();
		
		System.out.println(c.count);	
		
	}
}
