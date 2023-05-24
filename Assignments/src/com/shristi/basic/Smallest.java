package com.shristi.basic;

public class Smallest {

	public static void main(String[] args) {

		int[] array = { 50, 15, 25, 40, 35 };
		int smallest = array[0];
		for (int num : array) {
			if (num < smallest) {
				smallest = num;
			}
		}
		System.out.println("Smallest number in the array {50, 15, 25, 40, 35} is " + smallest);

	}

}
