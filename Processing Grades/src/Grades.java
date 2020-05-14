// ******************************************************************
// Conner Calhoun
// Grades.java
// Reads a sequence of grades, computes average, number of passing,
// and number of failing.
// ******************************************************************
import java.util.Scanner;

public class Grades 
{
	public static void main (String[] args)
	{
		double grade;
		double sumOfGrades;
		int numStudents;
		int numPass;
		int numFail;
		
		Scanner scan = new Scanner (System.in);
		
		System.out.println ("\nGrade Processing Program\n");
		
		// initialization
		sumOfGrades = 0;
		numStudents = 0;
		numPass = 0;
		numFail = 0;
		
		// Read in the first grade
		System.out.println ("Enter the first student's grade: ");
		grade = scan.nextDouble();
		
		while (grade >= 0)
		{
			sumOfGrades += grade;
			numStudents ++;
			
			if (grade < 60)
				numFail++;
			else
				numPass++;
			
			System.out.println ("Enter the next grade (a negative number to quit): ");
			grade = scan.nextDouble();
		}
		
		if (numStudents > 0)
		{
			System.out.println ("\nGrade Summary: ");
			System.out.println ("Class Average: " + sumOfGrades/numStudents);
			System.out.println ("Number of Passing Grades: " + numPass);
			System.out.println ("Number of Failing Grades: " + numFail);
		}
		else
			System.out.println ("No grades processed.");
		
	}
}
