
public class Main {

	public static void main(String[] args) {
		BinarySearchTree<Integer> test = new BinarySearchTree<>();
		test.insert(1);
		test.insert(2);
		test.insert(3);
		test.printTree();
		
		test.remove(1);
		
		test.printTree();
	}

}
