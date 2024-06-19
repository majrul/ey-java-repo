package com.ey.training.collections;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Example3 {

	public static void main(String[] args) {
		//key -> aadhar card no, value -> info about the person
		Map<Long, Person> map = new HashMap<Long, Person>();
		map.put(1234567890L, new Person("Ram", "ram@gmail.com", LocalDate.of(1995, 10, 20)));
		map.put(9876543210L, new Person("Shyam", "shyam@gmail.com", LocalDate.of(1995, 10, 20)));
		map.put(1231231234L, new Person("Ravi", "ravi@gmail.com", LocalDate.of(1995, 10, 20)));
		
		//this is problematic, we don't want to replace the existing entry
		//map.put(1231231234L, new Person("Aravindh", "aravindh@gmail.com", LocalDate.of(1995, 10, 20)));
		
		//generally we should check like this
		if(!map.containsKey(1231231234L))
			map.put(1231231234L, new Person("Aravindh", "aravindh@gmail.com", LocalDate.of(1995, 10, 20)));			
		
		Person p = map.get(1231231234L);
		System.out.println(p);
		
		//how to write a for loop to iterate over the map
		for(Map.Entry<Long, Person> entry : map.entrySet()) {
			Long aadharCardNo = entry.getKey();
			Person person = entry.getValue();
			System.out.println(aadharCardNo + " :: " + person);
		}
		
		//using lambda to iterate over the map
		map.forEach((aadharCardNo, person) -> System.out.println(aadharCardNo + " :: " + person));
	}
}
