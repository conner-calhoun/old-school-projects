// ****************************************************************
//  ReadingNumFile.java  
// 
//  Reads text file containing a name followed by a series of numbers, 
//  converts the text numbers to doubles, 
//  and prints the sum of the numbers text file
//
//  Uses fileNumbers.dat
// ****************************************************************

import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;

public class ReadingNumFile
{
	public static void main (String[] args) throws IOException
	{
		Scanner fileScan, lineScan;
		String fileName;
		String line;          //a line from the file
		String action, name;
		double number, sum;

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

			sum = 0;
			System.out.println(name);
			while (lineScan.hasNext())
		    	{
				action = lineScan.next();
				number = Double.parseDouble(action);
				sum +=number;
				System.out.print(action + " ");
	           }
			System.out.println ("   sum: " + sum);
           }	
   }
}
