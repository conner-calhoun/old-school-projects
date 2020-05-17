import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RecursiveLoop {

		public static void main (String[] args) throws FileNotFoundException {
			
			System.out.println("For this section, I'm interpreting N to be equal "
					+ "to the number of items in the list of numbers.\nI also have included the same two files as before, "
					+ "along with two scanners to use. (One is commented out)");
			
			int N = 0;
			
			//Scanner s = new Scanner (new File("ten")); // List of 10 Numbers
			Scanner s = new Scanner (new File("number_list")); // List of 100 Numbers
			//Scanner s = new Scanner (new File("big_list")); // List of 1000 numbers
			//Scanner s = new Scanner (new File("million")); // List of 1 Million numbers
			ArrayList<Integer> nums = new ArrayList<Integer>();
			while(s.hasNextInt()) {
				nums.add(s.nextInt());
			}
			for (int n: nums) {
				N++;
			}
			
			System.out.println("In the case of this list, N = " + N + "\nThe Binary Representation of N is: " + 
			Integer.toBinaryString(N));
			
			System.out.println("\nThe number of '1's in the Binary representation of N: " + ones(N));
		}
		
		// This takes in the integer N
		public static int ones(int x) {
			if (x == 0) {
				return 0;
			}
			else if(x%2 == 0) {
				return ones(x/2);
			}
			else if(x%2 != 0) {
				return ones(x/2) + 1;
			}
			
			return 0;
		}
		
}
