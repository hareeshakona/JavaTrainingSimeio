package com.shristi.basic;

public class SecondLargest {

	public static void main(String[] args) {

		int[] array = { 50, 15, 25, 40, 35 };
		int temp;

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {

					temp = array[i];
					array[i] = array[j];
					array[j] = temp;

				}
			}
		}

		System.out.println("Second largest number in the array {50, 15, 25, 40, 35} is " + array[1]);

	}

}
