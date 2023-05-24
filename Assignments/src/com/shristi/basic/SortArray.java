package com.shristi.basic;

import java.util.Arrays;

public class SortArray {

	public static void main(String[] args) {

		int[] array = { 67, 75, 23, 10, 98, 5 };

		Arrays.sort(array);

		System.out.print("Array sorted in ascending order {");
		for (int num : array) {
			System.out.print(" " + num);
		}
		System.out.println(" }");

	}

}
