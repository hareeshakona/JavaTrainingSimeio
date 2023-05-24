package com.oops.inheritance;

public class InManager extends InEmployee {
	
	int teamSize;

	public InManager(String name, double salary, String city, int teamSize) {
		super(name, salary, city);
		this.teamSize = teamSize;
	
	}

	@Override
	void calcBonus(double amount) {
		System.out.println("Manager Bonus"+(amount*10));
	}
	
	void showHobbies(String...hobbies) {
		System.out.println("Hobbies :");
		for(String hobby:hobbies)
			System.out.println(hobby);
	}
	
	void teamOuting() {
		if (teamSize > 10)
			System.out.println("Weekend trip to a resort");
		else if (teamSize > 5)
			System.out.println("One day trip to resort");
		else System.out.println("Outing for lunch");
	}

}
