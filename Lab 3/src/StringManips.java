// ***************************************************************
// Conner Calhoun
//
// StringManips.java
//
//   Test several methods for manipulating String objects
// ***************************************************************
import java.util.Scanner;

public class StringManips
{
	public static void main (String[] args)
	{
		String phrase = new String ("This is a String test.");
		int phraseLength;
		int middleIndex;
		String firstHalf;
		String secondHalf; 
		String switchedPhrase; 
		String middle3;
		String city;
		String state;
		
		phraseLength = phrase.length();
		middleIndex = phraseLength / 2;	
		middle3 = phrase.substring(middleIndex - 1, middleIndex + 1);  
		
		firstHalf = phrase.substring(0,middleIndex);
		secondHalf = phrase.substring(middleIndex, phraseLength);

		switchedPhrase = secondHalf.concat(firstHalf);
			switchedPhrase = phrase.replace(' ','*');
		
		Scanner City = new Scanner(System.in);
		System.out.println ("Enter your home city: ");
		city = City.nextLine ();
		
		Scanner State = new Scanner(System.in);
		System.out.println ("Enter your home state: ");
		state = State.nextLine ();
		
			city = city.toLowerCase();
			state = state.toUpperCase();
		
		System.out.println();
		System.out.println (state + city + state);
		
		System.out.println();
		System.out.println ("Original phrase: " + phrase);
		System.out.println ("Length of the phrase: " + phraseLength +
		" characters");
		System.out.println ("Index of the middle: " + middleIndex);
		System.out.println ("Character at the middle index: " +
		phrase.charAt(middleIndex));
		System.out.println ("Switched phrase: " + switchedPhrase);
		System.out.println ("These are the middle three characters: " + middle3);
		System.out.println();
		
	}
}