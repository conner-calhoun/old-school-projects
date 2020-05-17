
public class LevelTester {
	public static void main (String[] args) {
		
		BinarySearchTree<Integer> test = new BinarySearchTree<>();
		
		test.insert(1);
		test.insert(2);
		test.insert(3);
		test.insert(13);
		test.insert(4);
		test.insert(5);
		test.insert(20);
		
		
		System.out.println("Printing tree normally:");
		test.printTree();
		System.out.println("Printing tree as levels:");
		test.printLevel();
		
	}
}
