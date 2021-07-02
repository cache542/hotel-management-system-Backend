package com.hms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.models.Review;
import com.hms.services.IreviewService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	private IreviewService reviewService;

	@PostMapping("/")
	public Review addReview(@RequestBody Review review) {
		return reviewService.addReview(review);
	}

	@GetMapping("/allReview")
	public List<Review> findAll() {
		return this.reviewService.findAll();
	}
}
