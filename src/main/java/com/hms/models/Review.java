package com.hms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "review_generator")
	private int reviewId;
	@Column(length = 6000)
	private String reviews;
	private int star;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bookingId", referencedColumnName = "bookingId")
	private Booking booking;

	// constructors
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(int reviewId, String reviews, int star, Booking booking) {
		super();
		this.reviewId = reviewId;
		this.reviews = reviews;
		this.star = star;
		this.booking = booking;
	}

	// getter and setter
	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

}
