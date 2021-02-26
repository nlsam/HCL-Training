package com.hcl;

import java.util.Scanner;

public class Main {
	public static Directory key = new Directory();

	public static int userNumberInput() {
		Scanner input = new Scanner(System.in);
		int numberInput = input.nextInt();
		return numberInput;
	}

	public static String userStringInput() {
		Scanner input = new Scanner(System.in);
		String stringInput = input.nextLine();
		return stringInput;
	}

	public static void mainMenu() {
		try {
			System.out.println("Welcome to the Main Menu!");
			System.out.println("Enter the number corresponding to the menu selection");
			System.out.println("1. Sort the Directory \n2. Add, Delete, or Search \n3. Close application");
			int mainSelection = userNumberInput();
			switch (mainSelection) {
			case 1:
				key.sortFilesinList();
				navigation();
				break;
			case 2:
				secondaryMenu();
				navigation();
				break;
			case 3:
				System.out.println("App closed!");
				break;
			default: 
					System.out.println("Invalid Input!");
					navigation();
					break;
					
			}
		} catch (Exception e) {
			System.out.println("Error detected!");
			navigation();
		} 
	}

	public static void secondaryMenu() {

		String fileName;
		System.out.println("Welcome to the Secondary Menu!");
		System.out.println("Enter the number corresponding to the menu selection");
		System.out.println("1. Add file \n2. Delete file \n3. Search for file \n4. Return to Main Menu");
		int secondarySelection = userNumberInput();
		switch (secondarySelection) {
		case 1:
			System.out.println("Enter file name to add to the directory");
			fileName = userStringInput();
			key.addFiletoList(fileName);
			break;
		case 2:
			System.out.println("Enter file name to delete from the directory");
			fileName = userStringInput();
			key.deleteFilefromList(fileName);
			break;
		case 3:
			System.out.println("Enter file name to search to the directory");
			fileName = userStringInput();
			key.searchFilefromList(fileName);
			break;
		case 4:
			mainMenu();
			break;
			default: 
				System.out.println("Invalid Input");
				navigation();
				break;
		}
	}

	public static void navigation() {
		System.out.println("Enter 1 for main menu or 2 for secondary menu");
		int option = userNumberInput();
		switch (option) {
		case 1:
			mainMenu();
			break;
		case 2:
			secondaryMenu();
		default:
			mainMenu();
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Virtual Key Repository developed by Nehemiah Sam");
		mainMenu();

	}

}
