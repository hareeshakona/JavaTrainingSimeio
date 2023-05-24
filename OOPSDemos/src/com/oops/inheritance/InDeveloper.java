package com.oops.inheritance;

public class InDeveloper extends InEmployee {
	
	int experience;

	public InDeveloper(String name, double salary, String city, int experience) {
		super(name, salary, city);
		this.experience = experience;
		
	}
	
	void calcBonus(double amount) {
		System.out.println("Developer bonus"+(amount*5));		
	}
	
	void showAssignedProject() {
		if (experience > 5)
			System.out.println("You are assigned to cybersecurity.");
		else System.out.println("You are assigned to managed services.");
	}

}
