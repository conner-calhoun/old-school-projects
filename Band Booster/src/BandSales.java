//**********************************************************************
// Conner Calhoun
// 
// Lab 4 BandSales.java
//
// Tracks the amount of boxes of candy sold during the 3 week band booster.
//**********************************************************************
import java.util.Scanner;

public class BandSales 
{
	public static void main (String [] args)
	{
		// Creates two new "objects" Joe and Mary
		BandBooster joe = new BandBooster ("Joe");
		BandBooster mary = new BandBooster ("Mary");
		
		// creates the integers of number of boxes sold.
		int jweek1;
		int mweek1;
		int jweek2;
		int mweek2;
		int jweek3;
		int mweek3;
			
		// Creates new Scanner
		Scanner scan = new Scanner(System.in); // crates a new scanner
		
		// Scans for the number of boxes sold during a certain week, and then updates the sales
			System.out.println ("Enter the boxes sold by Joe during the first week: "); 
			jweek1 = scan.nextInt();
			joe.updateSales(jweek1);
			
			System.out.println ("Enter the boxes sold by Mary during the first week: "); 
			mweek1 = scan.nextInt();
			mary.updateSales(mweek1);
			
			System.out.println ("Enter the boxes sold by Joe during the second week: "); 
			jweek2 = scan.nextInt();
			joe.updateSales(jweek2);
			
			System.out.println ("Enter the boxes sold by Mary during the second week: "); 
			mweek2 = scan.nextInt();
			mary.updateSales(mweek2);
			
			System.out.println ("Enter the boxes sold by Joe during the third week: "); 
			jweek3 = scan.nextInt();
			joe.updateSales(jweek3);
			
			System.out.println ("Enter the boxes sold by Mary during the third week: "); 
			mweek3 = scan.nextInt();
			mary.updateSales(mweek3);
			
		// Prints the results
		System.out.println();
		System.out.println("Total Sales:");
		System.out.println("____________");
		System.out.println(joe.toString()); 
		System.out.println(mary.toString());
		
	}
	
}
