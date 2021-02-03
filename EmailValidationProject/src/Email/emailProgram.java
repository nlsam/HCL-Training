package Email;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class emailProgram {

	
	static String emailDatabase[]= {"nehemiah.sam@hcl.com", "jim@yahoo.com", "sam123@gmail.com",
                "lennox1998@outlook.com", "smith1@gmail.com", "josh789@yahoo.com", "carter@aol.com"}; // Email array
	static String nameDatabase[]= {"Nehemiah","Jim", "Sam", "Lennox", "Smith", "Josh", "Carter"}; // Name array
	
	public static int searchEmail(String email) {
			int a=8;
			for(int i=0;i<7;i++) { // for loop for searching
				if(email.equals(emailDatabase[i])==true) { // if statement for testing for a match
					a=i;// sets index to output
      				break;// stops once index is found
				}
			}
			return a;// output for main method
	}
	
	public static int validateEmail(String email) {
		int test;
		final String regex = "(@[a-z]{3,}.com)"; // lines 26-29 for regular expression
		
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(email);

		if (matcher.find()) {
		    System.out.println("Your email is valid"); 
		    test=1; // output 1 if it match
		    
	}
		else {
			System.out.println("Your email is not valid");
			test=0; // output 0 for no match
		}
		return test; // returns output
	}

	public static void main(String[] args) {
		int result=8;
		int p;
		Scanner email= new Scanner(System.in);
		System.out.println("Enter a email address to confirm it is in the database"); // Prompts user
		System.out.println("The criteria for a vaild email address is containing @, .com, and three or more letters betweeen."); // Shows criteria
	    String emailInput=email.nextLine(); // Takes user input
	    p=validateEmail(emailInput); // Tests for valid email
	    if(p==1) {
	    result=searchEmail(emailInput); // Search in array 
	    if (result!=8) {
	    	System.out.println("Your email was found and it belongs to " + nameDatabase[result]);// Gives user result
	    }
	    else {
	    	System.out.println("Your email was not found in the database");// Gives user result
	    }

	}
	}
}


