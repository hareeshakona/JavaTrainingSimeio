package com.oops.inheritance;

public class OverDemo {

	public static void main(String[] args) {
		
		InEmployee employee1 = new InManager("Rohan", 100000, "Bangalore", 50);
		employee1.calcBonus(500);		
		
		InManager manager = (InManager)employee1;
		manager.showHobbies("Music","Reading");
		manager.teamOuting();
		
		InEmployee employee2 = new InDeveloper("Mily", 50000, "Bangalore", 3);
		employee2.calcBonus(0);
		
		InDeveloper developer = (InDeveloper)employee2;
		developer.showAssignedProject();
 
	}

}
