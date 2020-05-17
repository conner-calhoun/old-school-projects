public class Tester {

	public static void main(String[] args) {
		
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		
		// Testing the tree.
		// Lazy Delete and Print Tree Work now.
		System.out.println("Here is the Tree:");
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.printTree();
		System.out.println("Min Value: "+tree.findMin());
		System.out.println("Removing Min Value...\nNew Tree:");
		tree.lazyDel(1);
		tree.printTree();
		System.out.println("New Min: "+tree.findMin());
		
		tree.makeEmpty();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		
		System.out.println("\nWiped the tree, here is the new tree: ");
		tree.printTree();
		System.out.println("Tree Max: "+tree.findMax());
		tree.lazyDel(tree.findMax());
		System.out.println("Deleting Max...\nNew Tree:");
		tree.printTree();
		System.out.println("New Max: "+tree.findMax());
		
	}

}
