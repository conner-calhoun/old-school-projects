public class List {
	public static void main (String[] args) {
		List list = new List();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		list.cPrint();
	}
	
//	Create those global variables
	private Node<Integer> first;
	private int size;
	
	public List() {
//		Initialize the global variables
		this.first = null;
		this.size = 0;
	}
	
	private void add(int val) {
		Node<Integer> index = this.first;
		Node<Integer> toAdd = new Node<Integer>(val);
		if (this.first == null) {
			this.first = toAdd;
			this.size++;
		}
		else {
			while (index.next != null) {
				index = index.next;
			}
			index.next = toAdd;
			this.size++;
		} 
	}
	
//	Print list to console.
	private void cPrint() {
		System.out.println("Printing List:");
		Node<Integer> index = this.first;
		
		for(int incSize = 0; incSize < size; incSize++) {
			System.out.println("Index: "+incSize+"; Value: "+index.value+"\n");
			if (index.next != null) {
				index = index.next;
			}
		}
	}
	
//	Adding the <Integer> makes sure the node will hold an integer value
	public class Node<Integer> {
		Node next;
		int value;
		public Node(int val) {
			value = val;
			next = null;
		}
	}
}
