// ************************************************************
// Conner Calhoun
// Roshambo.java
// Plays rock, paper, scissors with the user.
// ************************************************************
import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class Roshambo
{
	public static void main (String [] args)
	{
		String personPlay;
		String computerPlay = null;
		int computerInt;
		
		Scanner scan = new Scanner (System.in);
		Random generator = new Random();
		
		System.out.println ("Enter your play (R, P, or S): ");
		personPlay = scan.nextLine();
		personPlay = personPlay.toUpperCase();
		
		while (!personPlay.equals("R") && !personPlay.equals("P") && !personPlay.equals("S"))
		{
			System.out.println ("Try again: ");
			personPlay = scan.nextLine();
			personPlay = personPlay.toUpperCase();	
		}
		
		computerInt = generator.nextInt(3);
		
		switch (computerInt)
		{
			case 0: computerPlay = "R";
				break;
			case 1: computerPlay = "P";
				break;
			case 2: computerPlay = "S";
				break;
		}
		
		System.out.println ("You chose " +personPlay+ ".");
		System.out.println ("The computer chose "+computerPlay+".");
		
		if (personPlay.equals(computerPlay))
			System.out.println("It's a tie!");
		
			else if (personPlay.equals("R"))
				if (computerPlay.equals("S"))
					System.out.println ("Rock crushes scissors! You WIN!");
				
				 if (personPlay.equals("R"))
					if (computerPlay.equals("P"))
						System.out.println ("Paper beats rock, we're sorry!");
					
				    if (personPlay.equals("P"))
						if (computerPlay.equals("R"))
							System.out.println("Paper covers rock, you WIN!");
						
						if (personPlay.equals("P"))
							if (computerPlay.equals("S"))
								System.out.println("Scissors cuts paper, you lose!");
							
						    if (personPlay.equals("S"))
								if (computerPlay.equals("R"))
									System.out.println ("Rock beats scissors, sorry!");
								
							    if (personPlay.equals("S"))
									if (computerPlay.equals("P"))
										System.out.println ("Scissors slices paper! You WIN!");
	}
}

