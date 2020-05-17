public class ThreeTwoB<E> {
	private MyLinkedListNode<E> start;
	private MyLinkedListNode<E> end;
	private int size;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeTwoB b = new ThreeTwoB();
		b.add(4);
		b.add(5);
		b.add(6);
		b.add(7);
		
		System.out.print("The List: "+b.printList());
		b.swap(2);
		System.out.println("\nThe New List: "+b.printList());
	}
	
	public ThreeTwoB() {
		super();
		this.start = null;
		this.end = null;
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
	
	public String printListRev()//O(N)
	{
		String output = "";
		MyLinkedListNode<E> current = end;
		boolean first = true;
		while(current != null)
		{
			if(!first)
				output += ", ";
			output += current.value;
			current = current.prev;
			first = false;
		}
		return output;
	}
	
	public void insert(E val, int index)//O(N/2) to O(1)
	{
		if(index > size || index < 0)
			index = size;
		MyLinkedListNode<E> newItem = new MyLinkedListNode<E>(val);
		if(index == 0)
		{
			newItem.next = start;
			if(start == null)
			{
				end = newItem;
			}
			else
			{
				start.prev = newItem;
			}
			start = newItem;
		}
		else if(index == size)
		{
			end.next = newItem;
			newItem.prev = end;
			end = newItem;
		}
		else if(index > (size/2))//2nd half of list
		{
			MyLinkedListNode<E> current = end;
			for(int i = size; i > index; i--)
			{
				current = current.prev;
			}
			//current<- ->new<- ->current.next
			newItem.next = current.next;
			current.next.prev = newItem;
			current.next = newItem;
			newItem.prev = current;
		}
		else//first half of list
		{
			MyLinkedListNode<E> current = start;
			for(int i = 1; i < index; i++)
			{
				current = current.next;
			}
			//current<- ->new<- ->current.next
			newItem.next = current.next;
			current.next.prev = newItem;
			current.next = newItem;
			newItem.prev = current;
		}
		size++;
	}
	
	public void add(E val)//O(1)
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
	
	public int findRev(E val)//O(N)
	{
		MyLinkedListNode<E> current = end;
		int index = -1;
		for(int i = size-1; i >= 0; i--)
		{
			if(current.value == val)
			{
				index = i;
				break;
			}
			current = current.prev;
		}
		return index;
	}
	
	public void remove(E val)//O(N+N/2) = O(N)
	{
		int index = find(val);//O(N)
		if(index >= 0)
			delete(index);//O(N/2)
	}
	
	public void removeRev(E val)//O(N+N/2) = O(N)
	{
		int index = findRev(val);//O(N)
		if(index >= 0)
			delete(index);//O(N/2)
	}
	
	public void delete(int index)//O(N/2)
	{
		if(index == 0 && size > 0)
		{
			start = start.next;
			size--;
			if(size == 0)//if only 1 item was in list
				end = null;
		}
		if(index >= 0 && index == size-1)
		{
			end = end.prev;
			size--;
			if(size == 0)//if only 1 item was in list
				start = null;
		}
		else if(index > 0 && index < (size/2))//first half
		{
			MyLinkedListNode<E> current = start;
			for(int i = 0; i < index-1; i++)//find item before removal
			{
				current = current.next;
			}
			//current, remove, after
			current.next = current.next.next;
			current.next.prev = current;
			size--;
		}
		else if(index > 0 && index < size)//second half
		{
			MyLinkedListNode<E> current = end;
			for(int i = size-1; i > index; i--)//find item after removal
			{
				current = current.prev;
			}
			//before, remove, current
			current.prev = current.prev.prev;
			current.prev.next = current;
			size--;
		}
	}
	public E get(int index)//O(N/2)
	{
		if(index >= 0 && index < size)
		{
			if(index < (size/2))//first half
			{
				MyLinkedListNode<E> current = start;
				for(int i = 0; i < index; i++)
					current = current.next;
				return current.value;
			}
			else//second half
			{
				MyLinkedListNode<E> current = end;
				for(int i = size-1; i > index; i--)
					current = current.prev;
				return current.value;
			}
		}
		else
			return null;
	}
	
	public void swap(int index) {
		System.out.println("\n\nNow swapping the indexes: "+index+" and "+(index+1)+"...");
		
		MyLinkedListNode<E> first = getNode(index);
		MyLinkedListNode<E> second = first.next;
		
		System.out.println("Index "+index+": "+first.value+"\nIndex "+(index+1)+": "+second.value);
		
		MyLinkedListNode<E> loop = start;
		
		if (index == 0) {
			first.next = second.next;
			first.prev = second.prev;
			second.prev = null;
			second.next = first;
			start = second;
		}
		else {
		
			for (int i = 0; i<index-1; i++) {
				loop = loop.next;
			}
			
			first.next = second.next;
			
			second.prev = loop;
			
			loop.next = second;
			
			second.next = first;
		
			first.prev = second;
		}
		
	}
	
	public MyLinkedListNode<E> getNode(int index)//O(N/2)
	{
		if(index >= 0 && index < size)
		{
			if(index < (size/2))//first half
			{
				MyLinkedListNode<E> current = start;
				for(int i = 0; i < index; i++)
					current = current.next;
				return current;
			}
			else//second half
			{
				MyLinkedListNode<E> current = end;
				for(int i = size-1; i > index; i--)
					current = current.prev;
				return current;
			}
		}
		else
			return null;
	}

	public class MyLinkedListNode<E>{
		public MyLinkedListNode next;
		public MyLinkedListNode prev;
		public E value;
		public MyLinkedListNode(E v)
		{
			value = v;
			next = null;
			prev = null;
		}
	}
}
