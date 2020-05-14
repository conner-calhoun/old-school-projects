import java.util.Scanner;
public class Number 
{
	public static void main (String[] args)
	{
		int num;
		Scanner scan = new Scanner(System.in);
		
		System.out.print ("Enter a number: ");
		num = scan.nextInt ();
		
		System.out.println ("Is " +num+ " your number?");	
	}
}
