package com.hcl;

import java.util.ArrayList;
import java.util.Collections;

public class Directory {
	public static ArrayList<String> rootDirectory = new ArrayList<String>();
	static {
		rootDirectory.add("Nehemiah's Biography.docx");
		rootDirectory.add("All about Java.pdf");
	}

	public void sortFilesinList() {
		Collections.sort(rootDirectory);
		System.out.println("Sorted Directory");
		for (int index = 0; index < rootDirectory.size(); index++) {
			System.out.println(rootDirectory.get(index));
		}
	}

	public void addFiletoList(String name) {
		if (searchFilefromList(name) == 0) {
			name=name.substring(0,1).toUpperCase()+name.substring(1);
			rootDirectory.add(name);
			System.out.println(name + " added to directory.");
		} else {
			System.out.println("File already exists!");
		}

	}

	public void deleteFilefromList(String name) {
		if (searchFilefromList(name) == 1) {
			int index = rootDirectory.indexOf(name);
			rootDirectory.remove(index);
			System.out.println(name + " deleted from directory.");
		}
	}

	public int searchFilefromList(String name) {
		int result = 0;
		if (rootDirectory.size() > 0) {
			if (rootDirectory.contains(name)) {
				System.out.println(name + " was found in directory.");
				result = 1;
			} else {
				System.out.println("The filewas not found in directory.");
			}
		} else {
			System.out.println("Directory is empty!");
		}

		return result;
	}
	
}
