// ******************************************************************
// Conner Calhoun
// Dates.java
// Determines if a date is valid and if it is a leap year.
// ******************************************************************
import java.util.Scanner;

public class Dates 
{
	public static void main (String[] args)
	{
		int month, day, year; 						// user input integers
		int daysInMonth = 0; 						// number of days in month to read
		boolean monthValid = false, yearValid = false, dayValid = false;    // true if input from user is valid
		boolean leapYear = false; 					// true if the users year is a leap year
		
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Enter the month (number form): ");
		month = scan.nextInt();
		
		System.out.println("Enter the day (number form): ");
		day = scan.nextInt();
		
		System.out.println("Enter the year (number form): ");
		year = scan.nextInt();
		
		if (month >= 1 && month <= 12)
		{
			monthValid = true;
		}
		
		if (year >= 1000 && year <= 1999)
		{
			yearValid = true;
		}
		
		if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
		{
			leapYear = true;
		}
		
		switch (month)
		{
		case 1: daysInMonth = 31;
				break;
		case 2: if(leapYear == true)
			daysInMonth = 29;
				else daysInMonth = 28;
				break;
		case 3: daysInMonth = 31;
				break;
		case 4: daysInMonth = 30;
				break;
		case 5: daysInMonth = 31;
				break;
		case 6: daysInMonth = 30;
				break;
		case 7: daysInMonth = 31;
				break;
		case 8: daysInMonth = 31;
				break;
		case 9: daysInMonth = 30;
				break;
		case 10: daysInMonth = 31;
				break;
		case 11: daysInMonth = 30;
				break;
		case 12: daysInMonth = 31;
				break;		
		}
		
		if (day <= daysInMonth && day > 0)
			dayValid = true;
		
		if (dayValid == true && monthValid == true && yearValid == true)
		{
			System.out.println ("The date is valid.");
			if (leapYear == true)
				System.out.println ("This is a leap year.");
		}else
			System.out.println ("This date is not valid.");
		

	}
}
