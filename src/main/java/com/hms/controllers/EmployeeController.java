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

import com.hms.models.Employee;
import com.hms.services.IemployeeService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	
	@Autowired
	private IemployeeService employeeService;
	
	//get all employee details
	@GetMapping("/allemp")
	public List<Employee> getCustomer() {
		return this.employeeService.findAll();
	}
	// get employee based on id
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return this.employeeService.findById(id);
	}
	
	//delete employee on id
	@DeleteMapping("/deleteemp/{id}")
	public void removeEmployee(@PathVariable("id") int employeeId) throws Exception {
		try {
		employeeService.removeEmployee(employeeId);
		logger.info("Employee details deleted");
		}catch(Exception e) {
			logger.error("Exception occurred No employee found");
		}
	}
	
	//create employee
	@PostMapping("/")
	public Employee createEmployee(@RequestBody Employee employee) throws Exception {
		try {
			Employee local=this.employeeService.createEmployee(employee);
			logger.info("Employee added");
			return local;
		} catch (Exception e) {
			logger.error("Exception Occurred Employee already present");
			return null;
		} 
	}
	
	// update employee
	@PutMapping("/updateEmployee/{id}")
	public Employee modifyEmployee(@PathVariable int id,@RequestBody Employee updatedEmployee) throws Exception {
		try {
			Employee local= employeeService.updateEmployee(updatedEmployee, id);
			logger.info("Employee details updated successfully");
			return local;
		}catch (Exception e) {
			logger.error("Exception Occurred No employee found");
			return null;
		} 
	}
}
