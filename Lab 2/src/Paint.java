//*****************************
// Conner Calhoun
// Lab2 Part2
// Paint.java
// Paint.java determines how much paint is needed 
// to paint the walls of a room with given length, width, and height
//*****************************

import java.util.Scanner;

public class Paint 
{
	public static void main (String [] args)
	{
		final int coverage = 350; //paint covers 350 sq ft/gal
		
		System.out.println ("The following program will help you decide how many gallons "
							+ "of paint you will need to paint a room.");
		System.out.println ();
		
		// declares that length is an integer and is declared by the user
		int length;
			Scanner L = new Scanner(System.in);
			System.out.println ("Enter a length:");
			length = L.nextInt ();
		
		// declares that width is an integer and is declared by the user
		int width;
			Scanner W = new Scanner(System.in);
			System.out.println ("Enter a width:");
			width = W.nextInt ();
			
		// declares that height is an integer and is declared by the user
		int height;
			Scanner H = new Scanner(System.in);
			System.out.println ("Enter a height:");
			height = H.nextInt ();
			
			System.out.println ();
		
		// has the user input the number of doors
		int doors;
			Scanner D = new Scanner(System.in);
			System.out.println ("Enter the number of doors: ");
			doors = D.nextInt ();
			
			System.out.println ();
			
		// input the number of windows
		int windows;
			Scanner Win = new Scanner(System.in);
			System.out.println ("Enter the number of windows: ");
			windows = Win.nextInt ();
			
			System.out.println ();
			
		// square feet of doors and windows combined
		int doorwindowsqft;	
			doorwindowsqft = doors * 20 + windows * 10;
					
			System.out.println ();
	
		// Declares the total square feet of the room
	double totalSqFt = (length * width * height) - doorwindowsqft;
		System.out.println (totalSqFt + " is the total square feet of the wall needing to be painted");
		
		System.out.println ();
	
		// Declares the amount of paint needed
	double paintNeeded = totalSqFt / coverage;
		System.out.println(paintNeeded + " gallons is the total amount of paint needed to paint the room.");
		
		System.out.println ();
	
	System.out.print ("The length of the room is " + length + ". ");
	System.out.print ("The width of the room is " + width + ". ");
	System.out.println ("The height of the room is " + height + ". ");
	System.out.println ("And you will need " + paintNeeded + " gallons of paint to paint the room.");
	
	
	}

}
