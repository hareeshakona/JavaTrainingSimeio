package com.simeio.ex;

public class FinallyDemo {

	public static void main(String[] args) {
		
		try {
		System.out.println("Welcome");	
		String val = args[0];
		System.out.println("Value got");
		int num = Integer.parseInt(val);
		System.out.println("Num"+num);
		int result = 100/num;
		System.out.println(result);
		}/*catch(Exception e) {
			System.out.println("exception");
			System.out.println(e.getMessage());
		}*/finally {
			System.out.println("completed...");
		}
		
		System.out.println("Work done");

	}

}
