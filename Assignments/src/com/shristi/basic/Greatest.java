package com.shristi.basic;

public class Greatest {

	public static void main(String[] args) {

		int[] array = { 5, 15, 25, 40, 35 };
		int greatest = array[0];
		for (int num : array) {
			if (num > greatest) {
				greatest = num;
			}
		}
		System.out.println("Greatest number in the array {5, 15, 25, 40, 35} is " + greatest);

	}

}
