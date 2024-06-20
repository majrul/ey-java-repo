package com.ey.training.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Example4 {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("Smith", "smith@gmail.com", LocalDate.of(1995, 10, 20)));
		list.add(new Person("John", "john@gmail.com", LocalDate.of(1990, 10, 10)));
		list.add(new Person("Jack", "jack@gmail.com", LocalDate.of(2000, 12, 10)));
		list.add(new Person("Nancy", "nancy@gmail.com", LocalDate.of(1980, 10, 10)));
		list.add(new Person("Andrew", "andrew@gmail.com", LocalDate.of(2010, 10, 10)));
		
		//to sort collection of user defined objects, there are 2 choices:
		//implement Comparable interface in the object's class (ex: Person class)
		//or write a separate class implementing Comparator interface
		//very commonly we go for anonymous inner class
		//from java 8 onwards we can use lambda as Comparator is a functional interface
		
		Comparator<Person> comp = new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.getName().compareTo(p2.getName());
			}
		};
		
		Collections.sort(list, comp);
		//Collections.sort(list, (p1, p2) -> p1.getName().compareTo(p2.getName()));
		//Collections.sort(list, Comparator.comparing(Person::getName));
		list.sort(comp);
		
		list.forEach(p -> System.out.println(p));
		//list.forEach(System.out::println);
	
		
		List<String> list2 = new ArrayList<String>();
		list2.add("Sushant");
		list2.add("Aravindh");
		list2.add("Jyoti");
		list2.add("Vishwa");
		list2.add("Israt");
		
		Collections.sort(list2);
		list2.forEach(System.out::println);
	}
}
