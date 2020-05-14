//********************************************
// Conner Calhoun
// Lab 3
// Deli.java
// Computes the price of a deli item given the weight
// (in ounces) and price per pound -- prints a label,
// nicely formatted, for the item.
//********************************************
import java.util.Scanner;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class Deli
{
	// ---------------------------------------------------
	//  main reads in the price per pound of a deli item
	//  and number of ounces of a deli item then computes
	//  the total price and prints a "label" for the item
	// ---------------------------------------------------
		public static void main (String[] args)
		{
			// how many ounces in a pound
			final double OUNCES_PER_POUND = 16.0;
			
			// declaring the variable that will be used
			double pricePerPound;
			double weightOunces;
			double weight;
			double totalPrice;
			
			// creates a scanner that allows the user to input values
			Scanner scan = new Scanner(System.in);
			
			// creates the getCurrencyInstance method used to display the dollar amount later on
			NumberFormat numForm = NumberFormat.getCurrencyInstance();
			
			// creates the DecimalFormat that is used to display the correct weight
			DecimalFormat fmt = new DecimalFormat ("#.##");
			
			// Beginning of the "Checkout Process
			System.out.println ("Welcome to the CS Deli!!! \n ");
			
			System.out.println ("Enter the price per pound of your item: ");
			pricePerPound = scan.nextDouble();
			
			System.out.println ("Enter the weight in ounces: ");
			weightOunces = scan.nextDouble();
			
			weight = weightOunces / OUNCES_PER_POUND;
			totalPrice = pricePerPound * weight;
			
			System.out.println ("The total price of your item is: "+totalPrice);
			System.out.println ();
			
			
			// Receipt printout
		System.out.println ("\t Here is your receipt!");
			
			System.out.println();
			System.out.println("\t *****CS DELI*****");
			System.out.println();
			System.out.println ("\t Unit Price: "+numForm.format(pricePerPound)+ " per pound.");
			System.out.println ("\t Weight : "+ fmt.format(weight)+ " pounds");
			System.out.println ();
			System.out.println ("\t Total Price: "+numForm.format(totalPrice));
		}
}
