// My Implementation of a queue
public class MyQueue<E> {
	private MyLinkedListNode<E> first;
	private MyLinkedListNode<E> last;
	private int size;
	
	public MyQueue() {
		first = null;
		last = null; 
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public E getFirst() {
		if (first != null) {
			E firstValue = first.value;
			return first.value;
		}
		return null;
	}
	
	public E getLast() {
		if (first != null) {
			E lastValue = last.value;
			return last.value;
		}
		return null;
	}
	
	public void add(E val) {
		MyLinkedListNode<E> newItem = new MyLinkedListNode<E>(val);
		if (first == null) {
			first = newItem;
			last = newItem;
			size ++;
		}
		else {
			newItem.next = last;
			last = newItem;
			size++;
		}
	}
	
	public E peek() {
		return getFirst();
	}
	
	public String printQueue() {
		if (first != null) {
			String output = "";
			MyLinkedListNode<E> current = last;
			boolean first = true;
			while(current != null)
			{
				if(!first)
					output += " --> ";
				output += current.value;
				current = current.next;
				first = false;
			}
			return output;
		}
		return "There is nothing in the queue.";
	}
	
	public void push(E val) {
		add(val);
	}
	
	public E poll() {
		if (first != null) {
			MyLinkedListNode<E> current = last;
			MyLinkedListNode<E> temp = first;
			for (int i = 0; i < size-2; i++) {
				current = current.next;
				//System.out.println("Current Value: "+ current.value);
			}
			current.next = null;
			first = current;
			
			size--;
			
			return temp.value;
		}
		return null;
	}
	
	public class MyLinkedListNode<E>{
		public MyLinkedListNode next;
		public E value;
		public MyLinkedListNode(E v)
		{
			value = v;
			next = null;
		}
	}
}
