import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
/**
 * This class represents a queue of random directions for cars to follow.
 * 
 *
 * @author Maryanne Amanze
 * 
 */
public class CarQueue {
	
	private Queue<Integer> directionQueue;
	private Random random = new Random();
	
	
	 /**
     * Constructs and initializes the carQueue with random directions.
     */
	public CarQueue() {
		directionQueue = new LinkedList<>();
		
		for (int i = 0; i < 7; i++) 
		{
            directionQueue.add(random.nextInt(4));
        }
	}
	
	/**
     * Adds a random direction to the end of the queue.
     */
	public void addToQueue() 
	{
		class AddRand implements Runnable 
		{

			@Override
			public void run() {
				while (true) {
					directionQueue.add(random.nextInt(4));
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}
			
		}
		
		new Thread(new AddRand()).start();
	}
	
	/**
     * Retrieves and removes the first direction from the queue.
     *
     * @return The first direction in the queue, or -1 if the queue is empty.
     */
	public int deleteQueue() {
		return directionQueue.remove();
	}
}