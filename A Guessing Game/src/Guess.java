// *****************************************************************
// Conner Calhoun
// Guess.java
// Would you like to play a game?
// *****************************************************************
import java.util.Scanner;
import java.util.Random;

public class Guess 
{
	public static void main (String[] args)
	{
		int numToGuess; //Number the user tries to guess
		int guess; //The user's guess
		int counter = 0;
		int highCounter = 0;
		int lowCounter = 0;
		String gTNW;
		
		Scanner scan = new Scanner(System.in);
		Random generator = new Random();
								
								/* System.out.println ("Would you like to play Global Thermonuclear War (y/n)? ");
								gTNW = scan.nextLine();
								
								// WarGames
								while (gTNW.equals("y"))
								{
									System.out.println ("Sorry, no point in blowing up the world today.");
									gTNW = "n";
								} */
		
		// Creates a random number generator 
		numToGuess = generator.nextInt(10) + 1;
		
		// Guessing Game
		System.out.println("Ok, we'll play a guessing game instead. Guess a number from 1 to 10: ");
		guess = scan.nextInt();
		
		// If guess isn't right
		while (numToGuess != guess)
		{
			if (numToGuess < guess)
			{
				System.out.println ("Your guess is too high!");
				highCounter++;
			}
			else if (numToGuess > guess)
				{
					System.out.println ("Your guess is too low!");
					lowCounter++;
				}
			
			System.out.println ("Guess Again! ");
			guess = scan.nextInt();
			
			counter++;
			
		}
		
		// If Guess is right
		System.out.println ("Good Job, you can guess a number! \nIt took you " + (counter + 1) + " guesses to get the correct number.");
		System.out.println ("You guessed high " + highCounter + " time/s! \nYour guessed low "+lowCounter+" time/s!");
		
		
	}
}
