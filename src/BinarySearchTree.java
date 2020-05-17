public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
	
	
	/* 4.16)
	 * 	Redo the binary search tree class to implement lazy deletion. 
	 * 	Note carefully that this affects all of the routines. 
	 * 	Especially challenging are findMin and findMax, which 
	 * 	must now be done recursively.
	 */
	
	private static class BinaryNode<AnyType>{
		BinaryNode( AnyType theElement ){ 
			this( theElement, null, null, false ); 
		}
		
		BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt, boolean del ){
			element = theElement; 
			left = lt; 
			right = rt; 
			deleted = del;
		}
		
		AnyType element;            // The data in the node
		BinaryNode<AnyType> left;   // Left child
		BinaryNode<AnyType> right;  // Right child
		boolean deleted;			// The status of the node, if it has been "Deleted"
	}
	
	public BinaryNode<AnyType> root;
	
	public BinarySearchTree(){ 
		root = null;
	}
	
	public void makeEmpty(){ 
		root = null;
	}
	
	public boolean isEmpty(){ 
		return root == null;
	}
	
	public boolean contains(AnyType x){ 
		return contains( x, root );
	}
	
	public AnyType findMin(){
		if(isEmpty())
			return (AnyType) "Tree is Empty";
		
	    return findMin( root ).element;
	}
	
	public AnyType findMax(){
		if(isEmpty()) 
			return (AnyType) "Tree is Empty";
		
		return findMax( root ).element;
	}
	
	public void insert(AnyType x){ 
		root = insert( x, root ); 
	}
	
	public void lazyDel(AnyType x) {
		root = lazyDel(x, root);
	}
	
	public void printTree(){ 
		if (isEmpty()) 
			System.out.println("Empty Tree");
		else 
			printTree(root);
	}
	
	private boolean contains(AnyType x, BinaryNode<AnyType> t){ 
		if (t == null)
			return false;
		
		int compareResult = x.compareTo(t.element);
		
		if (compareResult < 0) 
			return contains( x, t.left );
		else if(compareResult > 0)
			return contains( x, t.right );
		else 
			return true; // Match
	}
	
	private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t ){ 
		if( t == null )
			   return null;
		
		BinaryNode<AnyType> temp = findMin(t.left);
		
		if(temp != null)
			return temp;
		
		if (!t.deleted)
			return t;
		
		return findMin(t.right);
	}
	
	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
		if( t == null )
			   return null;
		
		BinaryNode<AnyType> temp = findMax(t.right);
		
		if(temp != null)
			return temp;
		
		if (!t.deleted)
			return t;
		
		return findMax(t.left);
	}
	
	
	private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t ){
		if (t == null) 
			return new BinaryNode<>( x, null, null, false );
		
		int compareResult = x.compareTo(t.element);
		
		if (compareResult < 0) 
			t.left = insert( x, t.left );
		else if( compareResult > 0 )
		    t.right = insert( x, t.right );
		else
		    ;  // Duplicate; do nothing
		return t;
	}
	
	private BinaryNode<AnyType> lazyDel(AnyType x, BinaryNode<AnyType> t) {
		
		if (t == null)
			return t;
		
		
		int compareResult = x.compareTo(t.element);
		if (compareResult < 0)
			t.left = lazyDel( x, t.left );
		else if( compareResult > 0 )
		    t.right = lazyDel( x, t.right );
		else if( t.left != null && t.right != null ) // Two children
		{
		    t.element = findMin( t.right ).element;
		    t.right = lazyDel( t.element, t.right );
		}
		else
		    t.deleted = true;
		
		// For debugging purposes
		//System.out.println("T Value: "+t.element.toString());
		//System.out.println("T Deleted Value: "+t.deleted);
		return t;
		
	}
	
	private void printTree( BinaryNode<AnyType> t) {
		if (t != null) {
			if (!t.deleted) {
				printTree( t.left );
		    	System.out.println( t.element );
		    	printTree( t.right );
			}
		   	else {
		    	printTree(t.left);
		    	printTree(t.right);
		    }
		}
	}
	
}