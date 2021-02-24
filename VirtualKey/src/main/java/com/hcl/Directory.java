package com.hcl;

import java.util.ArrayList;
import java.util.Collections;

public class Directory {
	public static ArrayList<String> rootDirectory = new ArrayList<String>();
	static {
		rootDirectory.add("All about Java.pdf");
		rootDirectory.add("Nehemiah's Biography.docx");
	}
	
	public static void sortFilesinList() {
		Collections.sort(rootDirectory);
		System.out.println("Sorted Directory");
		for(int index=0; index<rootDirectory.size(); index++) {
			System.out.println(rootDirectory.get(index));
		}
	}

	public static void addFiletoList(String name) {
		rootDirectory.add(name);
		System.out.println(name + " added to directory.");

	}

	public static void deleteFilefromList(String name) {
		int index = rootDirectory.indexOf(name);
		rootDirectory.remove(index);
		System.out.println(name + " deleted from directory.");

	}

	public static void searchFilefromList(String name) {
		if (rootDirectory.contains(name)) {
			System.out.println(name + " was found in directory.");
		} else {
			System.out.println("The filewas not found in directory.");
		}
	}

}
