// ******************************************************* 
// Conner Calhoun
// Account.java
//
// A bank account class with methods to deposit to, withdraw from,
// change the name on, charge a fee to, and print a summary of the account
//
// These Methods will be used in ManageAccounts.java.
// ******************************************************* 
import java.util.ArrayList;
import java.util.Scanner;
import java.text.NumberFormat;

public class Account 
{
	private double balance;
	private String name;
	private long acctNum; 
	private double amount;
	private int acctNum2;
	
	Scanner scan = new Scanner(System.in);
	NumberFormat money = NumberFormat.getCurrencyInstance();
	
	ArrayList<Double> trans = new ArrayList<Double>();
	
	// --------------------------------------------- 
	//Constructor -- initializes balance, owner, and account number 
	// --------------------------------------------
	public Account() 
	{
		System.out.println ("Create a new Account");
		System.out.println ("--------------------");
		
		System.out.println ("Enter the initial balance: ");
		balance = scan.nextInt();
		
		System.out.println("Enter the account owner: ");
		name = scan.next();
		
		System.out.println("Enter the account number: ");
		acctNum = scan.nextInt();
	}
	
	// --------------------------------------------
	// Checks to see if balance is sufficient for withdrawal.
	// If so, decrements balance by amount; if not, prints message.
	// --------------------------------------------
	public void withdraw() 
	{
		System.out.println ("Enter the amount you wish to withdraw (there will be a slight fee): ");
		amount = scan.nextInt();
		
		if (balance >= amount + amount * .05)
			balance -= (amount + amount * .05); // can also be written as balance = balance - amount \\
		else
			System.out.println("Insufficient funds"); 
		
		trans.add(balance);
		
		System.out.println();
	} 

	// --------------------------------------------
	// Adds deposit amount to balance. Chapter 4: Writing Classes 53
	// --------------------------------------------
	public void deposit() 
	{
		System.out.println("Enter the amount you wish to deposit: ");
		amount = scan.nextFloat();
		balance += amount; // can also be written as balance = balance + amount 
		
		trans.add(balance);
		
		System.out.println();
	}
	
	// --------------------------------------------
	// Returns balance.
	// --------------------------------------------
	public double getBalance() 
	{
		System.out.println ("The balance is: ");
		System.out.println(balance);
		System.out.println();
		return balance;
	}

	// --------------------------------------------
	// Returns a string containing the name, account number, and balance. 
	// --------------------------------------------
	public String toString() 
	{ 
		return " Account Name: " + name + "\n Account Number: " + acctNum + "\n Account Balance: " + money.format(balance);
	}

	// --------------------------------------------
	// Deducts $10 service fee //
	// --------------------------------------------
	public double chargeFee() 
	{ 
		double fee;
		fee = 10.0;
		balance -= fee;
		return balance;
	}

	// --------------------------------------------
	// Changes the name on the account
	// --------------------------------------------
	public String changeName() 
	{ 
		System.out.println("Enter the new name: ");
		name = scan.next();
		System.out.println("The new Account Name is "+name+".");
		System.out.println();
		return name;
	} 
	
	// --------------------------------------------
	// Creates a savings account with a new number
	// and half of the money from their checking
	// account
	// --------------------------------------------
	public String createSavings()
	{
		System.out.println("We will now set up a savings account for you.");
		balance = (balance * .5);
		System.out.println("Enter a new account number: ");
		acctNum2 = scan.nextInt();
		return "The balance of the savings account is: " + money.format(balance) + ". The account number is: " + acctNum2 + ". And the name is: " + name + ".";
	}
	
	public void printTrans()
	{
		System.out.println ("The list of transactions: "+trans);
	}
}
