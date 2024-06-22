package com.ey.training.threading;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.ey.training.collections.Person;

public class Example8 {

	public static void main(String[] args) {
		List<String> list = new CopyOnWriteArrayList<String>();
		//List<String> syncList = Collections.synchronizedList(list);
		list.add("Java");
		list.add("Oracle");
		list.add("Python");
		
		Iterator<String> itr = list.iterator();
		
		list.remove("Java");
		
		while(itr.hasNext())
			System.out.println(itr.next());
		
		
		itr = list.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
		
		ConcurrentMap<Long, Person> map = new ConcurrentHashMap<Long, Person>();
		map.putIfAbsent(1234567890L, new Person("Ram", "ram@gmail.com", LocalDate.of(1995, 10, 20)));
		map.putIfAbsent(9876543210L, new Person("Shyam", "shyam@gmail.com", LocalDate.of(1995, 10, 20)));
		map.putIfAbsent(1231231234L, new Person("Ravi", "ravi@gmail.com", LocalDate.of(1995, 10, 20)));
		map.putIfAbsent(1231231234L, new Person("Aravindh", "aravindh@gmail.com", LocalDate.of(1995, 10, 20)));

		//this is problematic, we don't want to replace the existing entry
		//map.put(1231231234L, new Person("Aravindh", "aravindh@gmail.com", LocalDate.of(1995, 10, 20)));
		
		//generally we should check like this
		//this code has a concurrency issue, if 2 threads run this code at the same time
		//we will have to syncrhonize the below code:
		/*synchronized(map) {
			if(!map.containsKey(1231231234L))
				map.put(1231231234L, new Person("Aravindh", "aravindh@gmail.com", LocalDate.of(1995, 10, 20)));			
		}*/
		

	}
}
