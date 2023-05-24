package com.simeio.basic;

import java.util.Scanner;

public class ScanArray {

	public static void main(String[] args) {
		int[] values = new int[4];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Values");
		
		for (int i=0;i<4;i++)
		{
			values[i]= sc.nextInt();
		}
		
		int sum = 0;
		for(int num:values)
		{
			sum += num;
		}
		
		System.out.println("Sum of entered values is "+sum);
		
		sc.close();

	}

}
