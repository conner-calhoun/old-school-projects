// **************************************************************** 
// Conner Calhoun 
//
// BaseballStats.java
//
// Reads baseball data in from a comma delimited file. Each line 
// of the file contains a name followed by a list of symbols
// indicating the result of each at bat: h for hit, o for out,
// w for walk, s for sacrifice. Statistics are computed and
// printed for each player.
// ****************************************************************
import java.util.Scanner;
import java.io.*;

public class BaseballStats
{
	//-------------------------------------------------
	//  Reads baseball stats from a file and counts
    //  total hits, outs, walks, and sacrifice flies
    //  for each player.
    //-------------------------------------------------
	
	public static void main (String[] args) throws IOException
	{
		Scanner fileScan, lineScan;
		String fileName;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print ("Enter the name of the input file: ");
		fileName = scan.nextLine();
		
		fileScan = new Scanner(new File(fileName));
		
		// Read and process each line of the file
		while (fileScan.hasNext())
		{
			String line = fileScan.nextLine();
			lineScan = new Scanner(line);
			lineScan.useDelimiter(",");
			String name = lineScan.next();
			
			double hits = 0;
			double outs = 0;
			int walks = 0;
			int sacrifices = 0;
			double total;
			double battingAverage;
			
			System.out.println ("Player Name: " + name);
			
			
			 while (lineScan.hasNext())
			{
				
				String stats = lineScan.next();
				
				for (int i=0; i<stats.length(); i++)
				{
					if (stats.charAt(i) == 'h')
					{
						hits++;
					}
					else
						if (stats.charAt(i) == 'o')
						{
							outs++;
						}
						else
							if (stats.charAt(i) == 'w')
							{
								walks++;
							}
							else
								if (stats.charAt(i) == 's')
								{
									sacrifices++;
								}	
				}			
			}
			
			total = hits + outs;
			battingAverage = hits / total; 
			System.out.println ("Hits: " + hits + "\nOuts: "+ outs+ "\nWalks: "+walks+"\nSacrifices: "+sacrifices + "\nBatting Average: "+battingAverage);
			System.out.println();
			
		}		 
	}
}
