package com.simeio.ex;

public class MultiCatch {

	public static void main(String[] args) {

		try {
			System.out.println("Welcome");
			String val = args[0];
			System.out.println("Value got");
			int num = Integer.parseInt(val);
			System.out.println("Num" + num);
			int result = 100 / num;
			System.out.println(result);
			int marks[] = null;
			System.out.println(marks[0]);
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException | NumberFormatException e) {
			System.out.println(e);
			System.out.println("please enter values greater than zero");
		} catch (Exception e) {
			System.out.println("please enter a value");
			System.out.println(e.getMessage());
		}

		System.out.println("Work done");

	}

}
