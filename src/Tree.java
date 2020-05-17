import java.io.File;

public class Tree<E> {
	private Node<E> root;
	
	public Tree()
	{
		root = null;
	}
	
	public void insert(E parent, E item, boolean folder)
	{
		Node<E> newItem = new Node<E>(item);
		if(root == null)//empty list
		{
			if (folder == true)
				newItem.isFolder = true;
			root = newItem;
		}
		else
		{
			if (folder == true)
				newItem.isFolder = true;
			Node<E> current = findNode(parent, false);
			if(current != null)//found parent
			{
				if(current.firstChild == null)//no children yet
				{
					current.firstChild = newItem;
				}
				else//has at least one child, find end of child list
				{
					current = current.firstChild;
					while(current.nextSibling != null)//work to last sibling in list
					{
						current = current.nextSibling;
					}
					current.nextSibling = newItem;
				}
			}
			//you could an else statement here to allow siblings of the root node
		}
	}
	
	public void getState(Node<E> node) {
		if (node.isFolder == true) 
			System.out.println(node.value+" is a folder");
		else
			System.out.println(node.value+" is NOT a folder");
	}
	
	public String getRoot() {
		String output = "";
		output = (String) root.value;
		return output;
	}
	
	public Node<E> getRootNode() {
		return root;
	}
	
	public String find(E item)//used to test the findNode method
	{
		String output = "Search for:"+item.toString()+"\n";
		Node<E> current = findNode(item, true);
		if(current == null)
			output += "NOT FOUND";
		else
		{
			output += "Node:"+current.toString();
			if(current.nextSibling != null)
				output += "\nSibling:"+current.nextSibling;
			if(current.firstChild != null)
				output += "\nChild:"+current.firstChild;
		}
		return output+"\n";
	}
	
	private Node<E> findNode(E item, boolean print)
	{
		return findHelper(item, root, print);//recursive search for item
	}
	
	private Node<E> findHelper(E item, Node<E> current, boolean print)
	{
		Node<E> temp = null;
		if(current.value.equals(item))//check if current node is the item being looked for
		{
			temp = current;
		}
		else
		{
			if(temp == null && current.nextSibling != null)//check sibling for item
			{
				temp = findHelper(item, current.nextSibling, print);//check siblings/children of this node
			}
			if(temp == null && current.firstChild != null)//check child for item
			{
				temp = findHelper(item, current.firstChild, print);//check siblings/children of this node
			}
		}
		return temp;
	}

	public void print()
	{
		if(root != null)
		{
			System.out.println("Root: "+ root.value);
			printSiblings(root);//recursive print method
		}
	}
	
	public void printAsStructure() {
		
		if(root != null)
		{
			System.out.println(root.value);
			loopS(root, 1);
		}
		
	}
	
	private void loopS(Node<E> curr, int indent) {
		
		Node<E> cursor = curr.nextSibling;
		loopC(curr, indent);
		
	}
	
	private void loopC(Node<E> curr, int indent) {
		
		Node<E> cursor = curr.firstChild;
		while(cursor != null)
		{
			String repeated = new String(new char[indent]).replace("\0", "   ");
			System.out.println(repeated+cursor.value);
			if (cursor.firstChild != null) {
				indent+=1;
				loopC(cursor, indent);
				if (cursor.isFolder)
					indent-=1;
			}
			cursor = cursor.nextSibling;
			
		}
		if(curr.firstChild != null)//print siblings of child
		{
			loopS(curr.firstChild, indent);
		}
	}
	
	private void printSiblings(Node<E> curr)
	{
		System.out.print("Siblings of "+curr.value+":");
		Node<E> cursor = curr.nextSibling;
		while(cursor != null)//print all siblings
		{
			System.out.println(", "+cursor.value);
			cursor = cursor.nextSibling;
		}
		System.out.println();
		printChildren(curr);//call print children on this node
		cursor = curr.nextSibling;
		while(cursor != null)//print children of all siblings
		{
			printChildren(cursor);
			cursor = cursor.nextSibling;
		}
	}
	private void printChildren(Node<E> curr)
	{
		System.out.print("Children of "+curr.value+":");
		Node<E> cursor = curr.firstChild;
		while(cursor != null)//print all children
		{
			System.out.print(", "+cursor.value);
			cursor = cursor.nextSibling;
		}
		System.out.println();
		if(curr.firstChild != null)//print siblings of child
		{
			printSiblings(curr.firstChild);
		}
	}
	
	public void getType(File f, Node<E> curr) {
		
		if (f.isDirectory()) 
			curr.isFolder = true;
		
	}
	public class Node<E>{
		public E value;
		public Node<E> firstChild;
		public Node<E> nextSibling;
		public boolean isFolder = false;
		public Node(E v)
		{
			value = v;
			firstChild = null;
			nextSibling = null;
		}
	}
}
