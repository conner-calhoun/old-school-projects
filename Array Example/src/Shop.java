// ***************************************************************
//   Shop.java
//   Conner Calhoun
//   Lab 5
//   Uses the Item class to create items and add them to a shopping
//   cart stored in an ArrayList.
// ***************************************************************

import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Scanner;

public class Shop
{
    public static void main (String[] args)
    {
	ArrayList<Item> cart = new ArrayList<Item>();

	Item item;
	String itemName;
	double itemPrice;
	int quantity;
	double totalPrice;

	Scanner scan = new Scanner (System.in);

	String keepShopping = "y";

	System.out.println();
	System.out.print ("Do you want to shop (y/n)? ");
	// scan.nextLine();
	keepShopping = scan.nextLine();

	while (keepShopping.equalsIgnoreCase("y"))
     {
		System.out.print ("Enter the name of the item: "); 
		itemName = scan.nextLine();

		System.out.print ("Enter the unit price: ");
		itemPrice = scan.nextDouble();

		System.out.print ("Enter the quantity: ");
		quantity = scan.nextInt();

		// *** create a new item and add it to the cart
		item = new Item (itemName, itemPrice, quantity);
		cart.add(item);

		// *** print the contents of the cart object
		
		System.out.println();
		System.out.print ("Continue shopping (y/n)? ");
		scan.nextLine();
		keepShopping = scan.nextLine();
	    }
	
	totalPrice = 0;
	System.out.println ("\nCurrent Cart");
	for (int i = 0; i < cart.size(); i++)
	    {
		item = (Item)cart.get(i);
		System.out.println (item);
		totalPrice += item.getPrice()*item.getQuantity();
	    }

	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	System.out.println ("Total Price: " + 	fmt.format(totalPrice));

    }
}

