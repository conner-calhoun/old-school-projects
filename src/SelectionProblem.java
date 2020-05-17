import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SelectionProblem {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		
		System.out.println("This program will take a list of numbers, sort them, and find the 'k'th number. \nIn this case, k"
				+ " = N/2 (Where N is the number of items in the list.) \nThus making k = 50 (From a List of 100 numbers).\nThe list "
				+ "will be numbers 1-N ordered randomly.\nThe Program will work wil any list of numbers. (Four"
				+ " have been included.)\n");
		
		System.out.println("This is the 'k'th term of a list of 1-N numbers: " + findK());
		
		long endTime = System.nanoTime();
		
		System.out.println("Took "+(endTime - startTime) + " ns"); 
	}
	
	public static int findK() throws FileNotFoundException {
		
		//Scanner s = new Scanner (new File("number_list")); // List of 100 Numbers
		//Scanner s = new Scanner (new File("ten")); // List of 10 Numbers
		Scanner s = new Scanner (new File("million")); // List of 1 Million Numbers
		//Scanner s = new Scanner (new File("big_list")); // List of 1000 numbers
		ArrayList<Integer> nums = new ArrayList<Integer>();
		while(s.hasNextInt()) {
			nums.add(s.nextInt());
		}
		
		// Get size of nums list;
		int n = nums.size();
		
		Collections.sort(nums);
		Collections.reverse(nums);
		
		int k = n/2;
		
		return k;
	}
	
	
}
