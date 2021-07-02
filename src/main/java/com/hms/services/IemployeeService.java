package com.hms.services;

import java.util.List;

import com.hms.models.Employee;

public interface IemployeeService {

	public List<Employee> findAll();

	public Employee createEmployee(Employee employee) throws Exception;

	public boolean removeEmployee(int employeeId) throws Exception;

	public Employee updateEmployee(Employee updatedEmployee, int id) throws Exception;

	public Employee findById(int id);

}
