public class CompareTrees {
	
	// The comparison program runs in linear time, O(N)

	public static void main(String[] args) {
		
		BST<Integer> treeOne = new BST<>();
		treeOne.insert(1);
		treeOne.insert(2);
		treeOne.insert(3);
		treeOne.insert(4);
		treeOne.insert(5);
		
		BST<Integer> treeTwo = new BST<>();
		treeTwo.insert(1);
		treeTwo.insert(2);
		treeTwo.insert(3);
		treeTwo.insert(4);
		treeTwo.insert(5);
		
		// Both tree one and tree two are similar
		
		BST<Integer> treeThree = new BST<>();
		BST<Integer> treeFour = new BST<>();
		
		// Both tree Three and Tree Four are similar
		
		BST<Integer> treeFive = new BST<>();
		treeFive.insert(1);
		treeFive.insert(6);
		
		BST<Integer> treeSix = new BST<>();
		treeSix.insert(8);
		treeSix.insert(9);
		treeSix.insert(2);
		
		// Tree Six and Tree One are different
		
		System.out.print("Tree One: ");
		treeOne.printTree();
		System.out.println();
		
		System.out.print("Tree Two: ");
		treeTwo.printTree();
		System.out.println();
		
		System.out.print("Tree Three: ");
		treeThree.printTree();
		System.out.println();
		
		System.out.print("Tree Four: ");
		treeFour.printTree();
		System.out.println();
		
		System.out.print("Tree Five: ");
		treeFive.printTree();
		System.out.println();
		
		System.out.print("Tree Six: ");
		treeSix.printTree();
		System.out.println();
		
		System.out.println();
		
		System.out.print("Comparing Tree One and Tree Two: ");
		compare(treeOne, treeTwo);
		System.out.println();
		
		System.out.print("Comparing Tree Three and Tree Four: ");
		compare(treeThree, treeFour);
		System.out.println();
		
		System.out.print("Comparing Tree Five and Tree Six: ");
		compare(treeFive, treeSix);
		System.out.println();
		
	}
	
	public static void compare(BST one, BST two) { // O(N) -- The program runs in linear time.
		// If they are different, return false, same, return true
		if (one.getNumNodes() != two.getNumNodes()) // O(1)
			System.out.print(" Trees are different.");
		else if (!one.isEmpty() && !two.isEmpty()) {
			one.compare(two); // O(N)
		}
		else if(one.isEmpty() && two.isEmpty()) { // O(1)
			System.out.print(" Trees are the same.");
		}
	}

}
