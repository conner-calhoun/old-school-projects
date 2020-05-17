public class ThreeTwoA<E> {
	
	private MyLinkedListNode<E> start;
	private int size;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeTwoA a = new ThreeTwoA();
		a.add(4);
		a.add(5);
		a.add(6);
		a.add(7);
		
		System.out.print("The List: "+a.printList());
		a.swap(0, a);
		System.out.println("\nThe New List: "+a.printList());
	}
	
	public ThreeTwoA() {
		super();
		this.start = null;
		this.size = 0;
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
	
	public void insert(E val, int index)//O(N) to O(1)
	{
		if(index > size || index < 0)
			index = size;
		MyLinkedListNode<E> newItem = new MyLinkedListNode<E>(val);
		if(index == 0)
		{
			newItem.next = start;
			start = newItem;
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
		}
		size++;
	}
	
	public void add(E val)//O(N)
	{
		insert(val, size);
	}
	
	public int find(E val)//O(N)
	{
		MyLinkedListNode<E> current = start;
		int index = -1;
		for(int i = 0; i < size; i++)
		{
			if(current.value == val)
			{
				index = i;
				break;
			}
			current = current.next;
		}
		return index;
	}
	
	public void remove(E val)//O(N+N) = O(N)
	{
		int index = find(val);//O(N)
		if(index >= 0)
			delete(index);//O(N)
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
	
	public E get(int index)//O(N)
	{
		if(index >= 0 && index < size)
		{
			MyLinkedListNode<E> current = start;
			for(int i = 0; i < index; i++)
				current = current.next;
			return current.value;
		}
		else
			return null;
	}
	
	public MyLinkedListNode<E> getNode(int index)//O(N)
	{
		if(index >= 0 && index < size)
		{
			MyLinkedListNode<E> current = start;
			for(int i = 0; i < index; i++)
				current = current.next;
			return current;
		}
		else
			return null;
	}
	
	public ThreeTwoA swap(int index, ThreeTwoA a) {
		System.out.println("\n\nNow swapping the indexes: "+index+" and "+(index+1)+"...");
		
		MyLinkedListNode<E> first = getNode(index);
		MyLinkedListNode<E> current = first.next;
		
		System.out.println("Node One: "+get(index)+"\nNode Two: "+get(index+1));
		
		first.next = current.next;
		current.next = first;
		first = current;
		
		current = current.next;
		first.next = current;
		
		MyLinkedListNode<E> loop = start;
		
		if (index == 0) {
			start = first;
		}
		else {
			for(int i = 0; i < index-1; i++) 
				loop = loop.next;
			
			System.out.println("Loop Value: "+loop.value);
			
			loop.next = first;
		}
		
		
		return a;
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
