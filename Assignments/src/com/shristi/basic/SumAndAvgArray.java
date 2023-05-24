package com.shristi.basic;

import java.util.Scanner;

public class SumAndAvgArray {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of values :");
		int count = sc.nextInt();

		int[] values = new int[count];

		System.out.println("Enter Values :");

		for (int i = 0; i < count; i++) {
			values[i] = sc.nextInt();
		}

		int sum = 0;
		for (int value : values) {
			sum += value;
		}

		System.out.println("Sum of entered values is " + sum);

		float average = sum / count;

		System.out.println("Average of entered values is " + average);

		sc.close();

	}

}
