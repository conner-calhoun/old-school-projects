// ************************************************************************
// Conner Calhoun
// LoveCS.java
// Use a while loop to print a message about computer science.
// ************************************************************************
import java.util.Scanner;

public class LoveCS
{
	public static void main (String [] args)
	{
		int printNumber;
		int count = 1;
		int count2 = 1;
		int sum = 0;
		
		Scanner scan = new Scanner (System.in);
		System.out.println ("Enter the number of times you wish to print the message: ");
		printNumber =scan.nextInt();
		
		// while statement that prints the statement as long as the count is less than or equal to the number you entered.
		while (count <= printNumber)
		{
			System.out.println (count + " I Love Computer Science!!");
			count ++;
		}
		
		// creates a new integer, the number of times the message was printed
		int numberPrinted = count - 1;
		
		// a new while statement that adds the count to the sum as long as the count is less than or equal to the printNumber.
		// had to create a new count so as not to interfere with the original count.
		while (count2 <= printNumber)
		{
			sum += count2;
			count2 ++;
		}
		
		System.out.println ("You printed the message " + numberPrinted + " times! The sum of the numbers is: " + sum + ".");
		
	}
	
}