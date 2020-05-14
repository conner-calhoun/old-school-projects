// *******************************************************
// Conner Calhoun
//
// AverageGrades.java
// Reads names and grades from a .dat file and calculates the average of those grades.
// *******************************************************
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;
import java.io.IOException;

public class AverageGrades 
{
	public static void main (String[] args) throws IOException
	{
		Scanner scan = new Scanner (System.in);
		
		Scanner fileScan;
		Scanner lineScan;
		String line;
		String name = null;
		String gradeStr;
		String averageStr;
		double grade;
		double sum = 0;
		double average = 0;
		
		fileScan = new Scanner (new File("grades.dat"));
		String [] names = new String [10];
		String [] grades = new String [10];
		
		line = fileScan.nextLine();
		lineScan = new Scanner(line);
		lineScan.useDelimiter(",");
		
		int i=0;
		
		while (fileScan.hasNextLine())
		{
			line = fileScan.nextLine();
			lineScan = new Scanner(line);
			lineScan.useDelimiter(",");
			
			name = lineScan.next();
			
			names[i] = name;
			
			while (lineScan.hasNext())
			{
				gradeStr = lineScan.next();
				
				grade = Double.parseDouble(gradeStr);
				
				sum += grade;
				
			}
			
			average = sum/3;
			averageStr = Double.toString(average);
			grades[i] = averageStr;
			
			i++;
			
			sum = 0;
		}
		
		/*
		System.out.println("Here is the array of names: ");
		System.out.println (Arrays.toString(names));
		System.out.println("Here is the array of averages: ");
		System.out.println (Arrays.toString(grades));
		*/
		
		System.out.println (Arrays.toString(names));  // this is just so you know which names I used.
		
		System.out.println("Enter the name of a student: ");
		String student = scan.nextLine();
		
		for (i=0;i<10;i++)
		{
			if(names[i].equals(student))
				System.out.println("The student exists! \nName: "+student+".\nAverage: "+grades[i]);
		}
		System.out.println("Thank you for checking the records! (If no record returned, no record on collection)");
	}
}
