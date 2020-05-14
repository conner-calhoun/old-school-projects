// *****************************************************
// Conner Calhoun
// Lab 4
// TestNames.java
// Uses Name.java to create two "names" and list out certain details
// *****************************************************
public class TestNames 
{
	public static void main (String[] args)
	{
		Name name1, name2;
		
		// Creates two objects, name 1 and name 2 and assign first, middle, and last names
		name1 = new Name ("Billy", "Joe", "Bob");
		name2 = new Name ("Mary", "Jane", "Watson");
			
		// prints the first, middle, and last names of name1, and name2
		System.out.print("Name 1: ");
		System.out.println (name1.firstMiddleLast());
		System.out.print("Name 2: ");
		System.out.println (name2.firstMiddleLast());
		System.out.println();
		
		// prints the last, middle, and first names of name1, and name2
		System.out.print("Name 1: ");
		System.out.println (name1.lastFirstMiddle());
		System.out.print("Name 2: ");
		System.out.println (name2.lastFirstMiddle());
		System.out.println();
		
		// prints the initials from name1, and name2
		System.out.println ("Name 1 Initials: " + name1.initials());
		System.out.println ("Name 2 Initials: " + name2.initials());
		System.out.println();
		
		// prints the length of name1, and name2
		System.out.println ("Name 1 Length: " + name1.length());
		System.out.println ("Name 2 Length: " + name2.length());
		System.out.println ();
		
		// are the names the same?
		System.out.println ("Are the names the same (true/false): " + name1.equals(name2));
		
	}
}
