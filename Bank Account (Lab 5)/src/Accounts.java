// ******************************************************* 
// Conner Calhoun
// Accounts.java
//
// A bank account class with methods to deposit to, withdraw from,
// change the name on, charge a fee to, and print a summary of the account
//
// These Methods will be used in ManageAccounts.java.
// ******************************************************* 
public class Accounts 
{
	private double balance;
	private String name;
	private String acctNum; 
	
	// --------------------------------------------- 
	//Constructor -- initializes balance, owner, and account number 
	// --------------------------------------------
	public Accounts(String owner, String number, double initBal) 
	{
		balance = initBal;
		name = owner;
		acctNum = number; 
	}
	
	// --------------------------------------------
	// Checks to see if balance is sufficient for withdrawal.
	// If so, decrements balance by amount; if not, prints message.
	// --------------------------------------------
	public void withdraw(double amount) 
	{
		if (balance >= amount)
			balance -= amount; // can also be written as balance = balance - amount \\
		else
			System.out.println("Insufficient funds"); 
	} 

	// --------------------------------------------
	// Adds deposit amount to balance. Chapter 4: Writing Classes 53
	// --------------------------------------------
	public void deposit(double amount) 
	{
		balance += amount; // can also be written as balance = balance + amount 
	}
	
	// --------------------------------------------
	// Returns balance.
	// --------------------------------------------
	public double getBalance() 
	{
		return balance;
	}

	// --------------------------------------------
	// Returns a string containing the name, account number, and balance. 
	// --------------------------------------------
	public String toString() 
	{ 
		return "Name: " + name + " Account: " + acctNum + " Balance: " + balance;
	}

	// --------------------------------------------
	// Deducts $10 service fee //
	// --------------------------------------------
	public void chargeFee() 
	{ 
		double fee;
		fee = 10.0;
		balance -= fee;
	}

	// --------------------------------------------
	// Changes the name on the account
	// --------------------------------------------
	public void changeName(String newName) 
	{ 
		name = newName;
	} 
}