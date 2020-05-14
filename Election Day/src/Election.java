//***************************************************************
// Conner Calhoun
// Election.java
// This file contains a program that tallies the results of
// an election. It reads in the number of votes for each of
// two candidates in each of several precincts. It determines
// the total number of votes received by each candidate,the
// percent of votes received by each candidate, the number of
// precincts each candidate carries, and the
// maximum winning margin in a precinct.
//***************************************************************
import java.util.Scanner;

public class Election 
{
	public static void main (String[] args)
	{
		int votesForPolly; // number of votes for Polly in each precinct
		int votesForErnest;// number of votes for Ernest in each precinct
		int totalPolly;
		int totalErnest;
		int totalVotes;
		double percentPolly;
		double percentErnest;
		String response = null; // answer (y or n) to the "more precincts question"
		int forPolly;
		int forErnest;
		int tie;
		Scanner scan = new Scanner (System.in);
		
		System.out.println();
		System.out.println("Election Day Vote Counting Program");
		System.out.println();
			
		votesForPolly = 0;
		votesForErnest = 0;
		totalPolly = 0;
		totalErnest = 0;
		totalVotes = 0;
		percentPolly = 0;
		percentErnest = 0;
		forPolly = 0;
		forErnest = 0;
		tie = 0;
		
		System.out.println ("Are there any precincts to to report (y or n): ");
		response = scan.next();
			
		while (response.equalsIgnoreCase("y"))
			{
				System.out.println ("Enter the number of votes for Polly: ");
				votesForPolly = scan.nextInt();
				System.out.println("Enter the number of votes for Ernest: ");
				votesForErnest = scan.nextInt();
			
				totalPolly = totalPolly + votesForPolly;
				totalErnest = totalErnest + votesForErnest;
				
				totalVotes = totalVotes + votesForErnest +votesForPolly;
				
				System.out.println ("Are there more precincts to to report (y or n): ");
				response = scan.next();
			
				if(votesForPolly > votesForErnest)
					forPolly++;
					else if(votesForErnest > votesForPolly)
						forErnest++;
						else if(votesForPolly == votesForErnest)
							tie++;
			}
			
			if (response.equalsIgnoreCase("n"))
			{
				System.out.println();
				System.out.println("Thanks!");	
				System.out.println("The total number of votes for Polly equals " +totalPolly);
				System.out.println("The total number of votes for Ernest equals " +totalErnest); 
				
				percentPolly = (totalPolly * 100) / totalVotes;
				percentErnest = (totalErnest * 100) / totalVotes;
				
				System.out.println ("The percentage of votes Polly recieved equals "+percentPolly+"%");
				System.out.println ("The percentage of votes Ernest recieved equals "+percentErnest+"%");
				
				System.out.println ("The number of precincts Polly carried is " +forPolly);	
				System.out.println ("The number of precincts Ernest carried is " +forErnest);
				System.out.println ("The number of precincts with tied votes is " +tie);
			}

	}

}
