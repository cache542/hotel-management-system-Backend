package com.hms.services;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.hms.models.Booking;

public interface IbookingService {
	public Booking addBooking(Booking booking);

	public List<Booking> findAll();
	public Booking getBooking(int bookingId);

	public boolean removeBooking(int bookingId) throws Exception;

	public double genrateBill(int bookingId) throws ParseException;

	public Booking findCheckOutDate(int bookingId, Date checkInDate, int noOfDays) throws ParseException;
	
	public List<Booking> findBooking(int customerId);
	
	public List<Booking> findOldBooking(int customerId);
}
