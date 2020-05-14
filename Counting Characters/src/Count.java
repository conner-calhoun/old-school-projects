// ************************************************************
// Conner Calhoun 
// Count.java
//
//   This program reads in strings (phrases) and counts the
//   number of blank characters and certain other letters
//   in the phrase.
// ************************************************************
import java.util.Scanner;

public class Count 
{
	public static void main (String[] args)
	{
		String phrase; // a string of characters
		int countBlank; //the number of blanks (spaces) in the phrase 
		int length; // the length of the phrase
		char ch; // an individual character in the string
		int countA = 0;
		int countE = 0;
		int countS = 0;
		int countT = 0;
		
		Scanner scan = new Scanner (System.in);
		
		System.out.println ();
		System.out.println ("Character Counter");
		System.out.println ();
		
		System.out.print ("Enter a sentence or phrase: ");
		phrase = scan.nextLine();
		length = phrase.length();
		
		countBlank = 0;
		
		while (!phrase.equals("quit"))
		{
			
			for(int i = 0; i < length; i++)
			{
				ch = phrase.charAt(i);
				if(ch == ' ')
					countBlank++;
				
				switch (ch)
				{
					case 'A':
					case 'a': countA++;
								break;
					case 'E':
					case 'e': countE++;
								break;
					case 'S':
					case 's': countS++;
								break;
					case 'T':
					case 't': countT++;
								break;
				}
			}
		
			System.out.print ("Enter a sentence or phrase (or type quit to quit the program): ");
			phrase = scan.nextLine();
			length = phrase.length();
		}
		
		System.out.println ();
		System.out.println("The number of spaces equals " + countBlank);
		System.out.println("The number of A's equals " + countA);
		System.out.println("The number of E's equals " + countE);
		System.out.println("The number of S's " + countS);
		System.out.println("The number of T's " + countT);
		
	}
}
