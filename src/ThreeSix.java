import java.util.Random;

public class ThreeSix<E> {
	private MyLinkedListNode<E> start;
	private MyLinkedListNode<E> end;
	private int size;
	private static int N;
	private static int M;
	
	public ThreeSix() {
		super();
		this.start = null;
		this.end = null;
		this.size = 0;
	}
	
	public static void main (String[] args) {
		Random rand = new Random();
//		N = rand.nextInt(10) + 1;
//		M = rand.nextInt(5);
		N = 10;
		M = 5;
		
		System.out.println("N: "+N+"\nM: "+M+"\n"
				+ "Generating a linked list with "+N+" people in it...");
		
		ThreeSix people = new ThreeSix();
		for (int i=0; i<N; i++) {
			people.add(i);
		}
		
		System.out.println("Linked List of People: " + people.printList());
		
		people.mThrough(M, N, people);
		
		people.printList();
	}
	
	public String printList()//O(N)
	{
		String output = "";
		MyLinkedListNode<E> current = start;
		boolean first = true;
		while(current != null)
		{
			if(!first)
				output += ", ";
			output += current.value;
			current = current.next;
			first = false;
		}
		return output;
	}
	
	public void mThrough(int M, int N, ThreeSix a) {
		while (N > 1) {
			if(M == 0) { // This whole part works, where M == 0
				a.delete(0);
				N--;
				System.out.println("List Minus Elimation: "+a.printList());
			}
			else {
				while (N != 1) {
					if (M>N) {
						a.delete(M-N);
						N--;
						System.out.println("List Minus Elimation: "+a.printList());
					}
					else {
						a.delete(M);
						M+=M;
						N--;
						System.out.println("List Minus Elimation: "+a.printList());
					}
				}
			}
		}
	}
	
	public void insert(E val, int index)//O(N) to O(1)
	{
		if(index > size || index < 0)
			index = size;
		MyLinkedListNode<E> newItem = new MyLinkedListNode<E>(val);
		if(index == 0)
		{
			newItem.next = start;
			start = newItem;
			end = newItem;
		}
		else
		{
			MyLinkedListNode<E> current = start;
			for(int i = 1; i < index; i++)
			{
				current = current.next;
			}
			//current, new, current.next
			newItem.next = current.next;
			current.next = newItem;
			end = newItem;
		}
		size++;
	}
	
	public void add(E val)//O(N)
	{
		insert(val, size);
	}
	
	public void delete(int index)//O(N)
	{
		if(index == 0 && size > 0)
		{
			start = start.next;
			size--;
		}
		else if(index > 0 && index < size)
		{
			MyLinkedListNode<E> current = start;
			for(int i = 0; i < index-1; i++)
			{
				current = current.next;
			}
			//current, remove, after
			current.next = current.next.next;
			size--;
		}
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
