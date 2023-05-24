package com.shristi.basic;

public class SumAndAvg {

	public static void main(String[] args) {

		int[] array = { 50, 15, 25, 40, 35 };

		int sum = 0;
		for (int number : array)
			sum += number;
		System.out.println("Sum of numbers in array {50, 15, 25, 40, 35} is " + sum);

		int count = array.length;
		float average = sum / count;
		System.out.println("Average of numbers in array {50, 15, 25, 40, 35} is " + average);

	}

}
