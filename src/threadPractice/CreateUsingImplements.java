package threadPractice;

/**
 * The Tasker class represents a unit of work that can be executed by a thread.
 * It implements the Runnable interface, allowing instances to be passed to a Thread.
 */
class Tasker implements Runnable {
    
    /** The description or name of the task assigned to the thread. */
    private String task;
    
    /**
     * Constructs a Tasker object with a specific task description.
     *
     * @param task the name or description of the task
     */
    Tasker(String task) {
        this.task = task;
    }
    
    /**
     * Executes the task when the thread is started.
     * Prints the task name along with the name of the thread executing it.
     */
    @Override
    public void run() {
        System.out.println(task + " The thread that doing it is --> " + Thread.currentThread().getName());
    }
}

/**
 * The CreateUsingImplements class demonstrates how to create and run threads
 * using the Runnable interface. It launches multiple threads with different tasks
 * and shows how to use join() for synchronization.
 */
public class CreateUsingImplements {
    
    /**
     * The entry point of the program. Creates and starts multiple threads,
     * waits for one thread to complete using join(), and then continues execution.
     *
     * @param args command-line arguments (not used in this program)
     * @throws InterruptedException if the current thread is interrupted while waiting
     */
    public static void main(String[] args) throws InterruptedException {
        
        // Create threads with different tasks
        Thread t1 = new Thread(new Tasker("runFast"));
        Thread t2 = new Thread(new Tasker("jumpFast"));
        Thread t3 = new Thread(new Tasker("sitFast"));
        Thread t4 = new Thread(new Tasker("walkFast"));
        
        // Start threads
        t3.start();
        t1.start();
        
        // Wait for t1 to complete before continuing
        t1.join();
        
        // Print message from the main thread
        System.out.println("this is main method");
        
        // Start remaining threads
        t2.start();
        t4.start();
    }
}
