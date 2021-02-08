package com.hcl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileHandling {
	
	public static int creatingFile(String fileName){
		int result;
		try {
		      File theFile = new File(fileName);
		      if (theFile.createNewFile()==true) {
		        System.out.println(fileName+ " has been created!");
		      } else {
		        System.out.println("File name already taken.");
		      }
		      result=1;
		    } catch (IOException e) {
		      System.out.println("Error detected!");
		      result=0;
		    }
		return result;
	}
	
	public static int readingFile(String fileName){
		int result; 
		try {
		      File theFile = new File(fileName);
		      Scanner fileReader= new Scanner(theFile);
		      while (fileReader.hasNextLine()) {
		        String text = fileReader.nextLine();
		        System.out.println(text);
		      }
		      fileReader.close();
		      result =1;
		    } catch (FileNotFoundException e) {
		      System.out.println("Error detected");
		      result=0;
		    }
			return result;	
	}
	public static void appendingFile(String fileName, String newText) {
		 try {
		      FileWriter myWriter = new FileWriter(fileName);
		      myWriter.write(newText);
		      myWriter.close();
		      System.out.println("Text added");
		    } catch (IOException e) {
		      System.out.println("Text failed to be added.");
		     }
	
	}

	public static void main(String[] args) {
		int outcome;
		String update;
		Scanner input = new Scanner(System.in); 
		Scanner input1 = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		Scanner input3 = new Scanner(System.in);
		Scanner input4 = new Scanner(System.in);
		System.out.println("Welcome to Nehemiah's File Handling Application!");
		System.out.println("You will be able to append existing files and new files.");
		System.out.println("Enter 1 to read an existing file or 2 to write/create new file");
		int selection= input.nextInt();
		switch (selection) {
		case 1:
			System.out.println("Enter existing file name.");
			String fileInput=input1.nextLine();
			outcome=readingFile(fileInput);
			if(outcome==1) {
			System.out.println("Type what you will like to add to the file ");
			update=input3.nextLine();
			appendingFile(fileInput,update);
			}
			break;
		case 2: 
			System.out.println("Name your new file");
			String newFileName=input2.nextLine();
			outcome=creatingFile(newFileName);
			if (outcome==1) {
			System.out.println("Type what you will like to add to the file ");
			update=input4.nextLine();
			appendingFile(newFileName,update);
			}
			break;
		}
		System.out.println("Thank for using this application.");
		

	}

}
