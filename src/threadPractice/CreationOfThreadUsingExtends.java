package threadPractice;

/**
 * The Cooking class represents a thread that performs a cooking-related task.
 * It extends the Thread class, allowing instances to be directly started as threads.
 */
class Cooking extends Thread {
    
    /** The description or name of the cooking task assigned to the thread. */
    private String task;
    
    /**
     * Constructs a Cooking thread with a specific task description.
     *
     * @param task the name or description of the cooking task
     */
    Cooking(String task) {
        this.task = task;
    }
    
    /**
     * Executes the cooking task when the thread is started.
     * Prints the task name along with the name of the thread executing it.
     */
    @Override
    public void run() {
        System.out.println(task + " thread is running --> " + Thread.currentThread().getName());
    }
}

/**
 * The CreationOfThreadUsingExtends class demonstrates how to create and run threads
 * by extending the Thread class. It launches multiple Cooking threads with the same task.
 */
public class CreationOfThreadUsingExtends {
    
    /**
     * The entry point of the program. Prints a message from the main thread,
     * creates multiple Cooking threads, and starts them concurrently.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        
        // Print message from the main thread
        System.out.println("this is main class running --> " + Thread.currentThread().getName());
        
        // Create threads with the same cooking task
        Thread t1 = new Cooking("Boiling");
        Thread t2 = new Cooking("Boiling");
        Thread t3 = new Cooking("Boiling");
        Thread t4 = new Cooking("Boiling");
        
        // Start all threads concurrently
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
