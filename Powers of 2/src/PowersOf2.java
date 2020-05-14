// ***************************************************************************
// Conner Calhoun
// PowersOf2.java
// Prints out as many powers of 2 as the user requests
// ***************************************************************************
import java.util.Scanner;

public class PowersOf2
{
	public static void main (String[] args)
	{
		int numPowersOf2; // How many powers of 2 to compute
		int nextPowerOf2 = 1; //Current power of 2
		int exponent; //Exponent for current power of 2 -- this also serves as a counter for the loop
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println ("How many powers of 2 would you like printed: ");
		numPowersOf2 = scan.nextInt();
		
		System.out.println ("We will now print out " + numPowersOf2 + " powers of 2.");
		exponent = 0;
		
		while (exponent <= numPowersOf2)
		{
			System.out.println ("Two to "+exponent+ " is " + nextPowerOf2 + ".");
			nextPowerOf2 = 2 * nextPowerOf2;
			exponent ++;
		}
	}
}