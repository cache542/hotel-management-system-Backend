package com.hms.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.models.Customer;
import com.hms.services.IcustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private IcustomerService customerService;

	// creating customer
	@PostMapping("/")
	public Customer createCustomer(@RequestBody Customer customer) throws Exception {

		try {
			Customer local = this.customerService.createCustomer(customer);
			logger.info("Customer created");
			return local;
		} catch (Exception e) {
			logger.error("Exception Occurred Customer already present");
			return null;
		}

	}

	// get customer by email
	@GetMapping("/{emailId}")
	public Customer getCustomer(@PathVariable String emailId) throws Exception {
		try {
			Customer local = this.customerService.getCustomer(emailId);
			logger.info("Get Customer successful");
			return local;
		} catch (Exception e) {
			logger.error("Exception occurred No customer found");
			return null;
		}
	}

	// get list of customer
	@GetMapping("/all")
	public List<Customer> getCustomer() {
		return this.customerService.findAll();
	}

	// deleting customer based on id
	@DeleteMapping("/deleteCustomer/{id}")
	public void removeCustomer(@PathVariable("id") int customerId) throws Exception {
		try {
			customerService.removeCustomer(customerId);
			logger.info("Customer deleted");
		} catch (Exception e) {
			logger.error("Exception occurred");
		}
	}

	// update customer
	// implement here
	@PutMapping("/updateCustomer/{id}")
	public Customer modifyCustomer(@PathVariable int id, @RequestBody Customer updatedCustomer) throws Exception {
		try {
			Customer local = this.customerService.updateCustomer(updatedCustomer, id);
			logger.info("Customer detials updated successfully");
			return local;
		} catch (Exception e) {
			logger.error("Exception occurred No customer found");
			return null;
		}
	}

}
