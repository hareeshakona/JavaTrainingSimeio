package com.simeio.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedlistDemo {

	public static void main(String[] args) {

		LinkedList<String> list = new LinkedList<>();
		list.add("Ram");
		list.add("Poppy");
		System.out.println(list);
		System.out.println(list.size());
		list.add(1, "Jo");
		list.addFirst("Lucky");
		System.out.println(list);
		list.set(2, "Rishi");
		System.out.println(list);
		System.out.println(list.get(1));

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

		System.out.println("Using offer");
		list.offer("Hareesha");
		list.offerFirst("Kona");
		System.out.println(list);
		System.out.println(list.element()); // prints the head
		System.out.println(list.poll());
		System.out.println(list);
		System.out.println(list.poll());
		System.out.println(list);
		System.out.println(list.poll());
		System.out.println(list);
		System.out.println(list.poll());
		System.out.println(list);
		System.out.println(list.poll());
		System.out.println(list);
		System.out.println(list.poll());
		System.out.println(list);

	}

}
