import java.io.*;
import java.io.IOException;
import java.util.Scanner;
// import java.text.DecimalFormat;  // NOT NEEDED

// ************************************************************ 
// Conner Calhoun
// ManageAccounts.java
//
// Use Account class to create and manage Sally and Joe's
// bank accounts
// ************************************************************ 
public class ManageAccounts 
{
	public static void main(String[] args) throws IOException
	{
		Accounts acct;
		Scanner fileScan, lineScan;
		String fileName;
		String line;          //a line from the file
		String name=null, balanceStr;
		String acctNum = null;
		// double number, sum; NOT NEEDED
		double balance = 0;
		String amountStr;
		double amount;

		Scanner scan = new Scanner (System.in);
		System.out.print ("Enter the name of the input file: ");
		fileName = scan.nextLine();
		fileScan = new Scanner (new File(fileName));

		// Read and process each line of the file
		while (fileScan.hasNext())
		{
			line = fileScan.nextLine();
			lineScan = new Scanner(line);
			lineScan.useDelimiter(",");
			
			name = lineScan.next();
			acctNum = lineScan.next();
			balanceStr = lineScan.next();
			balance = Double.parseDouble(balanceStr);	
			acct = new Accounts(name, acctNum, balance);
			System.out.println("Name: " + name);
			System.out.println("Current Balance: " + balance);
			System.out.println ("Account Number: " + acctNum);
			
			while (lineScan.hasNext())
		    	{
					String action = lineScan.next();
					amountStr = lineScan.next();
					// System.out.println (action);   // FOR DEBUGGING
					// System.out.println (amountStr);    // FOR DEBUGGING
					amount = Double.parseDouble(amountStr);
					// System.out.println ("balance " + balance);   // FOR DEBUGGING
					
					if (action.equals("d"))
					{
						//System.out.println ("The action is deposit.");  // FDB
						//System.out.println ("The amount of "+ amount +" will be deposited.");   // FDB
						acct.deposit(amount);
					}
					else if (action.equals("w"))
					{
						//System.out.println ("The action is withdraw.");     // FDB
						//System.out.println ("The amount of "+ amount +" will be withdrawn.");    // FDB
						acct.withdraw(amount);
					}
			
		    	}
			System.out.println("Final Balance: "+ acct.getBalance());
			System.out.println();
           }	
   }
}
