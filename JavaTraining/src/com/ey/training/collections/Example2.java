package com.ey.training.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Example2 {

	public static void main(String[] args) {
		Set<String> set1 = new HashSet<String>();
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
	}
}
