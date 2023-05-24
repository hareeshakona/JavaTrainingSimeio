package com.shristi.basic;

public class Fibonacci {

	static int[] fibonacci(int count) {

		if (count > 0) {

			int[] fibonacci = new int[count];
			int num1 = fibonacci[0] = 0;
			int num2 = fibonacci[1] = 1;
			int num3 = 0;

			for (int i = 2; i < count; i++) {
				num3 = num1 + num2;
				fibonacci[i] = num3;
				num1 = num2;
				num2 = num3;
			}

			return fibonacci;

		} else
			return null;

	}

	public static void main(String[] args) {

		int count = 20;

		if (count > 0) {

			int[] fibonacciseries = fibonacci(count);
			System.out.println("Fibonacci series  - ");
			for (int num : fibonacciseries)
				System.out.println(num);

		} else
			System.out.println("Can't give a fibonacci series.");
	}

}
