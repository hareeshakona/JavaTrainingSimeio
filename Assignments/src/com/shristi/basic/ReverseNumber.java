package com.shristi.basic;

public class ReverseNumber {

	public static void main(String[] args) {

		int num = 1234;
		int reverse = 0;
		int reminder = 0;

		while (num > 0) {
			reminder = num % 10;
			num = num / 10;
			reverse = (reverse * 10) + reminder;
		}

		System.out.println("Number in reverse : " + reverse);

	}

}
