package com.shristi.basic;

public class PyramidPatterns {

	public static void main(String[] args) {

		int level = 5;

		for (int i = 1; i <= level; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}

		for (int i = level; i >= 1; i--) {
			for (int j = i; j >= 1; j--) {
				System.out.print("*");
			}
			System.out.println(" ");
		}

	}

}
