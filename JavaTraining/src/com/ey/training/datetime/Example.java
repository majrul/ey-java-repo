package com.ey.training.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
		LocalDate d = LocalDate.now();
		LocalTime t = LocalTime.now();
		LocalDateTime dt = LocalDateTime.now();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter your date of joining the company (yyyy-MM-dd)");
		String doj = s.nextLine();
		LocalDate dateOfJoining = LocalDate.parse(doj);
		System.out.println(dateOfJoining);
		
		System.out.println("Enter your date of joining the company (dd-MM-yyyy)");
		doj = s.nextLine();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		dateOfJoining = LocalDate.parse(doj, dtf);
		System.out.println(dateOfJoining);
		dtf = DateTimeFormatter.ofPattern("MMMM-dd-yyyy");
		System.out.println(dateOfJoining.format(dtf));
		
		//suppose we want to find out how many days/months/years the employee has spent in the org.
		LocalDate todaysDate = LocalDate.now();
		Period period = Period.between(dateOfJoining, todaysDate);
		System.out.println("Employee has spent " + period.getYears() + " year(s), " + period.getMonths() + " month(s), " + period.getDays() +" day(s)");
		//suppose we want to find out total no. of days the employee has spent in the org.
		long days = ChronoUnit.DAYS.between(dateOfJoining, todaysDate);
		System.out.println("Employee has spent " + days +" days in the org.");
		long months = ChronoUnit.MONTHS.between(dateOfJoining, todaysDate);
		System.out.println("Employee has spent " + months +" months in the org.");
		
		
		LocalDate creditCardExpiryDate = LocalDate.of(2024, 6, 24);
		
		//how will we write the condition for validating the credit card
		//card is valid if the expirydate >= todaysdate
		if(creditCardExpiryDate.isAfter(todaysDate) || creditCardExpiryDate.isEqual(todaysDate))
			System.out.println("card is valid");
		else
			System.out.println("card has expired");
		
		
		//suppose i want to display the time right now in new york
		ZoneId zone = ZoneId.of("America/New_York");
		LocalTime timeinNY = LocalTime.now(zone);
		System.out.println(timeinNY);
		
		LocalDate dts = LocalDate.now();
		Month m = dts.getMonth();
		if(m == Month.JUNE)
			System.out.println("yes it is june");
		System.out.println(m);
		
		
	}
}
