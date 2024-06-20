package com.ey.training.collections;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Example2 {

	public static void main(String[] args) {
		Set<String> set1 = new HashSet<String>(); //LinkedHashSet
		//SortedSet<String> set1 = new TreeSet<String>();
		set1.add("Java");
		set1.add("Python");
		set1.add("C/C++");
		set1.add("C#");
		set1.add("Java");

		for(String str : set1)
			System.out.println(str);
		
		Set<Person> set2 = new HashSet<Person>();
		Person p = new Person("Smith", "smith@gmail.com", LocalDate.of(1995, 10, 20));
		set2.add(p);
		set2.add(p);
		set2.add(new Person("John", "john@gmail.com", LocalDate.of(1995, 10, 10)));
		set2.add(new Person("Smith", "smith@gmail.com", LocalDate.of(1995, 10, 20)));
		set2.add(new Person("Jack", "jack@gmail.com", LocalDate.of(1995, 12, 10)));

		for(Person pr : set2)
			System.out.println(pr);
		
		Person p1 = new Person("Smith", "smith@gmail.com", LocalDate.of(1995, 10, 20));
		Person p2 = new Person("Smith", "smith@gmail.com", LocalDate.of(1995, 10, 20));
		//Person p2 = p1;
		if(p1 == p2) //reference comparison
			System.out.println("yes they are equal");

		if(p1.equals(p2)) //value comparison
			System.out.println("yes yes they are equal");
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
		String s1 = "Majrul";
		String s2 = "Majrul";
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
	}
}
