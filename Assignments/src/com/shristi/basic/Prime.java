package com.shristi.basic;

public class Prime {

	public static void main(String[] args) {

		int num = 11;
		boolean isprime = true;

		// since 1 is a divisor for every number starting from 2
		for (int i = 2; i < (num / 2); i++) {
			if ((num % i) == 0)
				isprime = false;
		}

		if (isprime == true)
			System.out.println("It is a prime number.");
		else
			System.out.println("It is not a prime number.");

	}

}
