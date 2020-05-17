import java.util.Arrays;
import java.util.Collections;

public class TwoOneNine {

	public static void main (String[] args) {
		
		Integer [] a = new Integer [10];
		for (int i = 0; i<a.length; i++) {
			a[i] = i-3;
		}
		Collections.shuffle(Arrays.asList(a));
		System.out.print("The array passed into the algorithms is as follows: ");
		for (int p = 0; p<a.length; p++) {
			if (p != 0)
				System.out.print(", ");
			System.out.print(a[p]);
		}
		System.out.println("\n");
		System.out.println("Max Sub Sum Algorithm 2: " + maxSubSum2(a));
		System.out.println();
		System.out.println("Max Sub Sum Algorithm 4: " + maxSubSum4(a));
	}
	
	
	public static int maxSubSum2( Integer[] a ) {
		int maxSum = 0;
		Integer[] seq = new Integer [10];
		
		for (int i = 0; i < a.length; i++) {
			// Loops through the array
			int thisSum = 0;
			
			for (int j = i; j <a.length; j++) {
				// For each value of the array, loop through, adding the remaining values.
				thisSum += a[j];
				System.out.print(a[j] + ", ");
				//System.out.println("thisSum: " + thisSum);
				
				if (thisSum > maxSum) { 
					maxSum = thisSum;
					seq = Arrays.copyOfRange(a, i, 10); 
				}
					
			}
			System.out.println();
		}
		
		System.out.println("\nAlgorithm Two Max Sequence: " + Arrays.toString(seq));
		return maxSum;
	}
	
	public static int maxSubSum4( Integer[] a ) {
		int maxSum = 0, thisSum = 0;
		Integer[] seq = new Integer [10];
		
		for( int j = 0; j < a.length; j++ ) {
			thisSum += a[ j ];
			System.out.print(a[j] + ", ");
			// Loop through and find the sum of the indicies
		    if( thisSum > maxSum ) {
		    	maxSum = thisSum;
		    	seq = a;
		    }
		    else if( thisSum < 0 ) { 
		        thisSum = 0;
		    }
		 }
		System.out.println("\nAlgorithm Four Max Sequence: " + Arrays.toString(seq));
		return maxSum;
	}
		 

}

