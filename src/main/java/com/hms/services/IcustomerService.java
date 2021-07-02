package com.hms.services;

import java.util.List;

import com.hms.models.Customer;

public interface IcustomerService {

	public Customer createCustomer(Customer customer) throws Exception;

	public Customer getCustomer(String emailId) throws Exception;

	public List<Customer> findAll();

	public boolean removeCustomer(int customerId) throws Exception;

	public Customer updateCustomer(Customer updatedCustomer, int id) throws Exception;

}
