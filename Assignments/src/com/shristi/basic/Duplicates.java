package com.shristi.basic;

public class Duplicates {

	public static void main(String[] args) {

		int[] array = { 50, 15, 25, 40, 35, 25, 15, 15, 40 };
		int[] temp = array;
		int size = array.length;
		int count = 0;

		// find the duplicates and set them as 0 in the temp array
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if ((temp[i] != 0) && (temp[i] == temp[j])) {
					temp[j] = 0;
				}
			}
		}

		// count the zero values in temp array, which gives the number of duplicates
		for (int value : temp) {
			if (value == 0)
				count++;
		}

		System.out.println("Total number of duplicates is " + count);

	}

}
