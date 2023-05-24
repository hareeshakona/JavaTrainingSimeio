package com.shristi.objbasics;

public class Student {

	String name;
	int id;	

	public Student(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	void printDetails() {		
		System.out.println("Student details :\n" + "Name - " + name + "\nId - " + id);
	}

	String getGrades(int[] marks) {

		int sum = 0;
		float average = 0.0f;

		for (int value : marks)
			sum += value;

		average = sum / marks.length;

		if (average >= 80)
			return "A";
		else if (average >= 60)
			return "B";
		else if (average >= 40)
			return "C";
		else
			return "Fail";

	}

}
