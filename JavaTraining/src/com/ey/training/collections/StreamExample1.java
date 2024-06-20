package com.ey.training.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample1 {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("Smith", "smith@gmail.com", LocalDate.of(1995, 10, 20)));
		list.add(new Person("John", "john@gmail.com", LocalDate.of(1990, 10, 10)));
		list.add(new Person("Jack", "jack@gmail.com", LocalDate.of(2000, 12, 10)));
		list.add(new Person("Nancy", "nancy@gmail.com", LocalDate.of(1980, 10, 10)));
		list.add(new Person("Andrew", "andrew@gmail.com", LocalDate.of(2010, 10, 10)));

		Stream<Person> s = list.stream();
		s.forEach(p -> System.out.println(p));
		
		list
			.stream()
			.forEach(p -> System.out.println(p));

		System.out.println("---------------");
		
		list
			.stream()
			.filter(p -> p.getDateOfBirth().getYear() >= 1999)
			.forEach(p -> System.out.println(p));
		
		//Old style code
		for(Person p : list)
			if(p.getDateOfBirth().getYear() >= 1999)
				System.out.println(p);
		
		//what if we want to store the above persons data in another list?
		
		//Old style code
		List<Person> anotherList = new ArrayList<Person>();
		for(Person p : list)
			if(p.getDateOfBirth().getYear() >= 1999)
				anotherList.add(p);
		
		//Stream API code
		List<Person> anotherList2 = list
									.stream()
									.filter(p -> p.getDateOfBirth().getYear() >= 1999)
									//.collect(Collectors.toList());
									.collect(Collectors.toCollection(LinkedList::new));
		
		Person[] arrOfPerson = list
								.stream()
								.filter(p -> p.getDateOfBirth().getYear() >= 1999)
								.toArray(Person[]::new);
		
		Stream
			.of(arrOfPerson)
			.forEach(System.out::println);
	
		
		System.out.println("->->->->->->->->->->->->->->");
		list
		.stream()
			.filter(p -> p.getDateOfBirth().getYear() >= 1999)
			.sorted(Comparator.comparing(Person::getName).reversed())
			.forEach(p -> System.out.println(p));
		
		
		//suppose i want name of the person whose dob is matching the condition
		System.out.println("->->->->->->->->->->->->->->");
		list
		.stream()
		.filter(p -> p.getDateOfBirth().getYear() >= 1999)
		.map(p -> p.getName())
		.forEach(System.out::println);
		
		
		List<String> listOfNames = list
									.stream()
									.map(p -> p.getName())
									.collect(Collectors.toList());
		
		
		List<PersonInfo> personInfoList = list
										.stream()
										.filter(p -> p.getDateOfBirth().getYear() >= 1999)
										.map(p -> new PersonInfo(p.getName(), p.getEmail()))
										.collect(Collectors.toList());
		
		System.out.println("0-0--0-0-0-0-0-0-0-0-0--");
		for(PersonInfo pi : personInfoList)
			System.out.println(pi.name + " " + pi.email);
		
		List<Employee> listOfEmps = new ArrayList<Employee>();
		listOfEmps.add(new Employee(1001, "John", 10000));
		listOfEmps.add(new Employee(1002, "Smith", 15000));
		listOfEmps.add(new Employee(1003, "Jack", 20000));
		listOfEmps.add(new Employee(1004, "Ed", 20000));
		
		//suppose i want to write a stream to calculate the total salary of all emps
		Double totalSalary = listOfEmps
								.stream()
								//.mapToDouble(emp -> emp.getSalary())
								.mapToDouble(Employee::getSalary)
								.sum();
		System.out.println(totalSalary);
		
		
		List<String> empNames = listOfEmps
									.parallelStream()
									.filter(emp -> {
										System.out.println("filter " + Thread.currentThread().getName());
										return emp.getSalary() > 10000;
									})
									.map(emp -> {
										System.out.println("map " + Thread.currentThread().getName());	
										return emp.getName();
									})
									.collect(Collectors.toList());
	}
}

class Employee {
	int empno;
	String name;
	double salary;
	
	Employee(int empno, String name, double salary) {
		this.empno = empno;
		this.name = name;
		this.salary = salary;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
class PersonInfo {
	
	String name;
	String email;
	
	PersonInfo(String name, String email) {
		this.name = name;
		this.email = email;
	}

}