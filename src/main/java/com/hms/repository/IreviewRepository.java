package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.models.Review;

@Repository
public interface IreviewRepository extends JpaRepository<Review, Integer>{

}
