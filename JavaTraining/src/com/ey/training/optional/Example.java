package com.ey.training.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Example {

	public static void main(String[] args) {
		PhoneBook phBook = new PhoneBook();
		phBook.add(new Contact("John", "9876543210", "New York"));
		phBook.add(new Contact("Smith", "9876543210", "New Jersey"));
		phBook.add(new Contact("Jack", "9876543210", "New York"));
		
		//phBook.remove("John");
		//phBook.remove(new Contact("John", "9876543210"));
		
		//phBook.displayAll();
		
		phBook
			.searchByCity("New York")
			.forEach(System.out::println);
		
		Contact c = phBook.search("Majrul");
		if(c != null)
			System.out.println(c.getMobileNumber());
		else
			System.out.println("No matching contact found!");
		
		Optional<Contact> op = phBook.searchV2("Majrul");
		if(op.isPresent()) {
			Contact ct = op.get();
			System.out.println(ct);
		}
		else
			System.out.println("No matching contact found!");
		
		
		phBook
			.searchV2("Majrul")
			.ifPresentOrElse(ct -> System.out.println(ct), 
							 () -> System.out.println("No matching contact found!"));
		
		
		String mobNo = phBook
						.searchV2("John")
						.map(Contact::getMobileNumber)
						.orElse("");
		System.out.println(mobNo);
	}
}

class PhoneBook {
	
	List<Contact> contacts = new ArrayList<>();
	
	void add(Contact contact) {
		contacts.add(contact);
	}
	
	Contact search(String name) {
		for(Contact contact : contacts)
			if(contact.getName().equals(name))
				return contact;
		return null;
	}
	
	Optional<Contact> searchV2(String name) {
		for(Contact contact : contacts)
			if(contact.getName().equals(name))
				return Optional.of(contact);
		return Optional.empty();
	}
	
	//TODO: Return Optional from here
	List<Contact> searchByCity(String city) {
		/*List contactsByCity = new ArrayList<>();
		for(Contact contact : contacts)
			if(contact.getCity().equals(city))
				contactsByCity.add(contact);
		return contactsByCity;*/
		
		return contacts
				.stream()
				.filter(c -> c.getCity().equals(city))
				.collect(Collectors.toList());
	}
	
	void remove(String name) {
		for(Contact contact : contacts) {
			if(contact.getName().equals(name)) {
				contacts.remove(contact);
				break;
			}
		}
	}
	
	void remove(Contact c) {
		contacts.remove(c);
	}
	
	void displayAll() {
		contacts.forEach(System.out::println);
	}
}

class Contact {
	
	String name;
	String mobileNumber;
	String city;

	Contact(String name, String mobileNumber, String city) {
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.city = city;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", mobileNumber=" + mobileNumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(mobileNumber, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(mobileNumber, other.mobileNumber) && Objects.equals(name, other.name);
	}
	
}