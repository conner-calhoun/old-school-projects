// ************************************************************ 
// ManageAccounts.java 
// 
// Conner Calhoun
//
// Use Account class to create and manage bank accounts 
// ************************************************************ 
public class ManageAccounts
{ 
	public static void main(String[] args) 
	{  
		Menu choice;
		
		choice = new Menu();
		System.out.println();
	
		choice.getMenu();
		choice.getChoice();
		choice.doAction();
		choice.returnSummary();
		
	} 
}

