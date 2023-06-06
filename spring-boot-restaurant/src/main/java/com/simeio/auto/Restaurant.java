package com.simeio.auto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	
	@Autowired
	IFoodMenu menu;
	
	@Autowired
	IFoodMenu chinese;
	
	@Autowired
	@Qualifier("indian")
	IFoodMenu imenu;

	public List<String> displayMenu(String choice) {
		System.out.println("Displaying Menu");
		if(choice.equals("Indian")) 
			return imenu.showItems();
		if(choice.equals("Chinese"))
			return chinese.showItems();
		if(choice.equals("Continental"))
			return menu.showItems();
		return null;
	}
}
