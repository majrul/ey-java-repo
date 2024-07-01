package com.ey.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ey.model.Passenger;
import com.ey.model.Pnr;
import com.ey.model.Passenger.Gender;
import com.ey.model.Passenger.Status;

@RestController
public class PnrController {

	@GetMapping("/pnr-status")
	public Pnr checkStatus(@RequestParam int pnrNo) {
		//for the time being we will hardcode the data and send it
		Pnr pnr = new Pnr();
		pnr.setPnrNo(pnrNo);
		pnr.setTrainNo(12345);
		pnr.setTravelDate(LocalDate.of(2024, 7, 10));
		
		List<Passenger> passengers = new ArrayList<>();
		Passenger p1 = new Passenger();
		p1.setName("John");
		p1.setGender(Gender.MALE);
		p1.setStatus(Status.RAC);

		Passenger p2 = new Passenger();
		p2.setName("Smith");
		p2.setGender(Gender.MALE);
		p2.setStatus(Status.CONFIRMED);
		
		passengers.add(p1);
		passengers.add(p2);
		pnr.setPassengers(passengers);
		
		return pnr;
	}
}
