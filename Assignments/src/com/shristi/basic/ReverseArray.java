package com.shristi.basic;

public class ReverseArray {

	public static void main(String[] args) {

		int[] array = { 50, 35, 15, 10, 15, 20, 25, 30 };
		int[] reversearray = new int[array.length];

		for (int i = (array.length - 1), j = 0; i >= 0; i--, j++) {
			reversearray[j] = array[i];
		}

		System.out.print("Array in reverse is {");
		for (int num : reversearray)
			System.out.print(num + " ");
		System.out.println("}");

	}

}
