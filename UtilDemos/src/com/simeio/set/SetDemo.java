package com.simeio.set;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		Set<String> hashSet = new HashSet<>();
		hashSet.add("Ram");
		hashSet.add("Poppy");
		System.out.println(hashSet);
		System.out.println(hashSet.size());
		hashSet.add("Jo");
		hashSet.add("Lucky");
		hashSet.add("100");
		
		System.out.println(hashSet);

		for (String name : hashSet) {
			System.out.println(name);
		}
	}
}
