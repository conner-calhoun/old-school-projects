import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class NameTreeMap {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TreeMap<String, Integer> nametree = new TreeMap<String,Integer>();
		System.out.println("This program takes in a number of names and puts them into a treemap.");
		boolean cont = true;
		while(cont)
		{
			System.out.print("Enter a name: ");
			String name = scan.nextLine();
			int v = v(name);
			
			System.out.println("Adding "+name+" to tree map...");
			
			nametree.put(name, v);
			
			System.out.print("Would you like to continue? (y/n): ");
			String r = scan.nextLine();
			switch(r) {
				case "y":
					cont = true;
					break;
				case "n":
					System.out.println("\nFinal Tree Map:");
					printMap(nametree);
					System.out.println("Thanks, bye!");
					cont = false;
					break;
				default:
					System.out.println("\nFinal Tree Map:");
					printMap(nametree);
					System.out.println("Bad response, quitting program.");
					cont = false;
					break;
			}
		}
		
	}
	
	public static void printMap(TreeMap<String, Integer> tree) {
		for(String s : tree.keySet())
		{
			System.out.println(s + " : " + tree.get(s));
		}
	}
	
	public static int v(String s) {
		int value = 0;
		
		for(int i=0; i<s.length(); i++) {
			switch(s.charAt(i)) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
				// case "sometimes y"
					value += 1;
					break;
				default:
			}
		}
		return value;
	}
}

