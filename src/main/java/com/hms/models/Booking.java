package com.hms.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "booking_generator")
	private int bookingId;
	
	@Temporal(TemporalType.DATE)
	private Date bookingDate;
	
	@Temporal(TemporalType.DATE)
	private Date checkInDate;
	private int daysOfStay;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="customerId", referencedColumnName = "customerId")
	private Customer customer;

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="roomId", referencedColumnName = "roomId")
	private Room room;
	
	@Temporal(TemporalType.DATE)
	private Date checkOutDate;
	private String bookingStatus;
	private double totalPrice;
	
	@OneToMany(mappedBy="booking",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Review> reviews;
	
	@OneToMany(mappedBy="booking",cascade = CascadeType.ALL)
	@JsonIgnore
	List<RoomService> services;

	
	//constructors
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(int bookingId, Date bookingDate, Date checkInDate, int daysOfStay, Customer customer, Room room,
			Date checkOutDate, String bookingStatus, double totalPrice, List<Review> reviews) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.checkInDate = checkInDate;
		this.daysOfStay = daysOfStay;
		this.customer = customer;
		this.room = room;
		this.checkOutDate = checkOutDate;
		this.bookingStatus = bookingStatus;
		this.totalPrice = totalPrice;
		this.reviews = reviews;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public int getDaysOfStay() {
		return daysOfStay;
	}

	public void setDaysOfStay(int daysOfStay) {
		this.daysOfStay = daysOfStay;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	

}
