// *****************************************************************
// Conner Calhoun
// *****************************************************************
import java.util.Scanner;

public class SwitchDemo 
{
    public static void main(String[] args) 
    {

    	int month;
    	Scanner scan = new Scanner (System.in);
        System.out.println("Enter the number for the corresponding month: ");
        month = scan.nextInt();
         
    	String monthString = null;
        String season = null;
    	
        switch (month) 
        {
            case 1:  monthString = "January";
            		 break;
            case 2:  monthString = "February";
            		 break;
            case 3:  monthString = "March";
            		 break;
            case 4:  monthString = "April";
            		 break;
            case 5:  monthString = "May";
            		 break;
            case 6:  monthString = "June";
            		 break;
            case 7:  monthString = "July";
            		 break;
            case 8:  monthString = "August";
            		 break;
            case 9:  monthString = "September";
            		 break;
            case 10: monthString = "October";
            		 break;
            case 11: monthString = "November";
            		 break;
            case 12: monthString = "December";
            		 break;
            default: monthString = "Invalid month";
                     break;
        }
        
        switch (month)
        {
	        case 1:
	        case 2:
	        case 12: season = "Winter";
	        		 break;
	        case 3:
	        case 4:
	        case 5:  season = "Spring";
	        		 break;
	        case 6:
	        case 7:
	        case 8:  season = "Summer";
	        		 break;
	        case 9:
	        case 10:
	        case 11: season = "Autumn";
	        		 break;
	        default: season = "Come on, you aren't that daft are you? There are only twelve months.";
	        		 break;
        }
        
        System.out.println(monthString);
        System.out.println(season);
    }   
}

