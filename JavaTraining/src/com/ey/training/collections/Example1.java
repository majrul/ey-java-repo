package com.ey.training.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Example1 {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>(); //TODO: check differences between ArrayList and LinkedList
		//angular bracket notation is called as Generics in Java
		list1.add("Java");
		list1.add("Python");
		list1.add("C/C++");
		list1.add("C#");
		list1.add("Java");
		list1.add(1, "JavaScript");
		
		System.out.println("---- traditional for loop ---- ");
		for(int i=0; i<list1.size(); i++) {
			String str = list1.get(i);
			System.out.println(str);
		}
		
		System.out.println("---- modern for each loop ---- ");
		for(String str : list1) {
			System.out.println(str);
		}
		
		System.out.println("---- lambda based for each  ---- ");
		list1.forEach(str -> System.out.println(str));
		//list1.forEach(System.out::println);
		
		System.out.println("---- traditional Iterator API ---- ");
		Iterator<String> itr = list1.iterator();
		while(itr.hasNext()) {
			String str = itr.next();
			System.out.println(str);
		}
		
		//for each loop/method of Java internally uses Iterator API
		
		List<Person> list2 = new ArrayList<Person>();
		Person p = new Person("Smith", "smith@gmail.com", LocalDate.of(1995, 10, 20));
		list2.add(p);
		list2.add(new Person("John", "john@gmail.com", LocalDate.of(1995, 10, 10)));
		list2.add(new Person("Jack", "jack@gmail.com", LocalDate.of(1995, 12, 10)));
		
		System.out.println("-------- ");
		//keep the ctrl key pressed and as you move your mouse cursor, it turns in hyperlink
		for(Person pr : list2)
			System.out.println(pr);
			//System.out.println(pr.getName() + " , " + pr.getEmail() + " , " + pr.getDateOfBirth());
	
		
		//what if we a list of numbers?
		//this will not work directly
		//List<int> list3 = new ArrayList<int>();
		//collection api doesn't supports primitive datatypes of Java, only objects can be stored in any collection
		//the solution is to use wrapper classes for primitive datatypes,
		//wrapper classes are meant for representing a primitive like an object
		//wraper classes also provide us with convenient functions for type conversion, ex: Integer.parseInt(..);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(10);
		list3.add(20);
		list3.add(30);
		
		//we can use Integer and int interchangeably because of autoboxing
		for(int no : list3)
			System.out.println(no);
		
		//TODO:
		//check some more functions provided by list, for ex: remove, clear, addAll, removeAll, retainAll, ..
		
	}
}
