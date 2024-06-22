package com.ey.training.collections;

import java.time.LocalDate;
import java.util.Objects;

public class Person /*extends Object*/ {

	private String name;
	private String email;
	private LocalDate dateOfBirth;
	
	public Person() {
	}
	public Person(String name, String email, LocalDate dateOfBirth) {
		this.name = name;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	@Override
	public int hashCode() {
		//System.out.println("hashCode called..");
		return Objects.hash(dateOfBirth, email, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		//System.out.println("equals called..");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person p = (Person) obj;
		if(this.name.equals(p.name) && this.email.equals(p.email) && this.dateOfBirth.equals(p.dateOfBirth))
			return true;
		return false;
	}

}
