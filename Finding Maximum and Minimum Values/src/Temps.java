// ************************************************************
// Conner Calhoun
// Temps.java
//
// This program reads in a sequence of hourly temperature
// readings (beginning with midnight) and prints the maximum
// temperature (along with the hour, on a 24-hour clock, it
// occurred) and the minimum temperature (along with the hour
// it occurred).
// ************************************************************
import java.util.Scanner;

public class Temps 
{
	public static void main (String[] args)
	{
		final int HOURS_PER_DAY = 24;
		
		int temp;   // a temperature reading
		
		Scanner scan = new Scanner(System.in);
		
		// print program heading
		System.out.println ();
		System.out.println ("Temperature Readings for 24 Hour Period");
		System.out.println ();
		
		int maxTemp = -1000;
		int minTemp = 1000;
		int maxHour = 0;
		int minHour = 0;
		
		for (int hour = 0; hour < HOURS_PER_DAY; hour++)
		{
			System.out.print ("Enter the temperature reading at " + hour + " hours: ");
			temp = scan.nextInt();
			
			if(temp > maxTemp)
			{
				maxTemp = temp;
				maxHour = hour;
			}
			
			if(temp < minTemp)
			{
				minTemp = temp;
				minHour = hour;
			}
			
		}
		System.out.println();
		System.out.println ("The maximum temperature is "+maxTemp+ "; this temperature was recorded at "+maxHour+" hours.");
		System.out.println ("The minimum temperature is "+minTemp+ "; this temperature was recorded at "+minHour+" hours.");
	}
}