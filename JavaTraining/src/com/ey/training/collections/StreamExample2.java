package com.ey.training.collections;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StreamExample2 {

	public static void main(String[] args) {
		Function<String, Integer> f = Integer::parseInt;
		int i = f.apply("100");
		//int i = Integer.parseInt("100");
		
		Function<String, String> f2 = (str) -> str.toUpperCase();
		String s = f2.apply("Majrul");
		System.out.println(s);
		
		List<String> list = Arrays.asList("Java", "Oracle", "Python");
		/*
		 * don't do this, even though it will work
		 class MyConsumer implements Consumer<String> {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};*/
		//list.forEach(new MyConsumer());
		
		//Consumer<String> c = (str) -> System.out.println(str);
		//list.forEach(c);
		list.forEach(str -> System.out.println(str));
		list.forEach(System.out::println);
		
		String str = "Majrul";
		Supplier<String> s1 = str::toUpperCase;
		String str2 = s1.get();
		System.out.println(str2);
		
		String username = "majrul";
		Predicate<String> condition1 = (uname) -> uname.equals("majrul");
		boolean one = condition1.test(username);
	}
}
