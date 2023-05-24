package com.shristi.basic;

import java.util.Scanner;

public class SqrtArray {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the count of numbers :");
		int size = sc.nextInt();

		int[] values = new int[size];

		System.out.println("Enter numbers :");

		for (int i = 0; i < size; i++) {
			values[i] = sc.nextInt();
		}

		// find the squareroots
		double[] sqrtvalues = new double[size];
		int count = 0;
		for (int value : values) {
			sqrtvalues[count] = Math.sqrt(value);
			count++;
		}

		System.out.println("Square roots of the given numbers are :");
		// iterate and print the squareroots
		for (double sqrtvalue : sqrtvalues)
			System.out.println(sqrtvalue);

		sc.close();

	}

}
