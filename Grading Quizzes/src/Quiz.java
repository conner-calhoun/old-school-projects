// *****************************************************************
// Conner Calhoun
//
// Quiz.java
// User input Student answers and answer key to grade a quiz.
// *****************************************************************
import java.util.Scanner;

public class Quiz 
{
	public static void main (String[] args)
	{
		
		String moreGrading = "y";
		
		Scanner scan = new Scanner (System.in);
		System.out.println ("How many questions are on the quiz? Enter Here: ");			
		int numQuestions = scan.nextInt();
		int[] key = new int[numQuestions];
		
		double correctCounter = 0;
		
		System.out.println ("Enter the correct answers one at a time.");
			
			for (int i=0; i<numQuestions;i++)
			{
				key[i] = scan.nextInt();
			}
			
			while (moreGrading.equalsIgnoreCase("y"))
			{
			
				correctCounter = 0;
				
				Scanner scanLine = new Scanner (System.in);
				
				System.out.println ("Enter the student's answers one at a time.");
				
				for (int i=0; i<numQuestions;i++)
				{
					int answer = scan.nextInt();
					
					if (answer == key[i])
					{
						//System.out.println("The answer is correct.");
						correctCounter++;
					}
				}
				
				System.out.println ("\nThe number of correct answers is: "+correctCounter+".");
				System.out.println ("\nThe percent correct is: "+((correctCounter/numQuestions)*100)+"%.");
			
				System.out.println ("\nDo you have more quizzes to grade? (y/n)");
				moreGrading = scanLine.nextLine();
				
			}
			
			
		System.out.println("Thank you for grading!");
		
	}
}
