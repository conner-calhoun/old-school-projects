// *******************************************************
// Conner Calhoun
// 
// Reverse.java
// Reverses a user input array on integers
// *******************************************************
import java.util.Scanner;
import java.util.Arrays;

public class Reverse 
{
	public static void main (String[] args)
	{
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Enter an integer that you wish to be the length of the array: ");
		int arrayLength = scan.nextInt();
		int[] array = new int[arrayLength];
		
		System.out.println("Now enter the values one at a time: ");
		
		
		// User input array
		for (int i=0; i<arrayLength; i++)
		{
			array[i]=scan.nextInt();
		}
		
		System.out.println("\nThis is the array you created: ");
		System.out.println (Arrays.toString(array));
		System.out.println("We will now reverse your array:");
		
		
		// Swaps places that are stored
		for (int i=0; i<arrayLength / 2; i++)
		{
			int newArray = array[i];
			array[i] = array[arrayLength - 1 - i];
			array[arrayLength-1-i] = newArray;
		}
		
		System.out.println (Arrays.toString(array));
		
	}
}
