
public class Sum {

	public static void main(String[] args) {
		
//		System.out.println(sum(2)); // 1^3 + 2^3
//		System.out.println(sum(3)); // 1^3 + 2^3 + 3^3
//		System.out.println(sum(4)); // 1^3 + 2^3 + 3^3 + 4^3
//		System.out.println(sum(5)); // 1^3 + 2^3 + 3^3 + 4^3 + 5^3
//		System.out.println(sum(6)); // 1^3 + 2^3 + 3^3 + 4^3 + 5^3 + 6^3
		
		long startTime = System.nanoTime();
		
		int[] arr =new int[5000];
		
		maxSubSum1(arr);
		
		long endTime = System.nanoTime();
		
		startTime = nanoToSec(startTime);
		endTime = nanoToSec(endTime);
		
		System.out.println("The program took "+(endTime - startTime) + " seconds.");

	}
	
	public static int sum(int n) // F(N) = 0 + 1 + N + 1 = O(N)
	{
		int partialSum; // Zero Time
		partialSum = 0; // One Time = O(1)
		for (
				int i = 1; // One Time = O(1)
				i <= n; // N Times + 1 = O(N)
				i++ // N Times = O(N)
				) // F(N) = 1 + (N+!) + N = O(N)
		{
			// For loop is O(N) * work inside of loop
			partialSum += i*i*i; // Four Time O(1)
		}
		return partialSum;
	}
	
	public static int maxSubSum1 (int [] a) {
		int maxSum = 0;
		
		for (int i = 0; i < a.length; i++) {
			for(int j = i; j < a.length; j++) {
				int thisSum = 0;
				
				for (int k = i; k <= j; k++) 
					thisSum += a[k];
				
				if (thisSum > maxSum)
					maxSum = thisSum;
			}
		}
		
		return maxSum;
	}
	
	public static long nanoToSec(long startTime) {
		startTime = startTime / 1000000000;
		return startTime;
	}
	
	

}
