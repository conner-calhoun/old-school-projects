//************************************************************
// Conner Calhoun
// Lab 3 
// DiceRoll.java
// Main method for rolling a pair of dice using the Die.java class
//************************************************************

public class DiceRoll 
{
	public static void main (String args[])
	{	
		Die dice;
		dice = new Die();

		// Prints the values of both dice, along with the sum.
		System.out.println("The number on the first die is: "+dice.returnD1());
		System.out.println("The number on the second die is: "+dice.returnD2());
		System.out.println("The sum total of the two dice is: "+dice.sum());	
	}
}
