package com.hms.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.models.Booking;
import com.hms.repository.IbookingRepository;

@Service
public class BookingServiceImpl implements IbookingService {

	@Autowired
	public IbookingRepository bookingRepository;

// add booking
	@Override
	public Booking addBooking(Booking booking) {
		return this.bookingRepository.save(booking);
	}

// find all bookings
	@Override
	public List<Booking> findAll() {
		return this.bookingRepository.findAll();
	}

// delete the booking
	@Override
	public boolean removeBooking(int bookingId) throws Exception {
		if (bookingRepository.findByBookingId(bookingId) != null) {
			bookingRepository.deleteById(bookingId);
			return true;
		} else {
			throw new Exception("Booking record not found!!");
		}
	}

	// generate bill
	@Override
	public double genrateBill(int bookingId) throws ParseException {
		Optional<Booking> foundBooking = bookingRepository.findById(bookingId);

		Booking data = bookingRepository.findByBookingId(bookingId);
		int noOfDays = data.getDaysOfStay();
		double ratePerDay = data.getRoom().getRoomRate();

		double total = noOfDays * ratePerDay;
		if (foundBooking.isPresent()) {
			Booking reqBook = foundBooking.get();
			reqBook.setTotalPrice(total);
			bookingRepository.save(reqBook);
		}
		return total;
	}
// find the checkout date
	@Override
	public Booking findCheckOutDate(int bookingId, Date checkInDate, int noOfDays) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String checkin = sdf.format(checkInDate);
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(checkin));
		c.add(Calendar.DATE, noOfDays);  // number of days to add
		Date checkOut = sdf.parse(sdf.format(c.getTime()));//  Checkout date
		
		Optional<Booking> foundBooking = bookingRepository.findById(bookingId);
		Booking reqBook = foundBooking.get();
		reqBook.setCheckOutDate(checkOut);		
		return bookingRepository.save(reqBook);	}

	// get bookings after the current date/upcoming bookings
	@Override
	public List<Booking> findBooking(int customerId) {
		// TODO Auto-generated method stub
		List<Booking> all=new ArrayList<>();
		List<Booking> onlyWithCID=new ArrayList<>();//for the specific customer only
		Date d=new Date();
		if (bookingRepository.findAll() != null) {
			all=bookingRepository.findAll();
			for(Booking b:all) {
				if(b.getCustomer().getCustomerId()==customerId && b.getCheckInDate().after(d)) {
					onlyWithCID.add(b);
				}
			}
			return onlyWithCID;
		}
		return null;
	}

	// find old bookings/previous bookings
	@Override
	public List<Booking> findOldBooking(int customerId) {
		List<Booking> all=new ArrayList<>();
		List<Booking> onlyWithCID=new ArrayList<>();//for specific customer only
		Date d=new Date();
		if (bookingRepository.findAll() != null) {
			all=bookingRepository.findAll();
			for(Booking b:all) {
				if(b.getCustomer().getCustomerId()==customerId && b.getCheckOutDate().before(d)) {
					onlyWithCID.add(b);
				}
			}
			return onlyWithCID;
		}
		return null;
	}
// find booking by id
	@Override
	public Booking getBooking(int bookingId) {
		// TODO Auto-generated method stub
		Booking data = bookingRepository.findByBookingId(bookingId);
		return data;
	}

}
