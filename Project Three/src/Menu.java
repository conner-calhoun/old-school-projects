// ************************************************************************
// ConnerCalhoun
// 
// Menu.java
// Class for use in ManageAccounts.java
// ************************************************************************
import java.util.Scanner;

public class Menu 
{
	Scanner scan = new Scanner(System.in);
	private int choice = 0;
	Account checking = new Account();
		
	// Constructor
	public Menu()
	{
		
	}
	
	public void getMenu()
	{
		System.out.println("Menu");
		System.out.println("-------------------------");
		System.out.println("1. Deposit Money");
		System.out.println("2. Withdraw Money");
		System.out.println("3. Return Balance");
		System.out.println("4. Change Account Name");
		System.out.println("0. To Quit");
		System.out.println("-------------------------");
	}
	
	// Gets the users menu choice
	public void getChoice()
	{
		System.out.println ("Enter your choice: ");
		choice = scan.nextInt();
		// System.out.println (choice);
	}
	
	public void doAction()
	{
		switch (choice)
		{
			case 0: System.out.println ("Thanks!");
				break;
			case 1: checking.deposit();
				break;
			case 2: checking.withdraw();
				break;
			case 3: checking.getBalance();
				break;
			case 4: checking.changeName();
				break;
			default: System.out.println("Invalid Option");
				break;
		}
		
		if (choice != 0)
		{
			getMenu();
			getChoice();
			doAction();
		}
		
	}
	
	public void returnSummary()
	{
		System.out.println ("Here is a summary: \n" + checking.toString());
		
	}
	
}
