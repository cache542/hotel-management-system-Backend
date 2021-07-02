package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.models.Customer;

@Repository
public interface IcustomerRepository  extends JpaRepository<Customer, Integer> {
	
	public Customer findByEmailId(String emailId);
	public Customer findByCustomerId(int customerId);


}
