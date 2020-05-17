public class TwoSeven {
	static int sum;
	
	public static void main (String[] args) {		
		PartOne(10);
		PartOne(50);
		PartOne(100);
//		PartOne(1000);
		nl();
		PartTwo(10);
		PartTwo(50);
		PartTwo(100);
//		PartTwo(1000);
		nl();
		PartThree(10);
		PartThree(50);
		PartThree(100);
//		PartThree(1000);
		nl();
		PartFour(10);
		PartFour(50);
		PartFour(100);
//		PartFour(1000);
		nl();
		PartFive(10);
		PartFive(50);
		PartFive(100);
//		PartFive(1000);
		nl();
		PartSix(10);
		PartSix(50);
		PartSix(100);
//		PartSix(1000);
	}
	
	public static void PartOne(int n) {
		long startTime = System.nanoTime();
		sum = 0;
		for (int i = 0; i < n; i++) 
			sum ++;
		long endTime = System.nanoTime();
		System.out.println("Part One, N = " + n + ", Took "+(endTime - startTime) + "ns"); 
	}
	
	public static void PartTwo(int n) {
		long startTime = System.nanoTime();
		sum = 0;
        for(int i = 0; i < n; i++ )
            for(int j = 0; j < n; j++ )
                sum++;
        long endTime = System.nanoTime();
		System.out.println("Part Two, N = " + n + ", Took "+(endTime - startTime) + "ns"); 
	}
	
	public static void PartThree(int n) {
		long startTime = System.nanoTime();
		sum = 0;
        for(int i = 0; i < n; i++ )
            for(int j = 0; j < n * n; j++ )
                sum++;
        long endTime = System.nanoTime();
		System.out.println("Part Three, N = " + n + ", Took "+(endTime - startTime) + "ns"); 
	}
	
	public static void PartFour(int n) {
		long startTime = System.nanoTime();
		sum = 0;
        for(int i = 0; i < n; i++ )
            for(int j = 0; j < i; j++ )
                sum++;
        long endTime = System.nanoTime();
		System.out.println("Part Four, N = " + n + ", Took "+(endTime - startTime) + "ns"); 
	}
	
	public static void PartFive(int n) {
		long startTime = System.nanoTime();
		sum=0;
		for(int i = 0; i < n; i++ )
			for(int j = 0; j < i * i; j++ )
				for(int k = 0; k < j; k++ )
					sum++;
		long endTime = System.nanoTime();
		System.out.println("Part Five, N = " + n + ", Took "+(endTime - startTime) + "ns"); 
	}
	
	public static void PartSix(int n) {
		long startTime = System.nanoTime();
		sum=0;
		for(int i = 1; i < n; i++ )
			for(int j = 1; j < i * i; j++ )
				if(j % i == 0 )
					for(int k = 0; k < j; k++ )
						sum++;
		long endTime = System.nanoTime();
		System.out.println("Part Six, N = " + n + ", Took "+(endTime - startTime) + "ns"); 
	}
	
	public static void nl() {
		System.out.println();
	}
	
}
