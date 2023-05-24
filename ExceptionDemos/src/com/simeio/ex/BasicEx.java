package com.simeio.ex;

public class BasicEx {

	public static void main(String[] args) {
		
		try {
		System.out.println("Welcome");		
		String val = args[0];
		System.out.println("Value got");
		int num = Integer.parseInt(val);
		System.out.println("Num"+num);
		int result = 100/num;
		System.out.println(result);
		}catch(Exception e) {
			System.out.println(e);
		}
		/*finally {
			System.out.println("In finally block");
		}*/
		
		System.out.println("Work done");

	}

}
