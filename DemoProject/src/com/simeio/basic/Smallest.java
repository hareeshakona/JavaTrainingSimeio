package com.simeio.basic;

public class Smallest {

	public static void main(String[] args) {
		int x = 40;
		int y = 20;
		int z = 30;

		int s = (x < y && x < z) ? x : ((y < z) ? y : z);
		System.out.println(s + " is smallest");

	}

}
