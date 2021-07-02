package com.hms.controllers;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.models.Booking;
import com.hms.services.IbookingService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/booking")
public class BookingController {
	Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	@Autowired
	private IbookingService bookingService;
	
	// create booking
	@PostMapping("/")
	public Booking createBooking(@RequestBody Booking booking) throws ParseException{
		Booking local =  this.bookingService.addBooking(booking);
		this.bookingService.findCheckOutDate(local.getBookingId(),local.getCheckInDate(),local.getDaysOfStay());
		this.bookingService.genrateBill(local.getBookingId());
		return local;
		
	}
	
	// get all booking
	@GetMapping("/allBooking")
	public List<Booking> findAll(){
		return this.bookingService.findAll();
	}
	
	// delete booking
	@DeleteMapping("/deleteBooking/{id}")
	public void removeBooking(@PathVariable("id") int bookingId) throws Exception {
		try {
		bookingService.removeBooking(bookingId);
		logger.info("Booking deleted successfully");
		}catch(Exception e) {
			logger.error("Exception occurred No booking found");
		}
	}
	@GetMapping("/allBooking/getBooking/{bookingId}")
	public Booking getBooking(@PathVariable int bookingId ) throws ParseException {
		return this.bookingService.getBooking(bookingId);
	}
	// get total amount/get bill
		@GetMapping("/getBill/{bookingId}")
		public double getBill(@PathVariable int bookingId ) throws ParseException {
			return this.bookingService.genrateBill(bookingId);
		}
	//get all upcoming Booking for customer
		@GetMapping("/getBooking/{customerId}")
		public List<Booking> getBookings(@PathVariable int customerId ) throws ParseException {
			return this.bookingService.findBooking(customerId);
		}
		
		//get all old bookings for customer
		@GetMapping("/getOldBooking/{customerId}")
		public List<Booking> getOldBookings(@PathVariable int customerId ) throws ParseException {
			return this.bookingService.findOldBooking(customerId);
		}


}
