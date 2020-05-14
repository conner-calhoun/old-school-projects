//************************************************************
// Conner Calhoun
// Lab 3 
// Die.java
// Class used to create method for rolling a die used in DiceRoll.java
//************************************************************
public class Die 
{
	private int die1;
	private int die2;
	
	
	public Die()
	{
		roll();
	}
	
	// Rolls both die to generate a random number for each
	public void roll()
	{
		die1 = (int)(Math.random()*6) +1;
		die2 = (int)(Math.random()*6) +1;
	}
	
	// Returns the value of die1
	public int returnD1()
	{
		return die1;
	}
	
	// returns the value of die2
	public int returnD2()
	{
		return die2;
	}
	
	// gets the sum of the two dice
	public int sum()
	{
		return die1 + die2;
	}
	
}
