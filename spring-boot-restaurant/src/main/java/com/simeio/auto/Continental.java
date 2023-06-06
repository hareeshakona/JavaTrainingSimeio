package com.simeio.auto;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("menu")
public class Continental implements IFoodMenu {

	@Override
	public List<String> showItems() {
		return Arrays.asList("Pancake","Pizza","French Toast");
	}

}
