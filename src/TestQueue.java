
public class TestQueue {

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<>();
		
		System.out.println("Adding 5, 6, and 7...");
		queue.add(5);
		queue.add(6);
		queue.add(7);
		
		System.out.println("First: "+queue.getFirst());
		System.out.println("Last: "+queue.getLast());
		System.out.println("Size: "+queue.getSize());
		
		System.out.println("Peek (same as getFirst): "+queue.peek());
		
		System.out.println("Entire List: "+queue.printQueue());
		
		System.out.println("Removing: "+queue.poll());
		System.out.println("New List: "+queue.printQueue());
		
		System.out.println("Adding 27, 22, and 29...");
		queue.add(27);
		queue.add(22);
		queue.add(29);
		
		System.out.println("New List: "+queue.printQueue());
		System.out.println("Removing: "+queue.poll());
		System.out.println("New List: "+queue.printQueue());
		System.out.println("Size: "+queue.getSize());
		System.out.println("First: "+queue.getFirst());
		System.out.println("Last: "+queue.getLast());
	}

}
