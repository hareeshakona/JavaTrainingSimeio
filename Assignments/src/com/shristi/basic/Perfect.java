package com.shristi.basic;

public class Perfect {

	public static void main(String[] args) {

		int num = 28;
		int sum = 1; // Since 1 is a divisor for all numbers

		for (int i = 2; i <= (num / 2); i++) {
			if ((num % i) == 0)
				sum += i;
		}

		if (sum == num)
			System.out.println("It is a perfect number.");
		else
			System.out.println("It is not a perfect number.");

	}

}
