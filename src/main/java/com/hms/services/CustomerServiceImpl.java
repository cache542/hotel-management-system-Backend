package com.hms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.hms.models.Customer;
import com.hms.repository.IcustomerRepository;

@Service
public class CustomerServiceImpl implements IcustomerService {

	@Autowired
	private IcustomerRepository customerRepository;

	// creating user
	@Override
	public Customer createCustomer(Customer customer) throws Exception {

		Customer local = this.customerRepository.findByEmailId(customer.getEmailId());

		if (local != null) {
			//exception
			throw new Exception("Customer already present");
		} else {
			System.out.println("Customer is not There!!");
			System.out.println("Creating new Customer");
			// create user
			local = this.customerRepository.save(customer);
		}

		return local;
	}

//getting customer by email-id
	@Override
	public Customer getCustomer(String emailId) throws Exception {
		Customer local= customerRepository.findByEmailId(emailId);
		if(local!= null) {
			return this.customerRepository.findByEmailId(emailId);
		}else {
			throw new Exception("Email id not registered!!");
		}
		
	}

//get all customer list
	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return this.customerRepository.findAll();
	}

// delete customer
	@Override
	public boolean removeCustomer(int customerId) throws Exception {
		if (customerRepository.findByCustomerId(customerId) != null) {
			customerRepository.deleteById(customerId);
			return true;
		} else {
			//exception
			throw new Exception("This customer doesnot exist!!");
		}
	}

	// update customer
	@Override
	public Customer updateCustomer(Customer updatedCustomer, int id) throws Exception {
		Optional<Customer> foundCustomer = customerRepository.findById(id);
		if (foundCustomer.isPresent()) {
			Customer reqCust = foundCustomer.get();
			reqCust.setFirstName(updatedCustomer.getFirstName());
			reqCust.setLastName(updatedCustomer.getLastName());
			reqCust.setPassword(updatedCustomer.getPassword());
			reqCust.setPhone(updatedCustomer.getPhone());
			return customerRepository.save(reqCust);
		} else {
			//exception
			throw new Exception("This customer doesnot exist!!");
		}
	}

}
