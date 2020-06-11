import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Conner Calhoun
public class Lex {

	public static class Analyzer {
		
		private String expression;
		private String lexeme = "";
		private char nextChar;
		private int lexIndex; // This keeps track of where we are in the expression
		private String nextToken;
		private String charClass;
		
		// Set the expression, and convert that to a character array, 
		// as well as get the length of that array
		public Analyzer(String s) {
			this.expression = s;
			lexIndex = 0;
			
			printExpr(); // Just prints the expression
			
			getChar(); // gets The first character
			
			while(nextToken != "EOF") {
				lex();
			}
		}
		
		private void addChar() {
			if(lexeme.length() <= 98) {
				lexeme += Character.toString(nextChar);
			}
			else 
				System.out.println("Error - lexeme is too long... \n");
		}
		
		private void getChar() {
			if(lexIndex < expression.length()) {
				nextChar = expression.charAt(lexIndex);
				if (String.valueOf(nextChar) != "EOF") {
					if(Character.isLetter(nextChar))
						charClass = "LETTER";
					else if (Character.isDigit(nextChar))
						charClass = "DIGIT";
					else
						charClass = "UNKNOWN";
				}
			}
			else {
				nextChar = '?';
				charClass = "UNKNOWN";
			}
			lexIndex++;
		}
		
		private void getNonBlank() {
			lexeme = "";
			while (nextChar == ' ') {
				getChar();
			}
		}
		
		private String lookup(char c) {
			switch(c) {
			case '(':
				addChar();
				nextToken = "LEFT_PAREN";
				break;
			case ')':
				addChar();
				nextToken = "RIGHT_PAREN";
				break;
			case '+':
				addChar();
				nextToken = "ADD_OP";
				break;
			case '-':
				addChar();
				nextToken = "SUB_OP";
				break;
			case '*':
				addChar();
				nextToken = "MULT_OP";
				break;
			case '/':
				addChar();
				nextToken = "DIV_OP";
				break;
			case '=':
				addChar();
				nextToken = "EQUALS";
				break;
			default:
				addChar();
				nextToken = "EOF";
				break;
			}
			
			return nextToken;
		}
		
		// Prints the expression
		private void printExpr() {
			System.out.println("Your Expression: "+expression+"\n--------------------------------------------------");
		}
		
		private String lex() {
			getNonBlank();
			switch (charClass) {
			case "LETTER":
				addChar();
				getChar();
				while (charClass == "LETTER" || charClass == "DIGIT") {
					addChar();
					getChar();
				}
				nextToken = "IDENT";
				break;
			case "DIGIT":
				addChar();
				getChar();
				while (charClass == "DIGIT") {
					addChar();
					getChar();
				}
				nextToken = "INT_LIT";
				break;
			case "UNKNOWN":
				lookup(nextChar);
				getChar();
				break;
			case "EOF":
				nextToken = "EOF";
				lexeme = "EOF";
				break;
			}
			
			if (nextToken == "EOF") {
				System.out.println("Next token is: "+nextToken+", Next lexeme is EOF\n");
			}
			else
				System.out.println("Next token is: "+nextToken+", Next lexeme is "+lexeme);
			return nextToken;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		String anote = "----------------------";
		System.out.println("\n"+anote+"Lexical Analyzer"+anote+"\n");
		
		String filename = ("src/expr.txt");
		String line = null;
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			while((line = br.readLine()) != null) {
				
				// line here is equal to one line of the file.
				Analyzer lyzer = new Analyzer(line); // All you have to do is create the 
				// analyzer object. It takes a single line of code.
				
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
