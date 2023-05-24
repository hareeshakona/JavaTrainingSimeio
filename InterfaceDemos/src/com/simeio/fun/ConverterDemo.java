package com.simeio.fun;

public class ConverterDemo {

	public static void main(String[] args) {
		
		Converter con = new Converter();
		con.convertFile("demo.txt", filename -> {
			System.out.println("Compressing to zip file "+ filename);
		});		

	}

}
