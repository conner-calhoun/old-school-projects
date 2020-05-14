// ***************************************************************************
// Conner Calhoun
// Factorial.java
// Takes a user-input non negative number and gives the factorial of it
// ***************************************************************************

import java.util.Scanner;

public class Factorial
{
	public static void main (String [] args)
	{
		int integer;
		int start = 1;
		int factorial = 1;
		
		Scanner scan = new Scanner (System.in);
		
		System.out.println ("Enter non-negative integer: ");
		integer = scan.nextInt();
		
		while (integer < 0)
			{
				System.out.println ("That is not what we asked for. Enter a non-negative integer: ");
				integer = scan.nextInt();
			}
			
		
		while (start <= integer)
			{
				factorial = factorial * start;
				start ++;
			}
			
		System.out.println ("The factorial of " + integer + " is " + factorial + ".");

	}
}
