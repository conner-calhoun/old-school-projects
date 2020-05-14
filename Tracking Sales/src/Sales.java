// ***************************************************************
// Conner Calhoun
// 
// Sales.java
//
// Reads in and stores sales for each of 5 salespeople.  Displays
// sales entered by salesperson id and total sales for all salespeople.
//
// ***************************************************************
import java.util.Scanner;

public class Sales
{
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the number of Salespeople: ");
		int salespeople = scan.nextInt();
		
		int[] sales = new int[salespeople];
		int sum;
		int maxSale = 0;
		int minSale = 999999999;
		int maxSeller = 0;
		int minSeller = 0;
		int expectation;
		int expectCounter = 0;
		
		for (int i=0; i<sales.length; i++)
			{
				System.out.print("Enter sales for salesperson " + (i+1) + ": ");
				sales[i] = scan.nextInt();
				
				if (sales[i] > maxSale)
				{
					maxSale = sales[i];
					
					maxSeller = i;
					// System.out.println(maxSeller);
				}
				
				if (sales[i] < minSale)
				{
					minSale = sales[i];
					
					minSeller = i;
				}
				
			}
		
		System.out.println("\nSalesperson  Sales");
		System.out.println(" ------------------ ");
		sum = 0;
		for (int i=0; i<sales.length; i++)
			{
				System.out.println("     " + (i+1) + "         " + sales[i]);
				sum += sales[i];
			}
		
		System.out.println("\nTotal Sales: " + sum);
		System.out.println("\nAverage Sale: " + sum/5);
		System.out.println("\nThe highest sale was by Salesperson "+(maxSeller+1)+" and it was $"+maxSale+".");
		System.out.println("\nThe lowest sale was by Salesperson "+(minSeller+1)+" and it was $"+minSale+".");
		
		System.out.println("\nEnter a value for sale expectations: ");
		expectation = scan.nextInt();
		System.out.println("\nThese are the Salespeople who exceeded your expectation: ");
		
		for (int i=0; i<sales.length; i++)
			{
			
				if (sales[i] > expectation)
					{
						System.out.println ("Salesperson "+(i+1)+", and the Sale was $"+sales[i]+".");
						expectCounter++;
					}
			
			}
		
		System.out.println("\nThe total number of people who exceeded your expectations was: "+expectCounter+".");
			
	}
}