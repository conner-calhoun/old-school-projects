import java.lang.reflect.Array;
import java.util.Random;

public class TwoEight {

	public static void main(String[] args) {
		
//		AlgoOne(250);
//		AlgoOne(500);
//		AlgoOne(1000);
//		AlgoOne(2000);
		
//		AlgoTwo(25000);
//		AlgoTwo(50000);
//		AlgoTwo(100000);
//		AlgoTwo(200000);
//		AlgoTwo(400000);
//		AlgoTwo(800000);
		
		AlgoThree(100000);
		AlgoThree(200000);
		AlgoThree(400000);
		AlgoThree(800000);
		AlgoThree(1600000);
		AlgoThree(3200000);
		AlgoThree(6400000);

	}
	
	public static void AlgoOne(int n) { // O(N^3)
		long startTime = System.nanoTime();
		int[] a = new int[n];
		Random rand = new Random();
		for (int i = 0; i<a.length; i++) { // O(N)
			int r = rand.nextInt(n) + 1;
			// System.out.println("The initial value r: " + r); Debug
			for (int j = 0; j<a.length; j++) { // O(N)
				while(r == a[j]) { // O(N)
					// System.out.println("a[j] = " + a[j]); Debug
					// System.out.println("Generating new value for r"); Debug
					r = rand.nextInt(n)+1;
					// System.out.println("New value: " + r); Debug
					j = 0;
				}
			}
			// System.out.println("Adding the value: " + r); Debug
			a[i] = r;
		}
		// printIntArray(a);
		long endTime = System.nanoTime();
		System.out.println("Algorithm One, N = " + n + ", Took "+(endTime - startTime) + " ns");
	}
	
	public static void AlgoTwo(int n) { // O(N^2)
		long startTime = System.nanoTime();
		
		int[] a = new int[n];
		boolean[] used = new boolean[n];
		Random rand = new Random();
		
		for(int i=0; i<a.length; i++) { // O(N)
			
			int r = rand.nextInt(n)+1;
			// System.out.println("The initial value of r: " + r);
			
			while(used[r-1] == true) { //O(N)
				r = rand.nextInt(n) + 1;
				// System.out.println("The value is already true, generating new r...");
			}
			
			used[r-1] = true;
			// System.out.println("The value: " + r + " has been set to true");
			
			// System.out.println("Adding " + r + " to the array!");
			a[i] = r;
		}
		// printIntArray(a);
		
		long endTime = System.nanoTime();
		System.out.println("Algorithm Two, N = " + n + ", Took "+(endTime - startTime) + " ns");
	}
	
	public static void AlgoThree(int n) { // O(N)
		long startTime = System.nanoTime();
		
		Random rand = new Random();
		
		int[] a = new int[n];
		
		for (int i=0; i<a.length; i++) { // O(N)
			a[i] = i + 1;
			
			int temp = a[i];
			int next = randNum(0, i);
			a[i] = a[next];
			a[next] = temp;
		}
		
		// printIntArray(a);
		
		long endTime = System.nanoTime();
		System.out.println("Algorithm Three, N = " + n + ", Took "+(endTime - startTime) + " ns");
	}
	
	public static int randNum(int first, int last) {
		int x;
		
		x = first + (int)(Math.random() * last); 
		
		return x;
	}
	

	public static void printIntArray(int[] a) {
		System.out.print("The final array is: ");
		for(int i = 0; i < a.length; i++) {
			if (i != 0)
				System.out.print(", ");
			System.out.print(a[i]);
		}
	}

}
