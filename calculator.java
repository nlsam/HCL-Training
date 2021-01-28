package arithmeticCalculator;
import java.util.Scanner;

public class calculator {
	
	static void Addition(float a, float b) {
		float result;
		result= a+b;
		System.out.println("Your result is " + result);
	}
	static void Subtraction(float a, float b) {
		float result;
		result= a-b;
		System.out.println("Your result is " + result);
	}
	static void Multiplication(float a, float b) {
		float result;
		result= a*b;
		System.out.println("Your result is " + result);
	}
	static void Division(float a, float b) {
		float result;
		result= a/b;
		System.out.println("Your result is " + result);
	}
	
	
		public static void main(String[] args) {
		    Scanner input = new Scanner(System.in); 
		    System.out.println("Welcome to Nehemiah Sam's Arithmetic Calculator");
		    System.out.println("Enter 1 for addition, 2 for subtraction,3 for multiplication, 4 for division");
		    int expression= input.nextInt();
            System.out.println("Great! Please your first number for the calculation");
            float numberOne=input.nextFloat();
            System.out.println("Great! Please your second number for the calculation");
            float numberSecond=input.nextFloat();
            switch(expression) {
            case 1:
            	Addition(numberOne,numberSecond);
            	break;
            case 2:
            	Subtraction(numberOne,numberSecond);
            	break;
            case 3:
            	Multiplication(numberOne,numberSecond);
            	break;
            case 4: 
            	Division(numberOne,numberSecond);
               	break;
            }
	}

}
