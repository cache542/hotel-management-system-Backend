package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.models.Employee;

@Repository
public interface IemployeeRepository extends JpaRepository<Employee, Integer>{
	
	public Employee findByEmployeeId(int employeeId);

	public Employee findByPan(String pan);

}
