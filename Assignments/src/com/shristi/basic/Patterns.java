package com.shristi.basic;

public class Patterns {

	public static void main(String[] args) {

		int num = 4;

		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i);
			}
			System.out.print(" ");
		}
		System.out.println("");

		int count = 1;
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(count);
				count++;
			}
			System.out.print(" ");
		}

	}

}
