//***************************************************
// Conner Calhoun
//
// Lab2 Ideal Weight
//
// Weight.java
//
// User inputs height and weight and the program
// will inform them if they are within the recommended
// weight range
//***************************************************

import java.util.Scanner;

public class Weight 
{
	public static void main (String[] args)
	
	{
		// Declares that height in feet and height in inches
		// are variables that are entered by the user
		int heightft;
		int heightin;
			
			// Creates a new scanner for feet
			Scanner scanf = new Scanner(System.in);
			System.out.print ("Enter your height in feet:");
			heightft = scanf.nextInt ();
			
					System.out.println ();
			
			// Creates a new scanner for inches
			Scanner scani = new Scanner(System.in);
			System.out.print ("Enter the remaining inches:");
			heightin = scani.nextInt ();
			
		// totalheight is the height in inches
		// which converts feet to inches, then adds the remainder inches
		int totalheight = (12 * heightft) + heightin;
			
					System.out.println ();
			
		int idealf = 100 + (5 * (totalheight - 60));
		int idealm = 106 + (6 * (totalheight - 60));
			
			System.out.println ("The ideal weight for a male would be: " + idealm);
				System.out.println ();
			System.out.println ("The ideal weight for a female would be: " + idealf);	
			
		
		// Declares the "okay" range for male and female weight	
		double mplus15 = idealm + (.15 * idealm);
		double fplus15 = idealf + (.15 * idealf);
		
		double mminus15 = idealm - (.15 * idealm);
		double fminus15 = idealf - (.15 * idealf);
		
				System.out.println ();
		System.out.println ("The range for a male could be between " + mminus15 + " and " + mplus15);
		System.out.println ();
		System.out.println ("The range for a female could be between " + fminus15 + " and " + fplus15);
					
	}

}
