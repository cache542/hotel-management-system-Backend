package com.hms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.models.Review;
import com.hms.repository.IreviewRepository;

@Service
public class ReviewServiceImpl implements IreviewService{

	@Autowired
	IreviewRepository reviewRepository;
	
	//add reviews
	@Override
	public Review addReview(Review review) {
		// TODO Auto-generated method stub
		return this.reviewRepository.save(review);
	}
	
//get all reviews
	@Override
	public List<Review> findAll() {
		// TODO Auto-generated method stub
		return this.reviewRepository.findAll();
	}
	
	//delete review if required

}
