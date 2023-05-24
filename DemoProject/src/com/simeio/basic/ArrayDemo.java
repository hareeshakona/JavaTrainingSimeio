package com.simeio.basic;

public class ArrayDemo {

	public static void main(String[] args) {
		int[] marks=new int[3];
		System.out.println(marks.length);
		System.out.println(marks[1]);
		
		marks[0]=90;
		marks[1]=90;
		marks[2]=80;
		//marks[3]=90;
		
		int sum = 0;
		for(int i=0;i<marks.length;i++)
		{
			sum += marks[i];
		}
		System.out.println(sum);
		
		int add = 0;
		for(int num:marks) {
			add += num ;
		}
		
		System.out.println(add);
		

	}

}
