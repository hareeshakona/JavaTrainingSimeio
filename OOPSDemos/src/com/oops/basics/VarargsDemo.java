package com.oops.basics;

public class VarargsDemo {

	public static void main(String[] args) {
		
		VarargsDemo dem = new VarargsDemo();
		dem.sumOfMarks("Ram",10);
		dem.sumOfMarks("Tom",10,20);
		dem.sumOfMarks("Sri",90,80,20);
		

	}
	
	void sumOfMarks(String name, int...marks) {
		System.out.println(name);
		int total =0;
		for (int m : marks)
		{
			total+=m;
		}
		
		System.out.println("Sum "+total);
	}

}
