package com.hcl;
import java.util.Scanner;


public class Main {
	public static Directory key = new Directory();
	
	public static int userNumberInput() {
		Scanner input = new Scanner(System.in);
		int numberInput=input.nextInt();
		return numberInput;
	}
	public static String userStringInput() {
		Scanner input =new Scanner(System.in);
		String stringInput=input.nextLine();
		return stringInput;
	}
	public static void mainMenu() {
		System.out.println("Welcome to the Main Menu!");
		System.out.println("Enter the number corresponding to the menu selection");
		System.out.println("1. Sort the Directory \n2. Add, Delete, or Search \n3. Close application");
		int mainSelection=userNumberInput();
		switch(mainSelection) {
		case 1:
			Directory.sortFilesinList();
			break;
		case 2: 
			secondaryMenu();
			break;
		case 3:
			System.out.println("App closed!");
			break; 
		}
		
	}
	public static void secondaryMenu() {
		String fileName;
		System.out.println("Welcome to the Secondary Menu!");
		System.out.println("Enter the number corresponding to the menu selection");
		System.out.println("1. Add file \n2. Delete file \n3. Search for file \n4. Return to Main Menu");
		int secondarySelection=userNumberInput();
		switch(secondarySelection) {
		case 1:
			System.out.println("Enter file name to add to the directory");
			fileName=userStringInput();
			key.addFiletoList(fileName);
			break;
		case 2: 
			System.out.println("Enter file name to delete from the directory");
			fileName=userStringInput();
			key.deleteFilefromList(fileName);
		break;
		case 3:
			System.out.println("Enter file name to search to the directory");
			fileName=userStringInput();
			key.searchFilefromList(fileName);
			break;
		case 4:
			mainMenu();
			break;
		}
	}
	

	public static void main(String[] args) {
		System.out.println("Welcome to the Virtual Key Repository developed by Nehemiah Sam");
	     mainMenu();

	}

}