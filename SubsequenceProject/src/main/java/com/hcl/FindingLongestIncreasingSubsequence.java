package com.hcl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindingLongestIncreasingSubsequence {

	public static List<Integer> randomGenerator(int amount, int maxNumber) {
		List<Integer> randomArray = new ArrayList<Integer>();
		for (int i = 0; i < amount; i++) {
			randomArray.add((int) (0 + (Math.random() * maxNumber)));
		}
		return randomArray;

	}

	public static void findingSequence(List<Integer> sequence, int n) {
		int maxNumber;
		int reference;
		int secondReference;
		List<Integer> amendedArray = new ArrayList<Integer>();
		List<Integer> indexArray = new ArrayList<Integer>();
		List<Integer> sizeArray = new ArrayList<Integer>();
		amendedArray.add(-1);
		amendedArray.add(sequence.get(0));
		for (int i = 1; i < n; i++) {
			if (sequence.get(i) > sequence.get(i - 1)) {
				amendedArray.add(sequence.get(i));
			} else {
				amendedArray.add(-1);
				amendedArray.add(sequence.get(i));
			}
		}
		amendedArray.add(-1);
		
		for (int count = 0; count < amendedArray.size(); count++) {
			if (amendedArray.get(count) == -1) {
				indexArray.add(count);
			}
		}
		
		for (int counti = 0; counti < indexArray.size() - 1; counti++) {
			sizeArray.add(indexArray.get(counti + 1) - indexArray.get(counti));
		}
		maxNumber = Collections.max(sizeArray);
		reference = indexArray.get(sizeArray.indexOf(maxNumber));
		secondReference = indexArray.get(sizeArray.indexOf(maxNumber) + 1);
		List<Integer> finalArray = amendedArray.subList(reference + 1, secondReference);
		System.out.println("The longest increasing subsequence is the following:" + finalArray);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		System.out.println("This program will find the first longest increasing subsequence from an array of max size 100.");
		System.out.println("Enter the amount of numbers you want in the array");
		int amount = input.nextInt();
		System.out.println("Enter the maximum number in the sequence");
		int maxNumber = input1.nextInt();
		List<Integer> sequenceArray = randomGenerator(amount, maxNumber);
		System.out.println("Random Sequence Generated: " + sequenceArray);
		findingSequence(sequenceArray, amount);
	}

}
