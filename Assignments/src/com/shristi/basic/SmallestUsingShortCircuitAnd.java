package com.shristi.basic;

import java.util.Scanner;

public class SmallestUsingShortCircuitAnd {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter values :");

		int number1 = sc.nextInt();
		int number2 = sc.nextInt();
		int number3 = sc.nextInt();
		int smallest = 0;

		if ((number1 < number2) && (number1 < number3))
			smallest = number1;
		else if (number2 < number3)
			smallest = number2;
		else
			smallest = number3;

		System.out.println("Smallest number is " + smallest);

		sc.close();

	}

}
