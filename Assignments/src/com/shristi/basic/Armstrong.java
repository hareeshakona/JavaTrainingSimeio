package com.shristi.basic;

public class Armstrong {

	public static void main(String[] args) {

		int num = 153;
		int temp = num;
		int count = 0;
		int digit = 0;
		int sum = 0;

		// calculate no. of digits
		while (temp > 0) {
			temp = temp / 10;
			count++;
		}

		// calculate the sum of powers
		temp = num;
		while (temp > 0) {
			digit = temp % 10;
			sum = (int) (sum + Math.pow(digit, count));
			temp = temp / 10;
		}

		if (sum == num)
			System.out.println("It is an armstrong number.");
		else
			System.out.println("Not an armstrong number.");

	}

}
