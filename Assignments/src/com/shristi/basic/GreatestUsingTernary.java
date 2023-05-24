package com.shristi.basic;

import java.util.Scanner;

public class GreatestUsingTernary {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter values :");

		int number1 = sc.nextInt();
		int number2 = sc.nextInt();
		int number3 = sc.nextInt();

		int greatest = ((number1 > number2) && (number1 > number3)) ? number1
				: ((number2 > number3) ? number2 : number3);

		System.out.println("Greatest number is " + greatest);

		sc.close();

	}

}
