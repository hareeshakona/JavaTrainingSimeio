package com.simeio.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class ListDemo {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("Ram");
		list.add("Poppy");
		System.out.println(list);
		System.out.println(list.size());
		list.add(1, "Jo");
		list.add("Lucky");
		System.out.println(list);
		list.set(2, "Rishi");
		System.out.println(list);
		System.out.println(list.get(1));

		System.out.println("Sorted list");
		Collections.sort(list);
		System.out.println(list);
		
		System.out.println("Using iterator");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());

		System.out.println("Using list iterator");
		ListIterator<String> It = list.listIterator(list.size());
		while (It.hasPrevious()) {
			String name = It.previous();
			System.out.println(name);
		}
		System.out.println("Using ForEach");
		for (String uname : list) {
			System.out.println(uname);
		}

	}
}
