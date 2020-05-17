import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/*
 * Big O Notation for the Problem = O(N^2)
 * By using your own ADT you would be able to imporve runtime
 */

public class Josephus {
	
	public static void main (String[] args) {
		Random rand = new Random();
		
		int N = rand.nextInt(10) + 1;
		int M = rand.nextInt(10);
		
		System.out.println("Number of People: "+N+"\nNumber of Steps: "+M);
		System.out.println("Winner: "+josephus(N,M));
	}
	
	public static int josephus(int N, int M) {		//O(N^2)
		
		LinkedList<Integer> people = new LinkedList<Integer>();
		for (int i = 1; i<=N; i++)								//O(N)
			people.add(i);
		
		Iterator<Integer> itr = people.iterator();
		while(N > 1) {											// O(N)
			for (int i=0; i<=M; i++) {							// O(N)
				if (itr.hasNext()) 
					itr = people.iterator();
				itr.next();
			}
			System.out.println("List: "+people.toString());
			System.out.println("Eliminating: "+ itr.next());
			itr.remove();
			N--;
		}
		itr = people.iterator();
		return itr.next();	
	}

}
