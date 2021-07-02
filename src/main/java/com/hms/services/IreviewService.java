package com.hms.services;

import java.util.List;

import com.hms.models.Review;

public interface IreviewService {
	public Review addReview(Review review);
	public List<Review> findAll();
	

}
