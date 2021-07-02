package com.hms.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "roomservice")
public class RoomService {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int serviceId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="bookingId", referencedColumnName = "bookingId")
	private Booking booking;
	
	private String service;

	public RoomService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomService(Booking booking, String service) {
		super();
		this.booking = booking;
		this.service = service;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
	
	

}
