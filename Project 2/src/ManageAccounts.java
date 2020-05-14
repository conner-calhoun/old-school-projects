// ************************************************************ 
// ManageAccounts.java 
// 
// Conner Calhoun
//
// Use Account class to create and manage bank accounts 
// ************************************************************ 
import java.text.NumberFormat;

public class ManageAccounts
{ 
	public static void main(String[] args) 
	{ 
		Account checking; 
		int MAX250 = 250;
		
		NumberFormat money = NumberFormat.getCurrencyInstance();
		
	//create checking using input from the user (create a method to accomplish this)
		checking = new Account();
		
	//ask user for an amount and then deposit this amount to the account
		System.out.println ("Enter the amount you would wish to deposit: ");
		checking.deposit();
		
		System.out.println();
		
	//print the new balance for the account
		System.out.println("The new balance for your account is: " + money.format(checking.getBalance()));
		System.out.println();
		
	//ask user for an amount and then withdraw this amount and the withdrawal fee from the account
    // (you will need to create a method to calculate a 5% withdrawal fee)
		System.out.println("Enter the amount you wish to withdraw (you will be charged a 5% withdrawal fee): ");
		checking.withdraw();
		
    //print the new balance for the account
		System.out.println("The new balance for your account is: " + money.format(checking.getBalance()));
		System.out.println();
		
    // subtract the service charge from the account if the balance is below $250
		System.out.println("We will now subtract the service charge from your account if your account contains less than $250.");
		if (checking.getBalance() < MAX250);
			checking.chargeFee();
		System.out.println();
		System.out.println ("The new balance for your account is: " + money.format(checking.getBalance()));
		
    //ask the user for his/her new name and then change the name on the account 
		System.out.println();
		System.out.println("Enter the new name for the account: ");
		checking.changeName();
		System.out.println("The new account name is: " + checking.changeName());
		System.out.println();
		
    //print summary for the account
		System.out.println("Here is your account summary:");
		System.out.println("-----------------------------");
		System.out.println(checking.toString());
		System.out.println();
		
    //create a savings account using the name on the checking account, a new account number, and half of the money in the checking account.
		System.out.println(checking.createSavings());
		System.out.println();
		
    //print summary for the new account
		System.out.println("Here is your account summary:");
		System.out.println("-----------------------------");
		System.out.println(checking.toString());
		

	} 
}

