import java.util.InputMismatchException;
import java.util.Scanner;

public class TreeMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean con = true;
		
		while(con) {
			
			int user = 0;
			try {
				System.out.println("Would you like to enter: \nInfix(1) \nPostFix(2) \nPrefix(3) \nQuit(4)");
				user = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Bad Input");
				con = true;
			}
			
			EquationBinaryTree ebt = new EquationBinaryTree();
			
			// Infix: ((a+(b*c))+(((d*e)+f)*g))
			// Postfix: abc*+de*f+g*+
			// Prefix: ++a*bc*+*defg
			
			if (user == 1) {
				System.out.println("Enter an infix equation:");
				scan.nextLine();
				String infix = scan.nextLine();
				ebt.populateFromInfix(infix);
	      		System.out.println("Infix: "+ebt.printInfix());
				System.out.println("PostFix: "+ebt.printPostfix());
				System.out.println("PreFix: "+ebt.printPrefix());
			}
			
			if (user == 2) {
				System.out.println("Enter a postfix equation:");
				scan.nextLine();
				String post = scan.nextLine();
				ebt.populateFromPostfix(post);
				System.out.println("PostFix: "+ebt.printPostfix());
	      		System.out.println("Infix: "+ebt.printInfix());
				System.out.println("PreFix: "+ebt.printPrefix());
			}
			
			if (user == 3) {
				System.out.println("Enter a prefix equation:");
				scan.nextLine();
				String pre = scan.nextLine();
				ebt.populateFromPrefix(pre);
				System.out.println("PreFix: "+ebt.printPrefix());
	      		System.out.println("Infix: "+ebt.printInfix());
				System.out.println("PostFix: "+ebt.printPostfix());
			}
			if (user >= 4 || user <= 0) {
				con = false;
			}
			
			System.out.println();
			
		}
		
		System.out.println("Thanks!");
		
	}

}
