//*********************************
//
//Conner Calhoun
//Lab 2 Part 1
//
//Circle.java
//
//Circle.java prints the area of a circle with 2 different radii
//*********************************

// The next line allow you to use the Scanner scan = new Scanner(System.in); command
//
import java.util.Scanner;

public class Circle 
{
	public static void main (String[] args)
	{
	
		final double PI = 3.14159;
		// The above line features the command "final" This "final" means that PI is a constant and will not change
		// ---------------------------------------------------------------------------------------------------------
		// The next lines are strings that allow the user to input a radius which then implements that radius
		// into the formula for area and circumference
		int radius1;
		Scanner scan = new Scanner(System.in);
		System.out.println ("Enter a radius: ");
		radius1 = scan.nextInt ();
	
		// The next few lines are the formulas for area and circumference with raidus1
		double area1 = PI * radius1 * radius1;
		double circumference1 = (PI * radius1) * 2;
		
			System.out.println ("The area of a circle with radius " + radius1 + " is " +area1);
			System.out.println ("The circumference of a circle with radius " + radius1 + " is " +circumference1);
			System.out.println ();
		
		// Allows the use to input a radius2 for use in the next formula for area and circumference
		int radius2;
		Scanner scan2 = new Scanner(System.in);
		System.out.println ("Enter another radius: ");
		radius2 = scan2.nextInt ();
		
		// Formula for area and circumference using radius2
		double area2 = PI * radius2 * radius2;
		double circumference2 = (PI * radius2) * 2;
		
			System.out.println ("The area of a circle with radius " + radius2 + " is " +area2);
			System.out.println ("The circumference of a circle with radius " + radius2 + " is " +circumference2);
			System.out.println ();
		
		// The formula for the change in area and circumference using user input radius1 and radius2
		double areachange = area2 / area1;
		double circumchange = circumference2 / circumference1;		
		
			System.out.println ("The change in growth in area is " + areachange);
			System.out.println ("The change in growth in cricumference is " + circumchange);
	}
	
}
