public class BST<AnyType extends Comparable<? super AnyType>> {
	
	
	private static class BinaryNode<AnyType>{
		BinaryNode( AnyType theElement ){ 
			this( theElement, null, null ); 
		}
		
		BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt ){
			element = theElement; 
			left = lt; 
			right = rt; 
		}
		
		AnyType element;            // The data in the node
		BinaryNode<AnyType> left;   // Left child
		BinaryNode<AnyType> right;  // Right child
	}

	
	private BinaryNode<AnyType> root;
	private int nodeCount;
	
	public BST(){ 
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
		nodeCount += 1;
	}
	
	public int getNumNodes() {
		return nodeCount;
	}
	
	public void remove( AnyType x ){ 
		root = remove( x, root ); 
	}
	
	public void printTree(){ 
		if (isEmpty()) 
			System.out.print("Empty Tree");
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
		else if( t.left == null )
			return t;
		
		return findMin( t.left );
	}
	
	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
		if (t!=null)
			while( t.right != null )
				t = t.right;
		return t;
	}
	
	
	private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t ){
		if (t == null) 
			return new BinaryNode<>( x, null, null );
		
		int compareResult = x.compareTo(t.element);
		
		if (compareResult < 0) 
			t.left = insert( x, t.left );
		else if( compareResult > 0 )
		    t.right = insert( x, t.right );
		else
		    ;  // Duplicate; do nothing
		return t;
	}
	
	private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t ){
		if (t == null)
			return t;;
			
		int compareResult = x.compareTo(t.element);
		if (compareResult < 0)
			t.left = remove( x, t.left );
		else if( compareResult > 0 )
		    t.right = remove( x, t.right );
		else if( t.left != null && t.right != null ) // Two children
		{
		    t.element = findMin( t.right ).element;
		    t.right = remove( t.element, t.right );
		}
		else
		    t = ( t.left != null ) ? t.left : t.right;
		return t;
	}
	
	private void printTree( BinaryNode<AnyType> t) {
		if (t != null) {
			printTree( t.left );
		    System.out.print( t.element + " ");
		    printTree( t.right );
		}
	}
	
	public void compare(BST tree) {
		if (root != null)
			traverse(root, tree);
	}
	
	int norepeat = 1;
	private void traverse(BinaryNode<AnyType> t, BST treeTwo) {
		if (t != null) {
			if (treeTwo.contains(t.element)) {// O(N)
				if (t.left != null)
					traverse(t.left, treeTwo);
				if (t.right != null)
					traverse(t.right, treeTwo);
			}
			if (!treeTwo.contains(t.element)){ //O(N)
				System.out.print(" Trees are different.");
				norepeat-=1;
			}
		}
		if (norepeat == 1) {
			System.out.print(" Trees are the same.");
			norepeat += 1;
		}
	}
	
}