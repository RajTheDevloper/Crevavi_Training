package threadPractice;

/**
 * The MyThread1 class represents a thread that prints a message
 * when it is executed. It extends the Thread class.
 */
class MyThread1 extends Thread {
    
    /**
     * Executes when the thread is run.
     * Prints a message indicating that Thread ONE is running.
     */
    @Override
    public void run() {
        System.out.println("Thread ONE is running");
    }
}

/**
 * The MyThread2 class represents a thread that prints a message
 * when it is executed. It extends the Thread class.
 */
class MyThread2 extends Thread {
    
    /**
     * Executes when the thread is run.
     * Prints a message indicating that Thread TWO is running.
     */
    @Override
    public void run() {
        System.out.println("Thread TWO is running");
    }
}

/**
 * The ThreadPractice class demonstrates thread creation by extending
 * the Thread class. It creates two threads and calls their run() methods.
 * 
 * <p><b>Note:</b> In this example, run() is called directly instead of start().
 * This means the code executes sequentially in the main thread rather than
 * concurrently in separate threads.</p>
 */
public class ThreadPractice {
    
    /**
     * The entry point of the program. Creates two threads and calls their run() methods.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        
        // Create thread objects
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();
        
        // Directly call run() instead of start()
        t1.run();
        t2.run();
    }
}
