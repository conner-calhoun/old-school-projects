//*********************************************
// Conner Calhoun
// Project 1
// 
// Project1.java 
// 
// Converts time
// Seconds to hours, minutes and seconds,
// and hours, minutes. and seconds to seconds
//*********************************************

import java.util.Scanner;

public class Project1 
{
	public static void main (String[] args)
	{
		
		System.out.println ("The following program will convert an input hours, minute, and seconds into seconds.");
		System.out.println ();
		
	// The number of hours the user inputs	
	int hour;
		Scanner scanh = new Scanner(System.in);
			System.out.print ("Enter hours:");
		hour = scanh.nextInt ();
		System.out.println ();
		
	// The number of minutes the user inputs
	int min;
		Scanner scanm = new Scanner(System.in);
			System.out.print ("Enter minutes:");
		min = scanm.nextInt ();
		System.out.println ();
		
	// The number of seconds the user inputs
	int sec;
		Scanner scans = new Scanner(System.in);
			System.out.print ("Enter seconds:");
		sec = scans.nextInt ();
	System.out.println ();
	
	// Conversion of hours to seconds
	int hourtosec;	
		hourtosec = hour * 3600;
	
	// Conversion of minutes to seconds
	int mintosec;
		mintosec = min * 60;
	
	// Total time in seconds
	int TimeInSec;
		TimeInSec = hourtosec + mintosec + sec;
		
		System.out.println ("The total time in seconds is " + TimeInSec);
		System.out.println ();
		
		System.out.println ("The following will convert the input seconds into hours, minutes, and seconds.");
		System.out.println ();
		
	int sec2;
		Scanner scans1 = new Scanner(System.in);
			System.out.print ("Enter seconds:");
		sec2 = scans1.nextInt ();
		
		int hour2;
		int rhour2;
			hour2 = sec2 / 3600;
			rhour2 = sec2 % 3600; 
		
		int min2;
		int rmin2;
			min2 = rhour2 / 60;
			rmin2 = rhour2 % 60;
			
		int sec3;
			sec3 = rmin2 % 60;
		
		System.out.println ("The total time is " + hour2 + " hours " + min2 + 
		" minutes and " + sec3 + " seconds");
		
		
	}
}

