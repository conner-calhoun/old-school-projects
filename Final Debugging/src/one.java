import java.util.*;
import java.text.*;
public class one 
	{
	public static void main (String[] args)
	{
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of the input you want to enter: ");
		int size = input.nextInt();
		int numberArray[] = new int[size];
		int sum=0;
		System.out.print("Enter "+ size +" numbers: ");
		for(int i=0; i<size; i++)
		{
		numberArray[i]=input.nextInt();
		sum = sum + numberArray[i];
		}
		System.out.print("The sum of the numbers is: " + sum);
		}

	}
	

